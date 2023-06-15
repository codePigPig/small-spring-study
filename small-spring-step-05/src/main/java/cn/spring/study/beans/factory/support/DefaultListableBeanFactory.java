package cn.spring.study.beans.factory.support;

import cn.spring.study.beans.factory.config.BeanDefinition;
import cn.spring.study.beans.factory.config.BeansException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangzhibu
 * @date 2023/3/7 23:05:33
 */
public class DefaultListableBeanFactory extends AbstractAutoWireCapableBeanFactory implements BeanDefinitionRegistry{

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
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName +"' is defined");
        }
        return beanDefinition;
    }
}
