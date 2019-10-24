package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Advice {
	@Before(value = "execution(public * service.UserServiceImpl.insert(..))")
	public void before() {
		System.out.println("开启事务");
	}

	@After(value = "execution(public * service.UserServiceImpl.delete(..))")
	public void after() {
		System.out.println("提交事务");
	}

	@Around(value = "execution(public * service.UserServiceImpl.update(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("开启事务");
		Object proceed = pjp.proceed();
		System.out.println("提交事务");
		return proceed;
	}

	@AfterThrowing(value = "execution(public * service.UserServiceImpl.find(..))", throwing = "ex")
	public void afterException(JoinPoint joinPoint, Throwable ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("异常通知方法 " + methodName + " 发生的异常为 " + ex);
		System.out.println("事务回滚");
	}
}
