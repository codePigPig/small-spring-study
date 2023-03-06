package cn.spring.study.factory.support;

import cn.spring.study.factory.config.BeanDefinition;
import cn.spring.study.factory.config.BeansException;

/**
 * @author wangzhibu
 * @date 2023/3/6 21:11:28
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    /**
     * 创建Bean
     *
     * @param beanName       Bean名称
     * @param beanDefinition Bean定义
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/06
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException{
        Object bean;
        // step1：在运行时创建指定类的新实例
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // step2：将获取到的类，添加到单例工厂中
        addSingleton(beanName, bean);
        return bean;
    }

}
