package cn.spring.study.beans.factory;

import cn.spring.study.beans.factory.config.BeanDefinition;
import cn.spring.study.beans.factory.config.BeansException;

/**
 * Bean 定义注册表
 *
 * @author wangzhibu
 * @date 2023/6/15 16:47:20
 */
public interface BeanDefinitionRegistry {

    /**
     * 根据 Bean 名称和 Bean定义，注册到 注册表中
     *
     * @param beanName       Bean名称
     * @param beanDefinition Bean定义
     * @author wangzhibu
     * @date 2023/06/15
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 根据 Bean 名称 获取指定的 BeanDefinition
     *
     * @return {@link BeanDefinition }
     * @author wangzhibu
     * @date 2023/06/15
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断注册表中是否包含指定名称的 BeanDefinition
     * @param beanName Bean名称
     * @return boolean
     * @author wangzhibu
     * @date 2023/06/15
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回注册表中所有的 Bean 名称
     *
     * @return {@link String[] }
     * @author wangzhibu
     * @date 2023/06/15
     */
    String[] getBeanDefinitionNames();


}
