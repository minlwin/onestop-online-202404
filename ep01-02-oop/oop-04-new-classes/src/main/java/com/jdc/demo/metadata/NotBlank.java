package com.jdc.demo.metadata;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface NotBlank {

	// Primitives, String, Enum and their array
	String messages() default "Field must not be blank value";

	int value();
}
