package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

@Service("userservice")
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Qualifier("userdao")
	UserDao dao ;
	
	
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
