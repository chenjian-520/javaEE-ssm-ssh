package test;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import dao.impl.UserDaoImpl2;

public class CglibTest {
	public static void main(String[] args) {
		//1.����ί�������
		UserDaoImpl2 userdao = new UserDaoImpl2();
		//2.�������������
		Enhancer enhancer = new Enhancer();
		//���ø���
		enhancer.setSuperclass(UserDaoImpl2.class);
		//�����ǿ����
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object proxy, Method method, Object[] arg2, MethodProxy proxyMethod) throws Throwable {
				System.out.println("��������");
				//�ֶ��������صķ���
				Object obj = method.invoke(userdao, args);
				System.out.println("�ύ����");
				return obj;
			}
		});
		
		UserDaoImpl2 proxy = (UserDaoImpl2)enhancer.create();
		//3.����
		proxy.addUser();
		proxy.deleteUser();
	}
}
