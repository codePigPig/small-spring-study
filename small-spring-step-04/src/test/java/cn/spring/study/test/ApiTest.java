package cn.spring.study.test;

import cn.spring.study.factory.PropertyValue;
import cn.spring.study.factory.PropertyValues;
import cn.spring.study.factory.config.BeanDefinition;
import cn.spring.study.factory.config.BeanReference;
import cn.spring.study.factory.support.DefaultListableBeanFactory;
import cn.spring.study.test.bean.UserDao;
import cn.spring.study.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author wangzhibu
 * @date 2023/3/7 21:39:02
 */
public class ApiTest {


    /**
     * 测试bean工厂
     *
     * @author wangzhibu
     * @date 2023/03/07
     */
    @Test
    public void test_BeanFactory() {
        // step1：定义bean模版
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        // step2：new beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // step3：注册
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService", "rob");
        System.out.println(userService);
    }

    /**
     * 测试cglib
     *
     * @author wangzhibu
     * @date 2023/03/07
     */
    @Test
    public void test_cglib() {
        // step1: 新建一个字节码生成器
        Enhancer enhancer = new Enhancer();
        // step2: 设置被代理类的 Class 对象。
        enhancer.setSuperclass(UserService.class);
        // step3：设置回调函数
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        // step4: 创建代理对象
        Object obj = enhancer.create(new Class[]{String.class}, new Object[]{"rob"});
        System.out.println(obj);
    }

    /**
     * 测试新实例
     *
     * @author wangzhibu
     * @date 2023/03/07
     */
    @Test
    public void test_newInstance() throws InstantiationException, IllegalAccessException {
        UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }

    /**
     * 测试构造函数
     *
     * @author wangzhibu
     * @date 2023/03/07
     */
    @Test
    public void test_constructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // step1：获取userService定义模版
        Class<UserService> userServiceClass = UserService.class;
        // step2：获取指定构造器
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        // step3：根据构造器，创建实例
        UserService userService = declaredConstructor.newInstance("rob");
        System.out.println(userService);
    }

    @Test
    public void test_BeanFactoryProperty() {
        // step1: 初始化 bean 工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // step2: 注册 UserDao
        BeanDefinition userDaoBeanDefinition = new BeanDefinition(UserDao.class);
        beanFactory.registerBeanDefinition("userDao", userDaoBeanDefinition);
        // step3: 组装 UserService 设置属性，uId、userDao
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        // step4: 注册 UserService
        BeanDefinition userServiceBeanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", userServiceBeanDefinition);
        // step5: 获取 UserService bean 实例
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
