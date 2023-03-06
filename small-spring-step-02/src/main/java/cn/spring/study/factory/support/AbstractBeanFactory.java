package cn.spring.study.factory.support;

import cn.spring.study.factory.BeanFactory;
import cn.spring.study.factory.config.BeanDefinition;

/**
 * bean 工厂抽象类，职责：获取bean
 * bean 的创建和获取 bean 定义，由子类完成
 *
 * @author wangzhibu
 * @date 2023/3/6 20:43:14
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 获取Bean, 重要职责：只做获取bean的流程
     * bean是否创建，如何创建，交给子类实现
     *
     * @param beanName Bean名称
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/06
     */
    @Override
    public Object getBean(String beanName) {
        // step1：获取单例对象
        Object bean = getSingleton(beanName);
        // step2：，判断bean是否存在
        if (bean != null) {
            return bean;
        }
        // step3：bean实例不存在，创建bean并返回
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    /**
     * 创建Bean，由子类实现具体细节
     *
     * @param beanName       Bean名称
     * @param beanDefinition Bean定义
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/06
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);

    /**
     * 获取Bean定义, 如何获取定义，由子类实现具体细节
     *
     * @param beanName Bean名称
     * @return {@link BeanDefinition }
     * @author wangzhibu
     * @date 2023/03/06
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName);
}
