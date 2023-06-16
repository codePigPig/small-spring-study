package cn.spring.study.beans.factory;

import cn.spring.study.beans.BeansException;

import java.util.Map;

/**
 *  * Extension of the {@link BeanFactory} interface to be implemented by bean factories
 *  * that can enumerate all their bean instances, rather than attempting bean lookup
 *  * by name one by one as requested by clients. BeanFactory implementations that
 *  * preload all their bean definitions (such as XML-based factories) may implement
 *  * this interface.
 * Bean工厂将实现的{@link BeanFactory}接口的扩展, 可以枚举其所有Bean实例，而不是尝试查找Bean,
 * 应客户要求，逐一点名。BeanFactory实现, 预加载其所有的Bean定义(如基于XML的工厂)可以实现
 *
 * @author wangzhibu
 * @date 2023/6/15 19:57:30
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 按照类型返回 Bean 实例
     *
     * @param type 类型
     * @return {@link Map }<{@link String }, {@link T }>
     * @author wangzhibu
     * @date 2023/06/15
     */
    <T>Map<String, T> getBeansOfType(Class<T> type) throws BeansException;


    /**
     * 返回注册表中所有的Bean名称
     *
     * @return {@link String[] }
     * @author wangzhibu
     * @date 2023/06/15
     */
    String[] getBeanDefinitionNames();
}
