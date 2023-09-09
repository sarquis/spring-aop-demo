package com.sqs.spring.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.sqs.spring.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String serviceCode;

    @Override
    public void addAccount() {
	System.out.println(getClass() + ": ADDING AN ACCOUNT");
    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
	System.out.println(getClass() + ": ADDING AN ACCOUNT (WITH ACCOUNT ON PARAM, AND BOOLEAN)");
    }

    @Override
    public String getName() {
	System.out.println(getClass() + ": getName()");
	return name;
    }

    @Override
    public void setName(String name) {
	System.out.println(getClass() + ": setName()");
	this.name = name;
    }

    @Override
    public String getServiceCode() {
	System.out.println(getClass() + ": getServiceCode()");
	return serviceCode;
    }

    @Override
    public void setServiceCode(String serviceCode) {
	System.out.println(getClass() + ": setServiceCode()");
	this.serviceCode = serviceCode;
    }

}
