package com.sqs.spring.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sqs.spring.aopdemo.Account;

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

    @AfterReturning(pointcut = "execution(* com.sqs.spring.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
	String methodSign = theJoinPoint.getSignature().toShortString();
	System.out.println(" # (Logging Order 2) @AfterReturning : " + methodSign);
	System.out.println(" # (Logging Order 2) @AfterReturning RESULT : " + result);
	System.out.println(" # Post-processind Data");
	result.forEach(r -> r.setName(r.getName().toUpperCase() + "(OK-modified data)"));
	System.out.println(" # (Logging Order 2) @AfterReturning RESULT : " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.sqs.spring.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
	String methodSign = theJoinPoint.getSignature().toShortString();
	System.out.println(" # (Logging Order 2) @AfterThrowing : " + methodSign);
	System.out.println(" # (Logging Order 2) @AfterThrowing The Exception is: " + theExc);
    }

    @After("execution(* com.sqs.spring.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
	String methodSign = theJoinPoint.getSignature().toShortString();
	System.out.println(" # (Logging Order 2) @After (finally) : " + methodSign);
    }

    @Around("execution(* com.sqs.spring.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

	String methodSign = theProceedingJoinPoint.getSignature().toShortString();
	System.out.println(" # @Around : " + methodSign);
	long begin = System.currentTimeMillis();

	Object result = null;
	try {
	    result = theProceedingJoinPoint.proceed();
	} catch (Exception e) {
	    System.out.println(" # " + e.getMessage());
	    result = "Major accidente! But no worries!";
	}

	long end = System.currentTimeMillis();
	long duration = end - begin;
	System.out.println(" # Duration: " + duration + " in millis. \n");

	return result;
    }

}
