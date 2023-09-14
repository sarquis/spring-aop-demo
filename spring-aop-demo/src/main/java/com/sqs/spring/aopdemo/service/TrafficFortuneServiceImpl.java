package com.sqs.spring.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

    @Override
    public String getFortune() {

	try {
	    TimeUnit.SECONDS.sleep(5);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	return "Expect heavy traffice this morning";
    }

    @Override
    public String getFortune(boolean tripWire) {
	if (tripWire)
	    throw new RuntimeException("Major Accident!");

	return getFortune();
    }

}
