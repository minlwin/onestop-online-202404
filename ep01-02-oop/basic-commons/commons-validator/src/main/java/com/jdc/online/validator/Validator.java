package com.jdc.online.validator;

import com.jdc.online.validator.provider.FieldValidatorForMaxLength;
import com.jdc.online.validator.provider.FieldValidatorForMaxValue;
import com.jdc.online.validator.provider.FieldValidatorForMinLength;
import com.jdc.online.validator.provider.FieldValidatorForMinValue;
import com.jdc.online.validator.provider.FieldValidatorForNotBlank;
import com.jdc.online.validator.provider.FieldValidatorForNotNull;
import com.jdc.online.validator.provider.OneStopValidator;

public interface Validator {

	ValidationResult validate(Object data);
	
	static Validator getInstance() {
		return new OneStopValidator(
			new FieldValidatorForMaxLength(),
			new FieldValidatorForMaxValue(),
			new FieldValidatorForMinLength(),
			new FieldValidatorForMinValue(),
			new FieldValidatorForNotBlank(),
			new FieldValidatorForNotNull()
		);
	}
}
