package com.jdc.console.app.exceptions;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String[] messages;

	public ValidationException(String[] messages) {
		super();
		this.messages = messages;
	}

	public String[] getMessages() {
		return messages;
	}

}
