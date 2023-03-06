package cn.spring.study;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean 工厂，实现了 Bean的注册、获取 Bean 的操作。（后续会补充更多实现
 *
 * @author wangzhibu
 * @date 2022/11/13 15:42:48
 */
public class BeanFactory {

    /**
     * Bean定义映射, key: bean名称， value: bean定义类
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    /**
     * 获取Bean
     *
     * @param name bean名称
     * @return {@link Object }
     */
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    /**
     * 注册Bean定义
     *
     * @param name          bean名称
     * @param beanDefinition Bean定义
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
