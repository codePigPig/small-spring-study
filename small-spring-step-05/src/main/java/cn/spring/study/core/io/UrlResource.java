package cn.spring.study.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 通过 Http的方式读取云服务的文件
 * @author wangzhibu
 * @date 2023/6/15 16:06:25
 */
public class UrlResource implements Resource{

    /**
     * URL
     */
    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url, "URL must not be null");
        this.url = url;
    }

    /**
     * 获取输入流
     *
     * @return {@link InputStream }
     * @author wangzhibu
     * @date 2023/06/15
     */
    @Override
    public InputStream getInputStream() throws IOException {
        // step1: 创建一个URLConnection对象，表示已经床了一个到URL的连接，并没有世纪开始下载数据
        URLConnection connection = this.url.openConnection();
        try {
            // step2: 表示已经开始读取数据
            return connection.getInputStream();
        } catch (Exception e) {
            if (connection instanceof HttpURLConnection) {
                ((HttpURLConnection) connection).disconnect();
            }
            throw e;
        }
    }
}
