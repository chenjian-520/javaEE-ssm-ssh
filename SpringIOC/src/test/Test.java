package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.UserService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		UserDao dao = new UserDaoImpl();
//		dao.addUser();
//		dao.deleteUser();
		//1.���������ļ�����ȡ����
	/*	ApplicationContext ac = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.�������л�ȡ����
		UserDao dao = ac.getBean("userdao",UserDao.class);
		dao.addUser();
		dao.deleteUser();*/
		
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		 UserService bean = ac.getBean("userservice",UserService.class);
		 bean.addUser();
		 bean.deleteUser();

	}

}
