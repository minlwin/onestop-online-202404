package com.jdc.spring.aop.beans;

import org.springframework.stereotype.Service;

import com.jdc.spring.aop.OnType;

@OnType("Type Information")
@Service
public class BeanWithAnnotatedType extends BeanWithAnnotatedTypeBase{

	public void ownMethod() {
		System.out.println("Method from target class.");
	}
}
