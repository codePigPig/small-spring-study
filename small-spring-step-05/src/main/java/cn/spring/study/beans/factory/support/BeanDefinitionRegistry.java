package cn.spring.study.beans.factory.support;

import cn.spring.study.beans.factory.config.BeanDefinition;

/**
 * bean定义注册接口
 *
 * @author wangzhibu
 * @date 2023/3/7 22:28:11
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册Bean定义
     *
     * @param beanName       Bean名称
     * @param beanDefinition Bean定义
     * @author wangzhibu
     * @date 2023/03/07
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
