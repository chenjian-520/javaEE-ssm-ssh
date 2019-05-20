package dao.impl;

import org.springframework.stereotype.Component;

import dao.UserDao;

//不写默认为类名
@Component("userdao")
public class UserDaoImpl implements UserDao {

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		System.out.println("添加用户");
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		System.out.println("删除用户");
	}

}
