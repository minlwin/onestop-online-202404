package com.jdc.spring.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.spring.other.OtherMessageSender;

@SpringJUnitConfig(locations = "classpath:/point-cuts.xml")
public class PointCutAdviceTest {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private AdviceArgumentsDemo argumentsDemo;
	
	@Autowired
	private OtherMessageSender otherMessageSender;
	
	@Test
	void test() {

		messageService.send("Sending Message");
		messageService.hello();
		
		System.out.println();
		
		argumentsDemo.getLength("Hello Arguments");
		
		System.out.println();

		otherMessageSender.send(3, "Other Message");
		otherMessageSender.twice(10);
		otherMessageSender.send("Single String Message");
		
	}
}
