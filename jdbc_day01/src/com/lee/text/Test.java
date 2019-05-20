package com.lee.text;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.lee.dao.IUserinfoDao;
import com.lee.dao.impl.UserInfoDaoImpl;
import com.lee.dao.impl.Work;
import com.lee.entity.Userinfo;

public class Test {

	public static void main(String[] args) throws IOException {
/*		// TODO Auto-generated method stub
		IUserinfoDao info = new UserInfoDaoImpl();
		System.out.println(info.findAll());
		
		Properties properties = new Properties();
		
		//默认读取位置 classpath(顶级目录)
		   //src(source folder)
		InputStream is = Test.class.getClassLoader().
		getResourceAsStream("jdbc.properties");
		
		properties.load(is);
		//properties.setProperty(key, value)
		System.out.println(properties.getProperty("driver"));*/
		Userinfo user = new Userinfo(50,"CLEAN","NAC");
		Work info = new Work();
	    System.out.println(info.findAll());
		
		 System.out.println(info.select(10));
		
		 info.insert(user);
		 System.out.println(info.findAll());
		 
		 info.delete(50);
		 System.out.println(info.findAll());
	}

}
