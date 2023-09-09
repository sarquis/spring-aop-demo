package com.sqs.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Just a simple demo of a Aspect class, that has a collection of related
 * advices (Before, After, etc).
 */
@Aspect
@Component
public class DemoLoggingAspect {

    @Pointcut("execution(* com.sqs.spring.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("execution(* get*(..))")
    private void getter() {
    }

    @Pointcut("execution(* set*(..))")
    private void setter() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
	System.out.println(" * Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
	System.out.println(" * Executing @Before advice on performApiAnalytics()");
    }
}
