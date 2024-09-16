package com.jdc.spring.jdbc.domain;

public record ProductDetails(
		int id,
		String name,
		String category,
		String image,
		int price) {

}
