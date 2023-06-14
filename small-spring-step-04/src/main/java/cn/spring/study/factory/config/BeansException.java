package cn.spring.study.factory.config;

/**
 * @author wangzhibu
 * @date 2023/3/7 23:09:07
 */
public class BeansException extends RuntimeException{

    /**
     * Bean异常
     *
     * @param msg 错误信息
     */
    public BeansException(String msg) {
        super(msg);
    }

    /**
     * Bean异常
     *
     * @param msg       错误信息
     * @param throwable 异常
     * @author wangzhibu
     * @date 2023/03/07
     */
    public BeansException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
