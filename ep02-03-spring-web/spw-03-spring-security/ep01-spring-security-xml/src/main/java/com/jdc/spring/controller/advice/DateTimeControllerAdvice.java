package com.jdc.spring.controller.advice;

import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class DateTimeControllerAdvice {

	private final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@ModelAttribute("dateTimes")
	DateTimeFormatter dateTimeFormatter() {
		return DTF;
	}
}
