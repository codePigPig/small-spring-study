package cn.spring.study.factory;

/**
 * 定义属性
 *
 * @author wangzhibu
 * @date 2023/6/14 10:46:00
 */
public class PropertyValue {

    /**
     * 属性名
     */
    private final String name;

    /**
     * 属性值
     */
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
