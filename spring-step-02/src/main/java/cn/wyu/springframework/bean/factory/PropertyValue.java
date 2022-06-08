package cn.wyu.springframework.bean.factory;

import cn.wyu.springframework.bean.factory.config.BeanReference;

/**
 * 定义属性
 */
public class PropertyValue {
    private final String name;
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
