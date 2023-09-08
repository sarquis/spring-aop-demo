package com.sqs.spring.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.sqs.spring.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount() {
	System.out.println(getClass() + ": ADDING AN ACCOUNT");
    }

    @Override
    public void addAccount(Account theAccount) {
	System.out.println(getClass() + ": ADDING AN ACCOUNT (WITH ACCOUNT ON PARAM)");
    }

}
