package com.lee.mybatisdemo.mapper;

import java.util.List;

import com.lee.mybatisdemo.pojo.UserInfo;

public interface UserMapper {

	List<UserInfo> queryAll();
	
}
