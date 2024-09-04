package com.jdc.spring.pos.domain.exceptions;

public class PosBusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PosBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public PosBusinessException(String message) {
		super(message);
	}

}
