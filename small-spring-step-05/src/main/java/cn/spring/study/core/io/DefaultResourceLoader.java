package cn.spring.study.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 获取资源实现
 *
 * @author wangzhibu
 * @date 2023/6/15 16:23:12
 */
public class DefaultResourceLoader implements ResourceLoader{
    /**
     * 在获取资源的实现中，主要是把三种不同类型的资源处理方式进行了包装
     * 判断是否为ClassPath、URL以及文件
     *
     * @param location 位置
     * @return {@link Resource }
     * @author wangzhibu
     * @date 2023/06/15
     */
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        // step1: 检查地址是否是以 classpath: 开始
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            // step2: 截取classpath: 后面的地址
            String subLocation = location.substring(CLASSPATH_URL_PREFIX.length());
            // step3: 返回 classpath 类型的资源实现
            return new ClassPathResource(subLocation);
        } else {
            try {
                // step4: 返回 URL 类型的资源实现
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                // step5: 返回 文件 类型的资源实现
                return new FileSystemResource(location);
            }
        }
    }
}
