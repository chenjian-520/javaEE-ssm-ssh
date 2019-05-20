package advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {

	public void before(JoinPoint joinPoint){
		/*System.out.println(joinPoint.getTarget());
		System.out.println(joinPoint.getSignature().getName());*/
		System.out.println("��������");
	}
	
	public void after(){
		System.out.println("�ύ����");
	}
	
	public void throwing(){
		System.out.println("�쳣");
	}
	
	public void fin(){
		System.out.println("����");
	}
	
	
	public Object around(ProceedingJoinPoint joinpoint){
		Object obj = null;
		try {
			System.out.println("ǰ��");
			obj = joinpoint.proceed();
			System.out.println("����");
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("�쳣");
		}finally{
			System.out.println("����");
		}
		return obj;
	}
	
	
	
}
