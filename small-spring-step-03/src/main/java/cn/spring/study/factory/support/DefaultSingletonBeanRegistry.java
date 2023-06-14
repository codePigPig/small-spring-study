package cn.spring.study.factory.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangzhibu
 * @date 2023/3/7 22:56:22
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{

    /**
     * 单例Bean映射
     */
    private final Map<String, Object> singletonBeanMap = new ConcurrentHashMap<>();

    /**
     * 获取bean单例
     *
     * @param beanName Bean名称
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/07
     */
    @Override
    public Object getSingleton(String beanName) {
        return singletonBeanMap.get(beanName);
    }

    /**
     * 添加单例Bean
     *
     * @param beanName Bean名称
     * @param object   对象
     * @author wangzhibu
     * @date 2023/03/07
     */
    protected void addSingletonBean(String beanName, Object object) {
        singletonBeanMap.put(beanName, object);
    }
}
