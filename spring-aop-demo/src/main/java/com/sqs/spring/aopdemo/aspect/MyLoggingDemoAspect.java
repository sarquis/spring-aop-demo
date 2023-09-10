package com.sqs.spring.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyLoggingDemoAspect {

    @Before("com.sqs.spring.aopdemo.aspect.AopPointcutDeclarations.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
	System.out.println(" # (Logging Order 2) Executing @Before Advice : addAccount()");

	MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
	System.out.println(" # (Logging Order 2) Method Signature: " + methodSignature);

	for (Object tempArg : theJoinPoint.getArgs()) {
	    System.out.println(" # (Logging Order 2) Method Args: " + tempArg);
	}
    }

}
