package cn.spring.study.beans.factory;

import cn.spring.study.beans.BeansException;
import cn.spring.study.beans.factory.config.AutowireCapableBeanFactory;
import cn.spring.study.beans.factory.config.BeanDefinition;
import cn.spring.study.beans.factory.config.ConfigurableBeanFactory;

/**
 *
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 *
 * 大多数Listable Bean工厂都要实现的配置接口。
 * 它提供了以下设施分析和修改Bean定义，预实例化单例。
 * @author wangzhibu
 * @date 2023/6/15 20:00:20
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
