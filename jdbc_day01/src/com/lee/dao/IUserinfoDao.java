package com.lee.dao;

import java.util.List;

import com.lee.entity.Userinfo;

/*
 * ��userinfo�������ɾ�Ĳ����
 */
public interface IUserinfoDao {
	List<Userinfo> findAll();
	
	int insert(Userinfo userinfo);
	
	int update(Userinfo userinfo);
	
	int delete(int uid);
}
