package cn.spring.study.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.spring.study.beans.factory.config.BeanDefinition;
import cn.spring.study.beans.factory.config.BeanReference;
import cn.spring.study.beans.factory.config.BeansException;
import cn.spring.study.beans.PropertyValue;
import cn.spring.study.beans.PropertyValues;

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
        // step1：创建Bean
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);

            // step3: 填充属性
            applyPropertyValue(beanName, bean, beanDefinition);
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


    /**
     * 填充属性值
     *
     * @param beanName       Bean名称
     * @param bean           豆子
     * @param beanDefinition Bean定义
     * @author wangzhibu
     * @date 2023/06/14
     */
    protected void applyPropertyValue(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            // step1： 获取定义好的属性
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            if (propertyValues == null || propertyValues.getPropertyValues().length < 0) {
                return;
            }
            // step2：循环处理每个属性
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                // step3：获取bean 名称
                String name = propertyValue.getName();
                // step4：获取bean 对象
                Object value = propertyValue.getValue();
                // step5：判断value 是否是 BeanReference类型的实例，
                if (value instanceof BeanReference) {
                    // step6：强制转换
                    BeanReference beanReference = (BeanReference) value;
                    // step7：获取属性的 bean实例对象
                    value = getBean(beanReference.getBeanName());
                }
                // step8: 设置字段值
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName, e);
        }
    }


    /**
     * 获取实例化策略
     *
     * @return {@link InstantiationStrategy }
     * @author wangzhibu
     * @date 2023/06/14
     */
    public InstantiationStrategy getInstantiationStrategy() {
       return instantiationStrategy;
    }

    /**
     * 设置实例化策略
     *
     * @param instantiationStrategy 实例化策略
     * @author wangzhibu
     * @date 2023/06/14
     */
    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
