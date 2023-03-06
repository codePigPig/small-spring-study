package cn.spring.study.factory.config;

/**
 * 定义bean异常信息
 *
 * @author wangzhibu
 * @date 2023/3/6 21:14:42
 */
public class BeansException extends RuntimeException{

    /**
     * Bean异常
     *
     * @param msg 味精
     * @author wangzhibu
     * @date 2023/03/06
     */
    public BeansException(String msg) {
        super(msg);
    }

    /**
     * Bean异常
     *
     * @param msg   味精
     * @param cause 原因
     * @author wangzhibu
     * @date 2023/03/06
     */
    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
