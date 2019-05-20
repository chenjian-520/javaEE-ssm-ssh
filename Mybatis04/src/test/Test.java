package test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.classMapper;
import mapper.studentMapper;




public class Test {
	public static void main(String[] args) throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession(true);
		classMapper mapper = session.getMapper(classMapper.class);
		
	//	Student s = new Student(8,"24","3523",56,"物联网1151");
	//	String s="物联网1152";
		System.out.println(mapper.findOne("物联网1151"));
		session.close();
		
		
		
	}
}
