package service.impl;

import org.springframework.stereotype.Service;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;


public class UserServiceImpl implements UserService {
	
	//接口   +  构造器  /setter 方法
	UserDao dao ;
	
	
	public UserServiceImpl(UserDao dao) {
		super();
		this.dao = dao;
	}
	
/*	public void setDao(UserDao dao) {
		this.dao = dao;
	}*/


	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		dao.addUser();
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		dao.deleteUser();
	}

}
