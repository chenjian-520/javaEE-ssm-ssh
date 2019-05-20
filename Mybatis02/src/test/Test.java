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
		//���������ļ� , ��ȡ������Ϣ
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		//2.session�������Ա�ӿڣ� �ṩ����ɾ�Ĳ鷽��           �Զ������ύ
		SqlSession session = ssf.openSession(true);
		 DepMapper mapper = session.getMapper(DepMapper.class);
		System.out.println(mapper.findDeptAndEmps());
		session.close();
		
	}

}
