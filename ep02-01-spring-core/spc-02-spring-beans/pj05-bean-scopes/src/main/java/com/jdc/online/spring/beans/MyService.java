package com.jdc.online.spring.beans;

import java.util.ArrayList;
import java.util.List;

public class MyService {
	
	private List<String> messages = new ArrayList<>();
	
	public List<String> getMessages() {
		return List.copyOf(messages);
	}
	
	public void addMessage(String message) {
		messages.add(message);
	}
}
