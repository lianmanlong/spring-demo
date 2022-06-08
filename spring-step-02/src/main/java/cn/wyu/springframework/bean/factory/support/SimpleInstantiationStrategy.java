package cn.wyu.springframework.bean.factory.support;

import cn.wyu.springframework.bean.factory.config.BeanDefiniton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * JDK实例化
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefiniton beanDefiniton, String beanName, Constructor constructor, Object[] args) {
        Class clazz = beanDefiniton.getBeanClass();
        try {
            if (null != constructor){
                return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
           throw new RuntimeException();
        }

    }
}
