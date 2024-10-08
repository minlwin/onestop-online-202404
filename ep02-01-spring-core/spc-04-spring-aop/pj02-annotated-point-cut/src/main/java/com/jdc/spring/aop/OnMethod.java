package com.jdc.spring.aop;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface OnMethod {

	Level value();
	
	public enum Level {
		Primary, Secondary, Final
	}
}
