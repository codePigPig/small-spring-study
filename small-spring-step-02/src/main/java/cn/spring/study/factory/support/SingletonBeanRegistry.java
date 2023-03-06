package cn.spring.study.factory.support;

/**
 * 单例Bean注册表，职责：对外提供获取单例的接口
 *
 * @author wangzhibu
 * @date 2023/3/6 21:22:54
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例bean对象
     *
     * @param beanName Bean名称
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/06
     */
    Object getSingleton(String beanName);
}
