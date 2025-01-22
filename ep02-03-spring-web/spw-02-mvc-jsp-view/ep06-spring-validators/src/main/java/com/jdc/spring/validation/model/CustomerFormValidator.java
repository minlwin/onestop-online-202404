package com.jdc.spring.validation.model;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(CustomerForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if(target instanceof CustomerForm form) {
			
			if(!StringUtils.hasLength(form.getName())) {
				errors.rejectValue("name", null, "Please enter customer name.");
			}

			if(!StringUtils.hasLength(form.getPhone())) {
				errors.rejectValue("phone", null, "Please enter phone number.");
			}

			if(!StringUtils.hasLength(form.getEmail())) {
				errors.rejectValue("email", null, "Please enter email address.");
			}
			
			if(null == form.getGender()) {
				errors.rejectValue("gender", null, "Please select gender.");
			}

			if(null == form.getDob()) {
				errors.rejectValue("dob", null, "Please select date of birth.");
			}
		}
	}

}
