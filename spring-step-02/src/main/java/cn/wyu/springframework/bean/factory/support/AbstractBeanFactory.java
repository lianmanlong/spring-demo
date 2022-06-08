package cn.wyu.springframework.bean.factory.support;

import cn.wyu.springframework.bean.factory.BeanFactory;
import cn.wyu.springframework.bean.factory.config.BeanDefiniton;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) {
        Object bean = getSingleton(name);
        if (bean != null){
            return bean;
        }
        BeanDefiniton beanDefiniton = getBeanDefinition(name);
        return createBean(name, beanDefiniton);
    }

    protected abstract Object createBean(String name, BeanDefiniton beanDefiniton);

    @Override
    public Object getBean(String name, Object... args) {
        Object bean = getSingleton(name);
        if (bean != null){
            return bean;
        }
        BeanDefiniton beanDefiniton = getBeanDefinition(name);
        return createBean(name, beanDefiniton, args);
    }

    protected abstract Object createBean(String name, BeanDefiniton beanDefiniton, Object[] args);

    protected abstract BeanDefiniton getBeanDefinition(String name);
}
