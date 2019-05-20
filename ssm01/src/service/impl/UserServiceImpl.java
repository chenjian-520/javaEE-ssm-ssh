package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.UserMapper;
import pojo.UserInfo;
import service.UserService;

@Service("userservice")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Override
	public int update(UserInfo in) {
		// TODO Auto-generated method stub
		return mapper.update(in);
	}

	@Override
	public int delete(int uid) {
		// TODO Auto-generated method stub
		return mapper.delete(uid);
	}

	@Override
	public List<UserInfo> queryAll() {
		// TODO Auto-generated method stub
		return mapper.queryAll();
	}

	@Override
	public int insert(UserInfo in) {
		// TODO Auto-generated method stub
		return mapper.insert(in);
	}

}
