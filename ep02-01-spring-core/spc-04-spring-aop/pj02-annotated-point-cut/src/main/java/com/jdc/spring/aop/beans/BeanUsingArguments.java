package com.jdc.spring.aop.beans;

import org.springframework.stereotype.Service;

import com.jdc.spring.aop.args.Wrapper;

@Service
public class BeanUsingArguments {

	public void useString(String message) {
		System.out.printf("BeanUsingArguments#useString accept %s%n", message);
	}
	
	public void useWrapper(Wrapper wrapper) {
		System.out.printf("BeanUsingArguments#useWrapper accept %s%n", wrapper);
	}
}
