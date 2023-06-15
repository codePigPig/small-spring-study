package cn.spring.study.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 处理资源加载流
 *
 * @author wangzhibu
 * @date 2023/6/15 15:13:07
 */
public interface Resource {

    /**
     * 获取输入流
     *
     * @return {@link InputStream }
     * @author wangzhibu
     * @date 2023/06/15
     */
    InputStream getInputStream() throws IOException;
}
