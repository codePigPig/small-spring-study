package cn.spring.study.test.bean;

/**
 * 用户服务
 *
 * @author wangzhibu
 * @date 2023/3/7 21:38:52
 */
public class UserService {

    /**
     * 名字
     */
    public String name;

    /**
     * 无参构造
     */
    public UserService() {
    }

    /**
     * 有参数构造
     *
     * @param name 名字
     */
    public UserService(String name) {
        this.name = name;
    }

    /**
     * 查询用户信息
     *
     * @author wangzhibu
     * @date 2023/03/07
     */
    public void queryUserInfo() {
        System.out.println("查询用户信息: " + name);
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }
}
