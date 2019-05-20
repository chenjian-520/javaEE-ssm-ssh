package test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.DepMapper;
import mapper.EmpMapper;
import mapper.UserInfoMapper;

public class Test {

	public static void main(String[] args) throws IOException {
		//加载配置文件 , 读取数据信息
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		//2.session面向程序员接口， 提供了增删改查方法           自动事务提交
		SqlSession session = ssf.openSession(true);
		 DepMapper mapper = session.getMapper(DepMapper.class);
		System.out.println(mapper.findDeptAndEmps());
		session.close();
		
	}

}
