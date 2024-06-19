package com.jdc.online.validator.provider;

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
		// TODO Auto-generated method stub
		return null;
	}

}
