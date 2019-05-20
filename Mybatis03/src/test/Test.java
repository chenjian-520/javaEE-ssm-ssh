package test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import mapper.DeptMapper;
import mapper.UserinfoMapper;
import pojo.Userinfo;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = ssf.openSession(true);
		/*	UserinfoMapper mapper = session.getMapper(UserinfoMapper.class);
			Userinfo user = new Userinfo(2,"322","333");
			Integer update = mapper.update(user);
			System.out.println(update);*/
			
			 DeptMapper mapper = session.getMapper(DeptMapper.class);
				System.out.println(mapper.findDeptAll());
			session.close();
			
			
			
			
			
	}

}
