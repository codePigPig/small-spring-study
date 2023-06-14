package cn.spring.study.test.bean;

/**
 * 用户服务
 *
 * @author wangzhibu
 * @date 2023/3/6 20:33:27
 */
public class UserService {

    /**
     * 名字
     */
    private String name;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 查询用户信息
     *
     * @author wangzhibu
     * @date 2023/03/06
     */
    public void queryUserInfo() {
        System.out.println("查询用户信息");
    }



}
