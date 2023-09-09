package com.sqs.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {

    @Before("com.sqs.spring.aopdemo.aspect.AopPointcutDeclarations.forDaoPackageNoGetterSetter()")
    public void logToCloud() {
	System.out.println(" # (Cloud Order 1) Executing @Before Advice : logToCloud()");
    }
}
