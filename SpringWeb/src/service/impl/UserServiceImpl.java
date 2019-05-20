package service.impl;

import org.springframework.stereotype.Service;

import service.UserService;

@Service("userservice")
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("添加用户");
	}

	@Override
	public void deleteUser() {
		System.out.println("删除用户");
	}

}
