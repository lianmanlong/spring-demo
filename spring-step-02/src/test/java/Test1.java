
import bean.UserDao;
import bean.UserService;
import cn.wyu.springframework.bean.factory.PropertyValue;
import cn.wyu.springframework.bean.factory.PropertyValues;
import cn.wyu.springframework.bean.factory.config.BeanDefiniton;
import cn.wyu.springframework.bean.factory.config.BeanReference;
import cn.wyu.springframework.bean.factory.support.DefaultListableBeanFactory;
import org.junit.Test;
public class Test1 {
    @Test
    public void shouldAnswerWithTrue()
    {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("userDao", new BeanDefiniton(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefiniton beanDefiniton = new BeanDefiniton(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefiniton);

        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
