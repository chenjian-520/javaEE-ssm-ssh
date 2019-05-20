package dao;

import java.util.List;

import entity.UserInfo;

public interface UserDao {

	UserInfo login(String username,String password);
	
	List<UserInfo> findAll();
	
}
