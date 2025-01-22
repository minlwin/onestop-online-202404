package com.jdc.spring.validation.constraints;

import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PhoneNumberConstraint implements ConstraintValidator<PhoneNumber, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(StringUtils.hasLength(value)) {
			// 091-1111-1111
			// 091 1111 1111
			var pattern = Pattern.compile("^09\\d([- ](\\d){4}){2}$");
			var matcher = pattern.matcher(value);
			return matcher.matches();
		}
		
		return false;
	}

}
