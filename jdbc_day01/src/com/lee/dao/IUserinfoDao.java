package com.lee.dao;

import java.util.List;

import com.lee.entity.Userinfo;

/*
 * 对userinfo表进行增删改查操作
 */
public interface IUserinfoDao {
	List<Userinfo> findAll();
	
	int insert(Userinfo userinfo);
	
	int update(Userinfo userinfo);
	
	int delete(int uid);
}
