package com.jdc.spring.events.listeners;

import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.jdc.spring.events.MyEvent;

@Component
public class ContextEventListener {

	@EventListener
	public void onApplicationEvent(ApplicationContextEvent event) {
		System.out.println(event.getClass().getSimpleName());
	}

	@EventListener
	public void listen(MyEvent event) {
		System.out.println(event);
	}
}
