package cn.spring.study.beans.factory;

import cn.spring.study.beans.BeansException;

/**
 * bean 工厂接口
 *
 * @author wangzhibu
 * @date 2023/3/7 22:31:07
 */
public interface BeanFactory {

    /**
     * 获取Bean, 不指定构造参数
     *
     * @param name 名字
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/07
     */
    Object getBean(String name)throws BeansException;

    /**
     * 获取Bean， 指定构造参数
     *
     * @param beanName Bean名称
     * @param args     ARGS
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/07
     */
    Object getBean(String beanName, Object... args)throws BeansException;

    /**
     * 获取Bean，返回指定的类型
     *
     * @param name         名字
     * @param requiredType 所需类型
     * @return {@link T }
     * @author wangzhibu
     * @date 2023/06/16
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
