package cn.spring.study.factory.support;

/**
 * 单例Bean注册表
 *
 * @author wangzhibu
 * @date 2023/3/7 22:55:01
 */
public interface SingletonBeanRegistry {

    /**
     * 获取bean单例
     *
     * @param beanName Bean名称
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/07
     */
    Object getSingleton(String beanName);
}
