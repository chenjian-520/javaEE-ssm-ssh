package service.impl;

import org.springframework.stereotype.Service;

import service.UserService;

@Service("userservice")
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("����û�");
	}

	@Override
	public void deleteUser() {
		System.out.println("ɾ���û�");
	}

}
