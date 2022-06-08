package cn.wyu.springframework.bean.factory;

public interface BeanFactory {

    public Object getBean(String name);

    Object getBean(String name, Object... args);
}
