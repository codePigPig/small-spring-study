package cn.spring.study.beans.factory.support;

import cn.spring.study.beans.factory.config.BeanDefinition;
import cn.spring.study.beans.factory.BeanFactory;

/**
 * bean工厂实现类，主要职业为获取bean实例
 *
 * @author wangzhibu
 * @date 2023/3/7 22:33:56
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 获取Bean, 不指定构造参数
     * 首先从单例注册表中获取，单例注册表中没有，就创建bean，
     * 创建bean的具体流程，由具体子类进行实现，
     * 获取相应的bean定义模版，由子类进行实现
     * 当前工厂类，从bean定义注册表中，根据beanName拿到bean定义模版
     * 再根据beanName和bean定义模版去创建bean实例
     *
     * @param beanName Bean名称
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/18
     */
    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName, null);
    }

    /**
     * 获取Bean， 指定构造参数
     *
     * @param beanName Bean名称
     * @param args     ARGS
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/07
     */
    @Override
    public Object getBean(String beanName, Object... args) {
       return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) {
        return (T) getBean(beanName);
    }


    /**
     * 共用获取bean
     *
     * @param beanName Bean名称
     * @param args     ARGS
     * @return {@link T }
     * @author wangzhibu
     * @date 2023/03/18
     */
    protected <T> T doGetBean(final String beanName, final Object[] args) {
        // step1：先从单例注册表中获取 bean实例
        Object bean = getSingleton(beanName);
        // step2：判断单例注册表中是否存在 bean实例
        if (bean != null) {
            return (T) bean;
        }
        // step3：不存在，根据beanName获取定义模版
        BeanDefinition beanDefinition = getBeanDefinition(beanName);

        // step4：根据beanName和bean定义创建bean实例
        return (T)createBean(beanName,beanDefinition, args);
    }

    /**
     * 获取Bean定义, 由子类实现
     *
     * @param beanName Bean名称
     * @return {@link BeanDefinition }
     * @author wangzhibu
     * @date 2023/03/07
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName);

    /**
     * 创建Bean, 由子类工厂实现
     *
     * @param beanName       Bean名称
     * @param beanDefinition Bean定义
     * @param args           ARGS
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/07
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);

}
