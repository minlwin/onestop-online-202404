package com.jdc.stream.domain;

public record Product(
		String code,
		String name,
		int price
		) {

	public static Product from(String [] array) {
		return new Product(array[0], array[1], Integer.parseInt(array[2]));
	}
}
