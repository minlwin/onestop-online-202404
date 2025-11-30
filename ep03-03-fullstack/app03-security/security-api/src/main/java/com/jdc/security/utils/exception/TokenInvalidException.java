package com.jdc.security.utils.exception;

import org.springframework.security.core.AuthenticationException;

public class TokenInvalidException extends AuthenticationException{

	private static final long serialVersionUID = 1L;

	public TokenInvalidException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
