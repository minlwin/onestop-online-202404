package com.jdc.online.validator.provider;

import java.lang.reflect.Field;

import com.jdc.online.validator.FieldValidator;

public abstract class AbstractFieldValidator implements FieldValidator {

	protected boolean isIntegerType(Field field) {
		return field.getType() == byte.class 
				|| field.getType() == short.class
				|| field.getType() == int.class
				|| field.getType() == long.class;
	}
	
	protected boolean isStringType(Field field) {
		return field.getType() == String.class;
	}
}
