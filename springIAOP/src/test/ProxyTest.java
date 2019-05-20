package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class ProxyTest {
	public static void main(String[] args) {
		//1.创建实现类对象
		UserDao dao= new UserDaoImpl();
		//2.生成代理对象
		UserDao proxy = (UserDao) Proxy.newProxyInstance(
				ProxyTest.class.getClassLoader(),
				dao.getClass().getInterfaces(),  //委托内对象实现的接口
				new InvocationHandler() {
					//proxy :代理类对象
					//method： 委托类 对象方法描述对象
					//args：方法参数
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("开启事务");
						//手动调用拦截的方法
						Object obj = method.invoke(dao, args);
						System.out.println("提交事务");
						return obj;
					}
				});
		//调用代理对象的方法
		proxy.addUser();
		proxy.deleteUser();
	}
}
