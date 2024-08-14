package com.jdc.online.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class MyServiceTwo implements MyService {

	@Override
	public String message() {
		return "Hello from My Service two.";
	}	
}
