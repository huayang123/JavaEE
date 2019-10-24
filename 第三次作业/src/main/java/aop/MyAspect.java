package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("proxyFactoryBean开启事务");
		Object object = invocation.proceed();
		System.out.println("proxyFactoryBean提交事务");
		return object;
	}

	

}
