package cn.spring.study.factory.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 单例注册，职业：提供对外新增单例注册表、根据beanName获取注册表
 *
 * @author wangzhibu
 * @date 2023/3/6 21:24:28
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{


    /**
     * 单例Bean映射，单例注册表，key：beanName、value：bean实例
     */
    private final Map<String, Object> singletonBeanMap = new ConcurrentHashMap<>();

    /**
     * 获取单例bean对象，根据bean名称，获取bean
     *
     * @param beanName Bean名称
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/06
     */
    @Override
    public Object getSingleton(String beanName) {
        return singletonBeanMap.get(beanName);
    }

    /**
     * 添加单例
     *
     * @param beanName Bean名称
     * @param object   对象
     * @author wangzhibu
     * @date 2023/03/06
     */
    public void addSingleton(String beanName, Object object) {
        singletonBeanMap.put(beanName, object);
    }
}
