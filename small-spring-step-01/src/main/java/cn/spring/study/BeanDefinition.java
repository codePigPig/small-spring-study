package cn.spring.study;

/**
 * 用于定义 Bean 实例化信息，实现以一个 Object 存在对象。（后续会补充更多实现
 *
 * @author wangzhibu
 * @date 2022/11/13 15:39:27
 */
public class BeanDefinition {
    /**
     * bean
     */
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
