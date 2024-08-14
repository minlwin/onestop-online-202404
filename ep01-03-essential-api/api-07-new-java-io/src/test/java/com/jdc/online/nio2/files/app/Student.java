package com.jdc.online.nio2.files.app;

public record Student(String name, String phone, String email) {

	public String line() {
		return "%s\t%s\t%s%n".formatted(name, phone, email);
	}
	
	public static Student from(String line) {
		var array = line.split("\t");
		return new Student(array[0], array[1], array[2]);
	}
}
