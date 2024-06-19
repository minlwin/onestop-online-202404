package com.jdc.online.validator.provider;

import java.lang.reflect.Field;
import java.util.Arrays;

import com.jdc.online.validator.FieldError;
import com.jdc.online.validator.FieldValidator;
import com.jdc.online.validator.ValidationResult;
import com.jdc.online.validator.Validator;

public class OneStopValidator implements Validator {

	private FieldValidator[] validators;

	public OneStopValidator(FieldValidator[] validators) {
		super();
		this.validators = validators;
	}

	@Override
	public ValidationResult validate(Object data) {
		
		FieldError[] errors = {};
		Field[] fields = data.getClass().getDeclaredFields();
		
		for(Field field : fields) {
			for(FieldValidator validator : validators) {
				FieldError error = validator.validate(field, data);
				
				if(null != error) {
					errors = Arrays.copyOf(errors, errors.length + 1);
					errors[errors.length - 1] = error;
				}
			}
		}
		
		return new ValidationResult(errors);
	}


}
