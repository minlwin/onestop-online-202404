package com.jdc.console.app.utils;

import java.text.DecimalFormat;

public interface FormatUtils {

	String FMT_STRING = "%%-%ds";
	String FMT_NUMBER = "%%%ds";
	
	DecimalFormat DF = new DecimalFormat("#,##0.00");
}
