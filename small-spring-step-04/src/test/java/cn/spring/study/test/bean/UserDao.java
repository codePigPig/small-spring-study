package cn.spring.study.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试使用，用户服务 Dao层
 *
 * @author wangzhibu
 * @date 2023/6/14 13:58:34
 */
public class UserDao {

    /**
     * 用户信息，模拟
     */
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "rob");
        hashMap.put("10002", "anna");
        hashMap.put("10003", "lily");
    }

    /**
     * 查询用户名
     *
     * @param uId Uid
     * @return {@link String }
     * @author wangzhibu
     * @date 2023/06/14
     */
    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
