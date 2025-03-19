package com.jdc.online.balances.utils.formatter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class AppDateTimeFormatterModelAttributes {

	@ModelAttribute(name = "dtf")
	public AppDateTimeFormatter dateTimeFormatter() {
		return new AppDateTimeFormatter();
	}
}
