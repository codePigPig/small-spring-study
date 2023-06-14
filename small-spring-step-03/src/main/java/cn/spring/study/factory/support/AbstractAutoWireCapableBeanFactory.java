package cn.spring.study.factory.support;

import cn.spring.study.factory.config.BeanDefinition;
import cn.spring.study.factory.config.BeansException;

import java.lang.reflect.Constructor;

/**
 * 抽象模版方法，创建bean工厂，专注创建
 *
 * @author wangzhibu
 * @date 2023/3/7 23:03:17
 */
public abstract class AbstractAutoWireCapableBeanFactory extends AbstractBeanFactory{

    /**
     * 实例化策略
     */
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();


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
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean = null;
        // step2：创建Bean
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingletonBean(beanName, bean);
        return bean;
    }

    /**
     * 创建Bean实例，需要根据构造参数来进行创建
     *
     * @param beanName       Bean名称
     * @param beanDefinition Bean定义
     * @param args           ARGS
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/07
     */
    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Constructor constructorToUser = null;
        // step2：获取bean定义 Class
        Class beanClass = beanDefinition.getBeanClass();
        // step3：获取当前bean定义中的所有构造方法
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        // step4: 循环所有构造器，根据参数个数来确定哪个构造器，源码要需要判断参数类型
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUser = ctor;
                break;
            }
        }
        // step5: 拿到构造器了，选择实例化bean的方式
        return instantiationStrategy.instantiate(beanName, beanDefinition, constructorToUser, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
       return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
