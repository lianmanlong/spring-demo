package cn.wyu.springframework.bean.factory.support;

import cn.wyu.springframework.bean.factory.config.BeanDefiniton;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

   @Override
    protected Object createBean(String beanName, BeanDefiniton beanDefiniton, Object[] args) {
        Object bean = null;


            bean = createBeanInstance(beanDefiniton, beanName, args);

        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefiniton beanDefiniton, String beanName, Object[] args){
        Constructor constructor = null;
        Class<?> beanClass = beanDefiniton.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
         if (null != args && declaredConstructor.getParameterTypes().length == args.length){
             constructor = declaredConstructor;
             break;
         }
        }
        return instantiationStrategy.instantiate(beanDefiniton, beanName, constructor, args);
    }
}
