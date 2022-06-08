package cn.wyu.springframework.bean.factory.config;

import cn.wyu.springframework.bean.factory.PropertyValues;

/**
 * 描述bean, 存储bean的元信息
 */
public class BeanDefiniton {

    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefiniton(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public BeanDefiniton(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
