package com.jdc.console.app.utils;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public interface FormatUtils {

	String FMT_STRING = "%%-%ds";
	String FMT_NUMBER = "%%%ds";
	
	DecimalFormat DECIF = new DecimalFormat("#,##0.00");
	DateTimeFormatter DATE_TIMEF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
}
