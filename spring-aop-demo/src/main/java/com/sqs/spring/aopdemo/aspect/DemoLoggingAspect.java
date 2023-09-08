package com.sqs.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Just a simple demo of a Aspect class, that has a collection of related
 * advices (Before, After, etc).
 */
@Aspect
@Component
public class DemoLoggingAspect {

    @Before("execution(public void add*Account())")
    public void beforeAddAccountAdvice() {
	System.out.println("* Executing @Before advice on addAccount()");
    }

}
