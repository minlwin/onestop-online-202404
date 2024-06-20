package com.jdc.online.validator.provider;

import java.lang.reflect.Field;

import com.jdc.online.validator.FieldError;
import com.jdc.online.validator.annotations.NotNull;

public class FieldValidatorForNotNull extends AbstractFieldValidator {

	@Override
	public FieldError validate(Field field, Object object) {
		try {
			
			var annotation = field.getDeclaredAnnotation(NotNull.class);
			
			if(null != annotation) {
				
				field.setAccessible(true);
				if(null == field.get(object)) {
					return new FieldError(field.getName(), annotation.message());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
