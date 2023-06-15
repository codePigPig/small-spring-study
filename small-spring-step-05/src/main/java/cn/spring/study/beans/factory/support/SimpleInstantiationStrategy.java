package cn.spring.study.beans.factory.support;

import cn.spring.study.beans.factory.config.BeanDefinition;
import cn.spring.study.beans.factory.config.BeansException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * JDK 实例化策略
 *
 * @author wangzhibu
 * @date 2023/3/7 23:33:01
 */
public class SimpleInstantiationStrategy implements  InstantiationStrategy{

    /**
     * 实例化
     *
     * @param beanName       Bean名称
     * @param beanDefinition Bean定义
     * @param ctor           构造器
     * @param args           ARGS
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/07
     */
    @Override
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor, Object[] args) {
        // step1：获取bean class
        Class beanClass = beanDefinition.getBeanClass();
        try {
            // step2： 判断是否存在构造器
            if (null != ctor) {
                // step3：存在，如果构造方法 ctor 不为 null，则调用该构造方法，并传入参数列表 args 实例化对象
                return beanClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                // step4：如果构造方法 ctor 为 null，则使用默认无参构造方法实例化对象。
                return beanClass.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate '"+ beanClass.getName() +"'", e);
        }
    }
}
