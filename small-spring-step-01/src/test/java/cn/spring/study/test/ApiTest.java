package cn.spring.study.test;

import cn.spring.study.BeanDefinition;
import cn.spring.study.BeanFactory;
import cn.spring.study.test.bean.UserService;
import org.junit.Test;

/**
 * 测试类
 *
 * @author wangzhibu
 * @date 2022/11/13 15:50:09
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // step1: 定义 UserService Bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());

        // step2: 注册 UserService 到 Bean 工厂
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // step3: 通过 bean 工厂获取 UserService bean，并且执行查询用户方法
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
