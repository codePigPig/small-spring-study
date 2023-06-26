package cn.spring.study.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import cn.spring.study.beans.PropertyValue;
import cn.spring.study.beans.factory.config.BeanDefinition;
import cn.spring.study.beans.factory.config.BeanReference;
import cn.spring.study.beans.BeansException;
import cn.spring.study.beans.factory.support.AbstractBeanDefinitionReader;
import cn.spring.study.beans.factory.support.BeanDefinitionRegistry;
import cn.spring.study.core.io.Resource;
import cn.spring.study.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * 这个类是AbstractBeanDefinitionReader的子类，专门用于从XML文件中加载和读取BeanDefinition。
 * 在XML配置文件中，每个<bean>元素都会被转换成一个BeanDefinition对象。
 * 然后这些BeanDefinition会被注册到Spring的BeanFactory中，等待后续的创建和配置。
 *
 * @author wangzhibu
 * @date 2023/6/15 17:10:10
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    /**
     * 有参构造，根据 BeanDefinitionRegistry
     *
     * @param registry bean定义注册
     * @return
     * @author wangzhibu
     * @date 2023/06/15
     */
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    /**
     * 加载Bean定义，根据单个资源
     *
     * @param resource 资源
     * @author wangzhibu
     * @date 2023/06/15
     */
    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()){
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from" + resource, e);
        }
    }

    /**
     * 加载Bean定义，根据一个或者多个资源
     *
     * @param resources 资源
     * @author wangzhibu
     * @date 2023/06/15
     */
    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    /**
     * 加载Bean定义，根据地址
     *
     * @param location 位置
     * @author wangzhibu
     * @date 2023/06/15
     */
    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    /**
     * 加载Bean定义
     *
     * @param inputStream 输入流
     * @author wangzhibu
     * @date 2023/06/15
     */
    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        // step1: 使用 xmlUtil 工具类从输入流读取 XML 文档
        Document doc = XmlUtil.readXML(inputStream);
        // step2: 获取文本的 根元素
        Element element = doc.getDocumentElement();
        // step3: 获取根元素的所有子节点
        NodeList childNodes = element.getChildNodes();
        // step4: 遍历所有子子节点
        for (int i = 0; i < childNodes.getLength(); i++) {
//            Node node = childNodes.item(i);
            // step5: 如果当前节点不是元素类型（如注释或者文本节点），则跳过
            if (!(childNodes.item(i) instanceof Element)) {
                continue;
            }
            // step6: 判断当前元素的标签名不是 "bean", 则跳过
            if (!"bean".equals(childNodes.item(i).getNodeName())) {
                continue;
            }
            // step7: 将子节点转换为 元素，以便获取其属性
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            // step8: 使用完全限定类名加载类
            Class<?> clazz = Class.forName(className);
            // step9: 如果 id 属性不为空，则使用 id 作为 bean 的名字，否则，使用 name 作为 bean的名字
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            // step10: 如果 id 和 name 都没有指定，那么使用类名（首字母小写）作为 bean 的名字
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // step10: 创建一个新的 BeanDefinition 对象，以 Clazz
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            // step11: 遍历 bean 元素的所有子节点，为 BeanDefinition 填充属性问题
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                Node childNode=  bean.getChildNodes().item(j);
                // step12: 如果当前节点不是元素类型（如注释或者文本节点），则跳过
                if (!(childNode instanceof Element)) {
                    continue;
                }
                // step13: 如果当前元素的标签名不是 "property"，则跳过
                if (!"property".equals(childNode.getNodeName())) {
                    continue;
                }
                // step14: 获取 property 元素的 name、value、ref 属性
                Element childElement = (Element) childNode;
                String childName = childElement.getAttribute("name");
                String childValue = childElement.getAttribute("value");
                String childRef = childElement.getAttribute("ref");

                // step14: 如果 ref 属性不为空，则创建一个新的 BeanReference 对象，否则，则直接用 value 属性的值
                Object value = StrUtil.isNotEmpty(childRef) ? new BeanReference(childRef) : childValue;

                // step15: 根据属性名和属性值，创建 PropertyValue 对象
                PropertyValue propertyValue = new PropertyValue(childName, value);
                // step16: 将属性或者依赖对象，加入到集合对象中
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName [" + beanName + "] is not allowed");
            }
            // step17: 注册 BeanDefinition 到注册表中
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }




    }
}
