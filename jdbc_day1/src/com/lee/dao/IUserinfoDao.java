package com.lee.dao;

import java.util.List;

import com.lee.entily.Userinfo;

/*
 * ��userinfo�������ɾ�Ĳ����
 */
public interface IUserinfoDao {
	List<Userinfo> findAll();
	int insert(Userinfo info);
	int delete(int i);
	int updata(Userinfo info);
}
