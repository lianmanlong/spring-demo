package cn.wyu.springframework.bean.factory.config;

/**
 * 定义了获取单例bean的接口
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
