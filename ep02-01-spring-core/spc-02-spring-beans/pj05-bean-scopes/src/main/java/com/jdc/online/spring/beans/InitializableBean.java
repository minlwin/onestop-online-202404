package com.jdc.online.spring.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class InitializableBean implements InitializingBean, DisposableBean {

	@PostConstruct
	private void postConstruct() {
		System.out.println("Post Construct");
	}

	@PreDestroy
	private void preDestroy() {
		System.out.println("Pre Destroy");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("After Properties Set");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy");
	}

	public void init() {
		System.out.println("Init Method");
	}
	
	public void cleanUp() {
		System.out.println("Clean Up");
	}

}
