package dao.proxy;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class PeoxyUserDao implements UserDao {
	
	UserDao dao ;
	
	
	public PeoxyUserDao(UserDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void addUser() {
		System.out.println("开启事务");
		dao.addUser();
		System.out.println("提交事务");
	}

	@Override
	public void deleteUser() {
		System.out.println("开启事务");
		dao.deleteUser();
		System.out.println("提交事务");
	}

}
