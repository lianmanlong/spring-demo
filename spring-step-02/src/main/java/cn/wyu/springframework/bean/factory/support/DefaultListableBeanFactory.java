package cn.wyu.springframework.bean.factory.support;

import cn.wyu.springframework.bean.factory.config.BeanDefiniton;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{

    private Map<String, BeanDefiniton> beanDefinitonMap = new HashMap<String, BeanDefiniton>();



    @Override
    public BeanDefiniton getBeanDefinition(String beanName) {
        BeanDefiniton beanDefiniton = beanDefinitonMap.get(beanName);
//        if (beanDefiniton == null) throw RuntimeException;
        return beanDefiniton;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefiniton beanDefinition) {
        beanDefinitonMap.put(beanName, beanDefinition);
    }
}
