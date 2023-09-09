package com.sqs.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("com.sqs.spring.aopdemo.aspect.AopPointcutDeclarations.forDaoPackage()")
    public void performApiAnalytics() {
	System.out.println(" # (Analytics Order 3) Executing @Before Advice : performApiAnalytics()");
    }

}
