package cn.spring.study.beans.factory.support;

import cn.spring.study.beans.BeansException;
import cn.spring.study.core.io.Resource;
import cn.spring.study.core.io.ResourceLoader;

/**
 * 定义 bean 的读取相关接口
 *
 * @author wangzhibu
 * @date 2023/6/15 16:44:31
 */
public interface BeanDefinitionReader {

    /**
     * 获取注册表
     *
     * @return {@link cn.spring.study.beans.factory.BeanDefinitionRegistry }
     * @author wangzhibu
     * @date 2023/06/15
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器
     *
     * @return {@link ResourceLoader }
     * @author wangzhibu
     * @date 2023/06/15
     */
    ResourceLoader getResourceLoader();


    /**
     * 加载Bean定义，根据单个资源
     *
     * @param resource 资源
     * @author wangzhibu
     * @date 2023/06/15
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * 加载Bean定义，根据一个或者多个资源
     *
     * @param resources 资源
     * @author wangzhibu
     * @date 2023/06/15
     */
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 加载Bean定义，根据地址
     *
     * @param location 位置
     * @author wangzhibu
     * @date 2023/06/15
     */
    void loadBeanDefinitions(String location) throws BeansException;







}
