package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class ProxyTest {
	public static void main(String[] args) {
		//1.����ʵ�������
		UserDao dao= new UserDaoImpl();
		//2.���ɴ������
		UserDao proxy = (UserDao) Proxy.newProxyInstance(
				ProxyTest.class.getClassLoader(),
				dao.getClass().getInterfaces(),  //ί���ڶ���ʵ�ֵĽӿ�
				new InvocationHandler() {
					//proxy :���������
					//method�� ί���� ���󷽷���������
					//args����������
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("��������");
						//�ֶ��������صķ���
						Object obj = method.invoke(dao, args);
						System.out.println("�ύ����");
						return obj;
					}
				});
		//���ô������ķ���
		proxy.addUser();
		proxy.deleteUser();
	}
}
