package com.jdc.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.annotation.Configuration;

import com.jdc.spring.introduction.ExtraFunctions;
import com.jdc.spring.introduction.ExtraFunctionsImpl;

@Aspect
@Configuration
public class CommonAspect {

	@DeclareParents(
			value = "com.jdc.spring.introduction.MyService+",
			defaultImpl = ExtraFunctionsImpl.class)
	static ExtraFunctions extraFunctions;
}
