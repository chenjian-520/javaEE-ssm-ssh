package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.UserMapper;
import pojo.UserInfo;
import service.UserService;

@Service("userservice")
public class UserserviceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<UserInfo> queryAll() {
		return mapper.queryAll();
	}

}
