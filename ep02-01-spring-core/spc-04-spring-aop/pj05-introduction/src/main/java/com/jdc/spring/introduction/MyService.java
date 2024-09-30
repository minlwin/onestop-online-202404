package com.jdc.spring.introduction;

import org.springframework.stereotype.Service;

@Service
public class MyService {

	public void send(String message) {
		System.out.printf("My Service : %s%n", message);
	}
}
