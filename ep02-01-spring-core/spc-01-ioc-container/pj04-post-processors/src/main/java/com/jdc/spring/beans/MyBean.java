package com.jdc.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class MyBean {

	private String value;
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
