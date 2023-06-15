package cn.spring.study.core.io;

import cn.hutool.core.lang.Assert;
import cn.spring.study.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 通过ClassLoader 读取 ClassPath 下的文件信息
 *
 * @author wangzhibu
 * @date 2023/6/15 15:15:15
 */
public class ClassPathResource implements Resource{

    private final String path;

    private ClassLoader classLoader;

    /**
     * 类路径资源
     *
     * @param path 路径
     * @return
     * @author wangzhibu
     * @date 2023/06/15
     */
    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    /**
     * 类路径资源
     *
     * @param path        路径
     * @param classLoader 类加载器
     * @return
     * @author wangzhibu
     * @date 2023/06/15
     */
    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
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
        // step1: 尝试获取path路径中的输入流
        InputStream resourceAsStream = classLoader.getResourceAsStream(path);
        if (resourceAsStream == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return resourceAsStream;
    }
}
