package com.lee.test;

import com.lee.dao.IUserinfoDao;
import com.lee.dao.Impl.UserInfoDaoImpl;
import com.lee.entily.Userinfo;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUserinfoDao info = new UserInfoDaoImpl();
		@SuppressWarnings("unused")
		Userinfo in = new Userinfo(6,"111","111");
		System.out.println(info.findAll());
	}

}
