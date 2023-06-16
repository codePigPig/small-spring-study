package cn.spring.study.beans.factory.config;

import cn.spring.study.beans.factory.BeanFactory;

/**
 * Extension of the {@link cn.bugstack.springframework.beans.factory.BeanFactory}
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 *
 * 扩展{@cn.bugstack.springframework.beans.factory.BeanFactory}链接
 * 接口由Bean工厂实现，能够自动装配，前提是他们想要公开此功能 现有的Bean实例。
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
}
