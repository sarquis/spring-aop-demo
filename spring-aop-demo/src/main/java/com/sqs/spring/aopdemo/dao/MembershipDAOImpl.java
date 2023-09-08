package com.sqs.spring.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public boolean addMembershipAccount() {
	System.out.println(getClass() + ": ADDING AN ACCOUNT");
	return true;
    }

}
