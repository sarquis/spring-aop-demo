package com.sqs.spring.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sqs.spring.aopdemo.dao.AccountDAO;
import com.sqs.spring.aopdemo.dao.MembershipDAO;

@SpringBootApplication
public class SpringAopDemoApplication {

    public static void main(String[] args) {
	SpringApplication.run(SpringAopDemoApplication.class, args);
    }

    @Bean // @Bean annotation automatically inject dependency. No need autowire.
    CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
	return runner -> {
	    // demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
	    demoTheAfterReturningAdvice(theAccountDAO);
	};
    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
	List<Account> theAccounts = theAccountDAO.findAccounts();
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
