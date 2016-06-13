package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.IUserService;

public class SpringTest {

	@Test
	public void testSpring(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserService userService = (IUserService) ctx.getBean("userService");
		System.out.println(userService.getAllUsers());;
	}
}
