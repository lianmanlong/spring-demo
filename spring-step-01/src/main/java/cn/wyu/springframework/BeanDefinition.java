package cn.wyu.springframework;

/**
 * 描述bean ,保存bean的元信息
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }
    public Object getBean(){
        return bean;
    }
}
