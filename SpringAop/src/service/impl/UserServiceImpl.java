package service.impl;

import service.Userservice;

public class UserServiceImpl implements Userservice {

	@Override
	public void addUser() {
		System.out.println("添加用户");
	}

	@Override
	public void deleteUser() {
		System.out.println("删除用户");
	}

}
