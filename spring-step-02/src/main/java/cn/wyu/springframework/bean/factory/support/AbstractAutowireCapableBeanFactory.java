package cn.wyu.springframework.bean.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.wyu.springframework.bean.factory.PropertyValue;
import cn.wyu.springframework.bean.factory.PropertyValues;
import cn.wyu.springframework.bean.factory.config.BeanDefiniton;
import cn.wyu.springframework.bean.factory.config.BeanReference;


import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefiniton beanDefiniton) {
        Object bean = null;


        try {
            bean = beanDefiniton.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //给bean 填充属性
        applyPropertyValues(beanName, bean, beanDefiniton);
        addSingleton(beanName, bean);
        return bean;
    }

   @Override
    protected Object createBean(String beanName, BeanDefiniton beanDefiniton, Object[] args) {
        Object bean = null;


            bean = createBeanInstance(beanDefiniton, beanName, args);
            //给bean 填充属性
            applyPropertyValues(beanName, bean, beanDefiniton);
        addSingleton(beanName, bean);
        return bean;
    }

    //bean 属性填充
    protected void applyPropertyValues(String beanName, Object bean, BeanDefiniton beanDefiniton) {
       try {
           PropertyValues propertyValues = beanDefiniton.getPropertyValues();
           for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
               String name = propertyValue.getName();
               Object value = propertyValue.getValue();

               if (value instanceof BeanReference){
                   BeanReference beanReference = (BeanReference)value;
                   value = getBean(beanReference.getBeanName());
               }

               // 属性填充
               BeanUtil.setFieldValue(bean, name, value);
           }

       }catch (Exception  e){

       }
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
