package flower_order;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lian.entity.User;
import com.lian.service.UserService;

public class SpringTest {

	@Test
	public void test1() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = beanFactory.getBean("userService", UserService.class);
		User user = new User();
		user.setUserName("lian321");
		user.setPassword("hahaha");
		userService.save(user);
	}
}
