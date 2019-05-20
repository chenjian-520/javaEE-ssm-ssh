package com.lee.dao;

import java.util.List;

import com.lee.entily.Userinfo;

/*
 * 对userinfo表进行增删改查操作
 */
public interface IUserinfoDao {
	List<Userinfo> findAll();
	int insert(Userinfo info);
	int delete(int i);
	int updata(Userinfo info);
}
