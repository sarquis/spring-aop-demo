package com.sqs.spring.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sqs.spring.aopdemo.dao.AccountDAO;
import com.sqs.spring.aopdemo.dao.MembershipDAO;
import com.sqs.spring.aopdemo.service.TrafficFortuneService;

@SpringBootApplication
public class SpringAopDemoApplication {

    public static void main(String[] args) {
	SpringApplication.run(SpringAopDemoApplication.class, args);
    }

    @Bean // @Bean annotation automatically inject dependency. No need autowire.
    CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO,
	    TrafficFortuneService theTrafficFortuneService) {
	return runner -> {
	    // demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
	    // demoTheAfterReturningAdvice(theAccountDAO);
	    // demoTheAfterThrowingAdvice(theAccountDAO);
	    // demoTheAfterAdvice(theAccountDAO);
	    demoTheAroundAdvide(theTrafficFortuneService);
	};
    }

    private void demoTheAroundAdvide(TrafficFortuneService theTrafficFortuneService) {
	System.out.println("\nMain Program\n");
	System.out.println(theTrafficFortuneService.getFortune());
	System.out.println("\nFinished");
    }

    @SuppressWarnings("unused")
    private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
	try {
	    boolean tripWire = true;
	    @SuppressWarnings("unused")
	    List<Account> theAccounts = theAccountDAO.findAccounts(!tripWire);
	    System.out.println("\n");
	    theAccounts = theAccountDAO.findAccounts(tripWire);
	} catch (Exception e) {
	    System.out.println("\n Main Program: ... caught exeception: " + e);
	}
    }

    @SuppressWarnings("unused")
    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
	try {
	    boolean tripWire = true;
	    List<Account> theAccounts = theAccountDAO.findAccounts(tripWire);
	} catch (Exception e) {
	    System.out.println("\n Main Program: ... caught exeception: " + e);
	}
    }

    @SuppressWarnings("unused")
    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
	List<Account> theAccounts = theAccountDAO.findAccounts(false);
	System.out.println("\n Main Program: \n" + theAccounts);
    }

    @SuppressWarnings("unused")
    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
	theAccountDAO.addAccount();
	theAccountDAO.addAccount(new Account("Ms S. Pippen", "VIP"), true);
	theAccountDAO.setName("test");
	theAccountDAO.setServiceCode("test");
	theAccountDAO.getName();
	theAccountDAO.getServiceCode();
	theMembershipDAO.addMembershipAccount();
    }
}
