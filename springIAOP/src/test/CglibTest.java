package test;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import dao.impl.UserDaoImpl2;

public class CglibTest {
	public static void main(String[] args) {
		//1.创建委托类对象
		UserDaoImpl2 userdao = new UserDaoImpl2();
		//2.创建代理类对象
		Enhancer enhancer = new Enhancer();
		//设置父类
		enhancer.setSuperclass(UserDaoImpl2.class);
		//添加增强功能
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object proxy, Method method, Object[] arg2, MethodProxy proxyMethod) throws Throwable {
				System.out.println("开启事务");
				//手动调用拦截的方法
				Object obj = method.invoke(userdao, args);
				System.out.println("提交事务");
				return obj;
			}
		});
		
		UserDaoImpl2 proxy = (UserDaoImpl2)enhancer.create();
		//3.调用
		proxy.addUser();
		proxy.deleteUser();
	}
}
