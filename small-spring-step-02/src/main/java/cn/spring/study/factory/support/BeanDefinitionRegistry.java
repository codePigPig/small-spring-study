package cn.spring.study.factory.support;

import cn.spring.study.factory.config.BeanDefinition;

/**
 * Bean定义注册表，对外只提供 bea注册接口
 *
 * @author wangzhibu
 * @date 2023/3/6 20:53:26
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册Bean定义，根据 name和bean定义，讲bean注册到注册表中（hashMap）
     *
     * @param beanName       Bean名称
     * @param beanDefinition Bean定义
     * @author wangzhibu
     * @date 2023/03/06
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
