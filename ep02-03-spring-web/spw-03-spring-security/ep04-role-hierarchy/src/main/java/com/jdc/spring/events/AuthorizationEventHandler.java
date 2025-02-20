package com.jdc.spring.events;

import org.springframework.context.event.EventListener;
import org.springframework.security.authorization.event.AuthorizationDeniedEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthorizationEventHandler {

	@EventListener
	public<T> void handle(AuthorizationDeniedEvent<T> event) {
		log.debug("{} is fails to access.", event.getAuthentication().get().getName());
	}
}
