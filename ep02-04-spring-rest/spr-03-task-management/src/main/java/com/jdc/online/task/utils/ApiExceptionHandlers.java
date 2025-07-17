package com.jdc.online.task.utils;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandlers {
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	List<String> handle(MethodArgumentNotValidException e) {
		return e.getFieldErrors().stream()
				.map(a -> a.getDefaultMessage())
				.toList();
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	List<String> handle(ApiBusinessException e) {
		return List.of(e.getMessage());
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	List<String> handle(Throwable e) {
		log.error("System Error", e);
		return List.of("System Error");
	}
}
