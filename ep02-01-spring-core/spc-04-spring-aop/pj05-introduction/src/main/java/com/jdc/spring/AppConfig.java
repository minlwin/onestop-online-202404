package com.jdc.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@Import(value = CommonAspect.class)
@ComponentScan("com.jdc.spring.introduction")
public class AppConfig {

}
