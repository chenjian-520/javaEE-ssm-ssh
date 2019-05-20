package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.Userservice;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Userservice service = ac.getBean("userservice", Userservice.class);
		service.addUser();
		service.deleteUser();
	}

}
