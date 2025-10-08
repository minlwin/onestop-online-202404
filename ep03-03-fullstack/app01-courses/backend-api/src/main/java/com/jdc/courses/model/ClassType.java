package com.jdc.courses.model;

public enum ClassType {
	Zoom("Online"), 
	Video("Online"), 
	Weekend("Campus"), 
	Weekday("Campus");
	
	private String value;

	private ClassType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getDisplayName() {
		return "%s %s class".formatted(value, name());
	}
}
