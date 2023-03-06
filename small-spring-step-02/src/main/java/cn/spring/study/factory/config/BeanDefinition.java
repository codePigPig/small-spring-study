package cn.spring.study.factory.config;

/**
 * 用于存放对象Class，Bean的是实例化放在容器中操作
 *
 * @author wangzhibu
 * @date 2023/3/6 20:37:46
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
