package cn.spring.study.beans.factory.config;

/**
 * Bean 的引用
 *
 * @author wangzhibu
 * @date 2023/6/14 11:44:20
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
