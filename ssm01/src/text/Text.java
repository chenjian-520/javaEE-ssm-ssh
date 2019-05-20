package text;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mapper.classMapper;
import service.ClassService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class Text {
/*	@org.junit.Test
	public void test() throws IOException{
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = ssf.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		System.out.println(mapper.queryAll());
		session.close();
	}*/
	
	@Autowired
	private ClassService ClassServiceImple;
	
	@org.junit.Test
	public void test(){
		
		System.out.println(ClassServiceImple.findOne("ÎïÁªÍø1151"));
	}
	
}
