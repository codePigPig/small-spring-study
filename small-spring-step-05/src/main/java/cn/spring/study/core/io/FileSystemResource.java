package cn.spring.study.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 通过指定文件路径的方式读取文件信息
 *
 * @author wangzhibu
 * @date 2023/6/15 16:02:33
 */
public class FileSystemResource implements Resource{
    /**
     * 文件
     */
    private final File file;

    /**
     * 路径
     */
    private final String path;

    /**
     * 文件系统资源
     *
     * @param file 文件
     * @return
     * @author wangzhibu
     * @date 2023/06/15
     */
    public FileSystemResource(File file) {
        this.file = file;
        // 只有文件，通过文件获取文件名
        this.path = file.getPath();
    }

    /**
     * 文件系统资源
     *
     * @param path 路径
     * @return
     * @author wangzhibu
     * @date 2023/06/15
     */
    public FileSystemResource(String path) {
        this.path = path;
        // 只有路径，通过路径获取文件
        this.file = new File(path);
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
        // 通过文件，获取文件输入流
        return new FileInputStream(this.file);
    }
}
