package com.jdc.spring.jdbc.domain;

public record ProductForm(
		String name,
		String category,
		String image,
		int price) {

}
