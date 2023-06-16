package cn.spring.study.beans.factory.support;

import cn.spring.study.beans.BeansException;
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

    /**
     * 根据 bean名称 获取bean定义
     *
     * @param beanName Bean名称
     * @return {@link BeanDefinition }
     * @author wangzhibu
     * @date 2023/06/15
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 根据 bean名称 判断注册表中是否包含
     *
     * @param beanName Bean名称
     * @return boolean
     * @author wangzhibu
     * @date 2023/06/15
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 获取注册表中所有的 bean 名称
     *
     * @return {@link String[] }
     * @author wangzhibu
     * @date 2023/06/15
     */
    String[] getBeanDefinitionNames();
}
