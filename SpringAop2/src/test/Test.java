package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.UserService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		 UserService bean = ac.getBean("userservice",UserService.class);
		 bean.addUser();
		 
	}

}
