package cn.spring.study.test;

import cn.hutool.core.io.IoUtil;
import cn.spring.study.beans.PropertyValue;
import cn.spring.study.beans.PropertyValues;
import cn.spring.study.beans.factory.BeanFactory;
import cn.spring.study.beans.factory.config.BeanDefinition;
import cn.spring.study.beans.factory.config.BeanReference;
import cn.spring.study.beans.factory.support.DefaultListableBeanFactory;
import cn.spring.study.beans.factory.xml.XmlBeanDefinitionReader;
import cn.spring.study.core.io.DefaultResourceLoader;
import cn.spring.study.core.io.Resource;
import cn.spring.study.test.bean.UserDao;
import cn.spring.study.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author wangzhibu
 * @date 2023/3/7 21:39:02
 */
public class ApiTest {


    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    /**
     * 测试bean工厂
     *
     * @author wangzhibu
     * @date 2023/03/07
     */
    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String context = IoUtil.readUtf8(inputStream);
        System.out.println(context);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String context = IoUtil.readUtf8(inputStream);
        System.out.println(context);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("URL");
        InputStream inputStream = resource.getInputStream();
        String context = IoUtil.readUtf8(inputStream);
        System.out.println(context);
    }

    @Test
    public void test_xml() {
        // step1: 初始化 BeanFactory 工厂，
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // step2: 读取配置文件 并 注册 bean到注册中
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // step3: 获取 bean 对象并调用
        UserService userService = beanFactory.getBean("userService", UserService.class);

        userService.queryUserInfo();

    }
}
