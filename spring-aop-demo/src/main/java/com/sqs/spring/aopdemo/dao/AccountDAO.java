package com.sqs.spring.aopdemo.dao;

import com.sqs.spring.aopdemo.Account;

public interface AccountDAO {

    void addAccount();

    void addAccount(Account theAccount, boolean vipFlag);

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);
}
