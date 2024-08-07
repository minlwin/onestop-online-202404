package com.jdc.spring.events.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import com.jdc.spring.events.MyEvent;

@Component
public class MyEventPublisher implements ApplicationEventPublisherAware{

	private ApplicationEventPublisher publisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}

	public void publish(MyEvent event) {
		publisher.publishEvent(event);
	}
}
