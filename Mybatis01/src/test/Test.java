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
		//���������ļ� , ��ȡ������Ϣ
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		//2.session�������Ա�ӿڣ� �ṩ����ɾ�Ĳ鷽��           �Զ������ύ
		SqlSession session = ssf.openSession(true);
		//��ѯ����
	//	List<Userinfo> info = session.selectList("aaabbb.selectAll");
		//ģ����ѯ
		List<Userinfo> info = session.selectList("aaabbb.selectlikeName","%l%");
		//�������
	/*	Userinfo info = new Userinfo();
		info.setUid(1);
		info.setUname("sjc");
		info.setPassword("321");
		int insert = session.insert("aaabbb.insertUserinfo", info);*/
		//�ֶ������ύ
	//	session.commit();
		//�޸�
//		int update = session.update("aaabbb.updateUserinfo",info);
		//ɾ��
//		int delete = session.delete("aaabbb.deleteUserinfo",1);
//		System.out.println(delete);
		//�ر���Դ
		session.close();
		
		
	}

}
