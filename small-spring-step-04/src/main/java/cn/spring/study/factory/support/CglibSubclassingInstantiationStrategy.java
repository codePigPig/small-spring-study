package cn.spring.study.factory.support;

import cn.spring.study.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * Cglib 实例化策略
 *
 * @author wangzhibu
 * @date 2023/3/7 23:33:21
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    /**
     * 实例化
     *
     * @param beanName       Bean名称
     * @param beanDefinition Bean定义
     * @param ctor           构造器
     * @param args           ARGS
     * @return {@link Object }
     * @author wangzhibu
     * @date 2023/03/07
     */
    @Override
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor, Object[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor) {
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
