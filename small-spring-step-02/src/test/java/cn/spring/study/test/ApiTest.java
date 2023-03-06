package cn.spring.study.test;

import cn.spring.study.factory.config.BeanDefinition;
import cn.spring.study.factory.support.DefaultListableBeanFactory;
import cn.spring.study.test.bean.UserService;
import org.junit.Test;

/**
 * @author wangzhibu
 * @date 2023/3/6 20:33:00
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // step1：初始化，beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // step2：注册bean，将userService注册到bean工厂中
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // step3：第一次获取bean实例
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // step4: 第二次获取bean实例
        UserService userService_singleton = (UserService) beanFactory.getSingleton("userService");
        userService_singleton.queryUserInfo();

    }
}
