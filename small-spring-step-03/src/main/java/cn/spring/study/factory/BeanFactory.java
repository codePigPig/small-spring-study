package cn.spring.study.factory;

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
    Object getBean(String name);

    /**
     * 获取Bean， 指定构造参数
     *
     * @param beanName Bean名称
     * @param args     ARGS
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/07
     */
    Object getBean(String beanName, Object... args);
}
