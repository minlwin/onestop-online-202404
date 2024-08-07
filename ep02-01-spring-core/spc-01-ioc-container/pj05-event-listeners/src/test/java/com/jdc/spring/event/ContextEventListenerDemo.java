package com.jdc.spring.event;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.spring.events.ApplicationConfig;
import com.jdc.spring.events.MyEvent;
import com.jdc.spring.events.publisher.MyEventPublisher;

public class ContextEventListenerDemo {

	@Test
	void demo() {
		
		try(var context = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
			
			var publisher = context.getBean(MyEventPublisher.class);
			publisher.publish(new MyEvent("My first Event"));
			publisher.publish(new MyEvent("My Second Event"));
		}
	}
}
