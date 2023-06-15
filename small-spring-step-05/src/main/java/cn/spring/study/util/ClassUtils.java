package cn.spring.study.util;

/**
 * 动态加载类或资源
 *
 * @author wangzhibu
 * @date 2023/6/15 15:20:50
 */
public class ClassUtils {

    /**
     * 获取默认类加载器
     *
     * @return {@link ClassLoader }
     * @author wangzhibu
     * @date 2023/06/15
     */
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            // 优先获取尝试获取 当前线程上下文类加载器
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // 无法访问线程上下文ClassLoader-正在回退到系统类加载器...
        }
        if (cl == null) {
            //无线程上下文类加载器->使用此类的类加载器
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}
