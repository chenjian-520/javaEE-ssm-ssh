package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import dao.proxy.PeoxyUserDao;

public class Test {

	public static void main(String[] args) {	
	/*	ApplicationContext ac = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao bean = ac.getBean("userdao",UserDao.class);
		bean.addUser();
		bean.deleteUser();*/
		
		UserDao dao = new PeoxyUserDao(new UserDaoImpl());
		dao.addUser();
		dao.deleteUser();

	}

}
