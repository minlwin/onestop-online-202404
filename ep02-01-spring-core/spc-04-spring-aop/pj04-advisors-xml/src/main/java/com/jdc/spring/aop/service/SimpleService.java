package com.jdc.spring.aop.service;

import java.time.DayOfWeek;

import org.springframework.stereotype.Service;

import com.jdc.spring.aop.advisor.OnMethod;

@Service
public class SimpleService {

	public void show(int id, String name, DayOfWeek day) {
		System.out.printf("SampleService#show id   : %s%n", id);
		System.out.printf("SampleService#show name : %s%n", name);
		System.out.printf("SampleService#show day  : %s%n%n", day);
	}
	
	@OnMethod
	public void showOnMethod(int id, String name, DayOfWeek day) {
		System.out.printf("SampleService#showWithLog id   : %s%n", id);
		System.out.printf("SampleService#showWithLog name : %s%n", name);
		System.out.printf("SampleService#showWithLog day  : %s%n", day);
	}	
}
