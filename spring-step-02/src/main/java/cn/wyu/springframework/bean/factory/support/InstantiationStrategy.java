package cn.wyu.springframework.bean.factory.support;

import cn.wyu.springframework.bean.factory.config.BeanDefiniton;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefiniton beanDefiniton, String beanName, Constructor constructor, Object[] args);
}
