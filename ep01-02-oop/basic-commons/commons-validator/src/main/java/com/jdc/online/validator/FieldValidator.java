package com.jdc.online.validator;

import java.lang.reflect.Field;

public interface FieldValidator {

	FieldError validate(Field field, Object object);
}
