package cn.spring.study.beans.factory.config;

import cn.spring.study.beans.factory.HierarchicalBeanFactory;

/**
 *  Configuration interface to be implemented by most bean factories. Provides
 *  facilities to configure a bean factory, in addition to the bean factory
 *  client methods in the {@link cn.bugstack.springframework.beans.factory.BeanFactory}
 *  interface.
 *
 * 将由大多数Bean工厂实现的配置接口。
 * 除了{@LINK cn.bugstack.springframework.beans.factory.BeanFactory}接口中的Bean工厂客户端方法外，
 * 还提供配置Bean工厂的工具
 *
 *
 * @author wangzhibu
 * @date 2023/6/15 20:03:23
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    /**
     * 范围单例
     */
    String SCOPE_SINGLETON = "singleton";

    /**
     * 作用域原型
     */
    String SCOPE_PROTOTYPE = "prototype";

}
