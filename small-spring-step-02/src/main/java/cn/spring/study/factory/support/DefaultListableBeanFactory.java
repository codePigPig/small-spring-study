package cn.spring.study.factory.support;

import cn.spring.study.factory.config.BeanDefinition;
import cn.spring.study.factory.config.BeansException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * bean注册工厂，提供bean注册 和 根据BeanName获取Bean定义
 *
 * @author wangzhibu
 * @date 2023/3/6 20:53:01
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    /**
     *
     * Bean定义映射，相当于注册表，key：beanName、value：bean定义
     */
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 注册Bean定义，根据 name和bean定义，将bean注册到注册表中（hashMap）
     *
     * @param beanName       Bean名称
     * @param beanDefinition Bean定义
     * @author wangzhibu
     * @date 2023/03/06
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }


    /**
     * 获取Bean定义
     *
     * @param beanName Bean名称
     * @return {@link BeanDefinition }
     * @author wangzhibu
     * @date 2023/03/06
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw  new BeansException("No bean named '" + beanName +"' is defined");
        }
        return beanDefinition;
    }
}
