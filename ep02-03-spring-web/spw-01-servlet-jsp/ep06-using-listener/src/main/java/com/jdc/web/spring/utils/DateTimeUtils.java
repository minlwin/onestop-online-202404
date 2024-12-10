package com.jdc.web.spring.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class DateTimeUtils {

	private static final DateTimeFormatter DF = DateTimeFormatter
			.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public String format(LocalDateTime dateTime) {
		if(null != dateTime) {
			return dateTime.format(DF);
		}
		
		return null;
	}
}
