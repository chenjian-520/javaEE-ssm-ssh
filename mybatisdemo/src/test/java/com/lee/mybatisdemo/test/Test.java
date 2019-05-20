package com.lee.mybatisdemo.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lee.mybatisdemo.mapper.UserMapper;

public class Test {
	
	@org.junit.Test
	public void test() throws IOException{
		//1.读取配置文件
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		System.out.println(mapper.queryAll());
		session.close();
	}

}
