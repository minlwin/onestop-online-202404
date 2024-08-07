package com.jdc.spring.processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.jdc.spring.beans.MyBean;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		if(bean instanceof MyBean myBean) {
			myBean.setValue("Hello bean post processor");
		}
		
		return bean;
	}
}
