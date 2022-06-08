package cn.wyu.springframework.bean.factory.support;

import cn.wyu.springframework.bean.factory.config.BeanDefiniton;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;


/**
 * Cglib 实例化
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefiniton beanDefiniton, String beanName, Constructor constructor, Object[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefiniton.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == constructor) return enhancer.create();
        return enhancer.create(constructor.getParameterTypes(), args);
    }
}
