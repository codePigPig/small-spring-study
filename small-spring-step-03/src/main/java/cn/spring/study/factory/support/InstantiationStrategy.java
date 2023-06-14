package cn.spring.study.factory.support;

import cn.spring.study.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略模版
 *
 * @author wangzhibu
 * @date 2023/3/7 23:31:36
 */
public interface InstantiationStrategy {

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
    Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor, Object[] args);
}
