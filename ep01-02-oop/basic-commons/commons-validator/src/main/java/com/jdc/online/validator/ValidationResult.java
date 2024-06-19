package com.jdc.online.validator;

import java.util.Arrays;

public class ValidationResult {

	private final FieldError[] errors;

	public ValidationResult(FieldError[] errors) {
		super();
		this.errors = errors;
	}
	
	public FieldError[] getErrors() {
		return Arrays.copyOf(errors, errors.length);
	}
	
	public boolean hasErrors() {
		return null != errors && errors.length > 0;
	}
}
