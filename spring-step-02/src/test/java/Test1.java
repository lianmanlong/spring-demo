
import bean.UserService;
import cn.wyu.springframework.bean.factory.config.BeanDefiniton;
import cn.wyu.springframework.bean.factory.support.DefaultListableBeanFactory;
import org.junit.Test;
public class Test1 {
    @Test
    public void shouldAnswerWithTrue()
    {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //注册bean
        BeanDefiniton beanDefiniton = new BeanDefiniton(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefiniton);
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }
}
