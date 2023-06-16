package cn.spring.study.beans.factory.support;

import cn.spring.study.beans.factory.ConfigurableListableBeanFactory;
import cn.spring.study.beans.factory.config.BeanDefinition;
import cn.spring.study.beans.BeansException;
import cn.spring.study.beans.factory.config.ConfigurableBeanFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangzhibu
 * @date 2023/3/7 23:05:33
 */
public class DefaultListableBeanFactory extends AbstractAutoWireCapableBeanFactory
        implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {

    /**
     * Bean定义映射
     */
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 注册Bean定义
     *
     * @param beanName       Bean名称
     * @param beanDefinition Bean定义
     * @author wangzhibu
     * @date 2023/03/07
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }


    /**
     * 获取Bean定义, 由子类实现
     *
     * @param beanName Bean名称
     * @return {@link BeanDefinition }
     * @author wangzhibu
     * @date 2023/03/07
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName +"' is defined");
        }
        return beanDefinition;
    }

    /**
     * 根据 bean名称 判断注册表中是否包含
     *
     * @param beanName Bean名称
     * @return boolean
     * @author wangzhibu
     * @date 2023/06/15
     */
    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    /**
     * 按照类型返回 Bean 实例
     *
     * @param type 类型
     * @return {@link Map }<{@link String }, {@link T }>
     * @author wangzhibu
     * @date 2023/06/15
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        // step1: 循环遍历 bean注册表
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getBeanClass();
            // step2: 对比 bean 类型是否相同
            if (type.isAssignableFrom(beanClass)) {
                result.put(beanName, (T) getBean(beanName));
            }
        });
        return result;
    }

    /**
     * 返回注册表中所有的Bean名称
     *
     * @return {@link String[] }
     * @author wangzhibu
     * @date 2023/06/15
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }
}
