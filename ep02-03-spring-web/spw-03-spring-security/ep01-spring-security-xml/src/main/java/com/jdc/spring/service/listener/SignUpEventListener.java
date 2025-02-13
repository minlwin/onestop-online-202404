package com.jdc.spring.service.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.jdc.spring.service.AccessHistoryService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SignUpEventListener {
	
	private final AccessHistoryService service;

	@EventListener
	public void handle(SignUpEvent event) {
		service.signup(event.username());
	}
}
