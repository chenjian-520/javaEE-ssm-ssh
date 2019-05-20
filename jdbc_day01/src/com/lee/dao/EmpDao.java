package com.lee.dao;

import java.util.List;

import com.lee.entity.Userinfo;

public interface EmpDao {
	List<Userinfo> findAll();
	
	int insert(Userinfo userinfo);
	
	int update(Userinfo userinfo);
	
	int delete(int uid);
}
