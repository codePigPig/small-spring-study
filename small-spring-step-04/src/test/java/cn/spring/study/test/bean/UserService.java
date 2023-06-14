package cn.spring.study.test.bean;

/**
 * 用户服务
 *
 * @author wangzhibu
 * @date 2023/3/7 21:38:52
 */
public class UserService {


    private UserDao userDao;

    /**
     * Uid
     */
    public String uId;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    /**
     * 查询用户信息
     *
     * @author wangzhibu
     * @date 2023/03/07
     */
    public void queryUserInfo() {
        System.out.println("查询用户信息: " + userDao.queryUserName(uId));
    }

}
