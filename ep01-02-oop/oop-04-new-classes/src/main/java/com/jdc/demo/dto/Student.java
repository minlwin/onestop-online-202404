package com.jdc.demo.dto;

public record Student(
		int id,
		String name,
		String phone
		) {

	public Student(int id, String name) {
		this(id, name, null);
	}
}
