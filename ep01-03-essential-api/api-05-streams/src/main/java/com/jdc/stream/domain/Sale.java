package com.jdc.stream.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record Sale(
		int id,
		String category,
		String product,
		int unitPrice,
		int quantity,
		LocalDateTime saleAt) implements Comparable<Sale>{

	static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	@Override
	public int compareTo(Sale o) {
		return id - o.id;
	}

	public int getTotal() {
		return unitPrice * quantity;
	}
	
	public static Sale from(String [] array) {
		var id = Integer.parseInt(array[0]);
		var price = Integer.parseInt(array[3]);
		var quantity = Integer.parseInt(array[4]);
		var saleAt = LocalDateTime.parse(array[5], df);
		
		return new Sale(id, array[1], array[2], price, quantity, saleAt);
	}
}
