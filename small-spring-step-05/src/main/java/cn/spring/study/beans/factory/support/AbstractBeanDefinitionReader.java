package cn.spring.study.beans.factory.support;

import cn.spring.study.core.io.DefaultResourceLoader;
import cn.spring.study.core.io.ResourceLoader;

/**
 * 提供获取 bean注册接口 和 资源加载器
 * 这是一个抽象类，实现了BeanDefinitionReader接口，并提供了一些基本的功能，比如设置和获取资源加载器、设置和获取Bean类加载器等。
 * 大多数BeanDefinitionReader的实现通常会选择继承这个抽象类，以复用其提供的基础功能
 *
 *
 * @author wangzhibu
 * @date 2023/6/15 17:04:01
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    /**
     * 有参构造，根据 BeanDefinitionRegistry
     *
     * @param registry bean定义注册
     * @return
     * @author wangzhibu
     * @date 2023/06/15
     */
    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }


    /**
     * 获取注册表
     *
     * @return {@link BeanDefinitionRegistry }
     * @author wangzhibu
     * @date 2023/06/15
     */
    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    /**
     * 获取资源加载器
     *
     * @return {@link ResourceLoader }
     * @author wangzhibu
     * @date 2023/06/15
     */
    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
