package com.jdc.online.spring.data.dto;

public record CustomerDto(
		int id,
		String name,
		String phone) {
	
	public String getLongName() {
		return "%d %s".formatted(id, name);
	}
}
