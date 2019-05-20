package test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pojo.Userinfo;

public class Test {

	public static void main(String[] args) throws IOException {
		//加载配置文件 , 读取数据信息
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		//2.session面向程序员接口， 提供了增删改查方法           自动事务提交
		SqlSession session = ssf.openSession(true);
		//查询所有
	//	List<Userinfo> info = session.selectList("aaabbb.selectAll");
		//模糊查询
		List<Userinfo> info = session.selectList("aaabbb.selectlikeName","%l%");
		//插入对象
	/*	Userinfo info = new Userinfo();
		info.setUid(1);
		info.setUname("sjc");
		info.setPassword("321");
		int insert = session.insert("aaabbb.insertUserinfo", info);*/
		//手动事务提交
	//	session.commit();
		//修改
//		int update = session.update("aaabbb.updateUserinfo",info);
		//删除
//		int delete = session.delete("aaabbb.deleteUserinfo",1);
//		System.out.println(delete);
		//关闭资源
		session.close();
		
		
	}

}
