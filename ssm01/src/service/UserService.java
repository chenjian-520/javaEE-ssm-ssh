package service;

import java.util.List;

import pojo.UserInfo;

public interface UserService {
	
	List<UserInfo> queryAll();
	
	int delete(int uid);
	
	int insert(UserInfo info);
	
	int update(UserInfo in);
}
