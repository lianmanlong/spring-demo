package cn.wyu.springframework.bean.factory.support;

import cn.wyu.springframework.bean.factory.config.BeanDefiniton;

public interface BeanDefinitionRegistry {
    public void registerBeanDefinition(String beanName, BeanDefiniton beanDefinition);
}
