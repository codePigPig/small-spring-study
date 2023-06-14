package cn.spring.study.factory.config;

/**
 * bean定义
 *
 * @author wangzhibu
 * @date 2023/3/7 22:29:03
 */
public class BeanDefinition {

    /**
     * Bean类
     */
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
