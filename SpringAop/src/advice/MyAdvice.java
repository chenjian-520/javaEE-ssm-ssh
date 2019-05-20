package advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {

	public void before(JoinPoint joinPoint){
		/*System.out.println(joinPoint.getTarget());
		System.out.println(joinPoint.getSignature().getName());*/
		System.out.println("开启事务");
	}
	
	public void after(){
		System.out.println("提交事务");
	}
	
	public void throwing(){
		System.out.println("异常");
	}
	
	public void fin(){
		System.out.println("最终");
	}
	
	
	public Object around(ProceedingJoinPoint joinpoint){
		Object obj = null;
		try {
			System.out.println("前置");
			obj = joinpoint.proceed();
			System.out.println("后置");
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("异常");
		}finally{
			System.out.println("最终");
		}
		return obj;
	}
	
	
	
}
