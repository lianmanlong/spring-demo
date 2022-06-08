package cn.wyu.springframework.bean.factory.config;

/**
 * 描述bean, 存储bean的元信息
 */
public class BeanDefiniton {

    private Class beanClass;

    public BeanDefiniton(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
