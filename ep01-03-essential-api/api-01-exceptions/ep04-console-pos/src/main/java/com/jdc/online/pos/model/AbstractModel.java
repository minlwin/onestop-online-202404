package com.jdc.online.pos.model;

import com.jdc.console.app.exceptions.ValidationException;
import com.jdc.online.validator.Validator;

public abstract class AbstractModel {

	private static Validator validator;
	
	static {
		validator = Validator.getInstance();
	}
	
	protected void validate(Object data) {
		
		var result = validator.validate(data);
		
		if(result.hasErrors()) {
			var messages = new String[result.getErrors().length];
			
			for(var i = 0; i < messages.length; i ++) {
				messages[i] = result.getErrors()[i].getMessage();
			}
			
			throw new ValidationException(messages);
		}
	}
}
