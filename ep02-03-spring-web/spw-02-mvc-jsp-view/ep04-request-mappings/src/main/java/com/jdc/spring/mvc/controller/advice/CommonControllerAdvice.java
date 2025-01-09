package com.jdc.spring.mvc.controller.advice;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonControllerAdvice {

	@Value("${spring.mvc.format.date-time}")
	private String dateTimeFormat;
	
	@ModelAttribute("dateTimes")
	public DateTimeFormatter dateTimes() {
		return DateTimeFormatter.ofPattern(dateTimeFormat);
	}
	
	@ExceptionHandler
	public ModelAndView handle(NumberFormatException e) {
		
		var mv = new ModelAndView("error");
		mv.getModelMap().put("message", "There is number format Exception.");
		
		return mv;
	}
}
