package com.jdc.security.utils.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	List<String> handle(MethodArgumentNotValidException e) {
		return e.getFieldErrors().stream()
				.map(a -> a.getDefaultMessage())
				.toList();
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.GONE)
	List<String> handle(TokenExpirationException e) {
		return List.of(e.getMessage());
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	List<String> handle(AuthenticationException e) {
		return List.of(e.getMessage());
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	List<String> handle(AccessDeniedException e) {
		return List.of(e.getMessage());
	}
	
	
}
