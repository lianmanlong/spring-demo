package cn.wyu.springframework.test;

import static org.junit.Assert.assertTrue;

import cn.wyu.springframework.BeanDefinition;
import cn.wyu.springframework.BeanFactory;
import cn.wyu.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        //初始化 beanFactory
        BeanFactory beanFactory = new BeanFactory();

        //注册bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //获取bean
        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();


    }
}
