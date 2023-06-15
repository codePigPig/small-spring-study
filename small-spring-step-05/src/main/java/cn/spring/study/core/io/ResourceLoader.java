package cn.spring.study.core.io;

/**
 * 定义资源加载器，集中式处理
 *
 * @author wangzhibu
 * @date 2023/6/15 16:18:13
 */
public interface ResourceLoader {


    /**
     * 类路径URL前缀
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 获取资源
     *
     * @param location 位置
     * @return {@link Resource }
     * @author wangzhibu
     * @date 2023/06/15
     */
    Resource getResource(String location);
}
