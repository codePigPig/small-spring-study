package cn.spring.study.factory;

/**
 * bean 工厂，只对外提供获取 bean 实例
 *
 * @author wangzhibu
 * @date 2023/3/6 20:41:36
 */
public interface BeanFactory {

    /**
     * 获取Bean
     *
     * @param beanName Bean名称
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/06
     */
    Object getBean(String beanName);

}
