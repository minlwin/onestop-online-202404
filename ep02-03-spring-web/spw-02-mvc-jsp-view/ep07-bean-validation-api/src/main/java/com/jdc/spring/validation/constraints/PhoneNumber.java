package com.jdc.spring.validation.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = PhoneNumberConstraint.class)
public @interface PhoneNumber {

	String message() default "Please enter valid phone number.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
