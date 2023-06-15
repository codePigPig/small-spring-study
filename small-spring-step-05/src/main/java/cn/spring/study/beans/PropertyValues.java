package cn.spring.study.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhibu
 * @date 2023/6/14 10:47:54
 */
public class PropertyValues {

    /**
     * 属性值列表
     */
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    /**
     * 添加属性值
     *
     * @param pv 光伏发电
     * @author wangzhibu
     * @date 2023/06/14
     */
    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    /**
     * 获取属性值，数组
     *
     * @return {@link PropertyValue[] }
     * @author wangzhibu
     * @date 2023/06/14
     */
    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 获取属性值，根据属性名
     *
     * @param propertyName 属性名称
     * @return {@link PropertyValue }
     * @author wangzhibu
     * @date 2023/06/14
     */
    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : this.propertyValueList) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }


}
