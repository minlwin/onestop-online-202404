package com.jdc.spring.mvc.controller.output;

import com.jdc.spring.mvc.model.entity.Product;

public record ProductInfo(
		int id,
		String name,
		String category,
		int price) {

	public ProductInfo(Product p) {
		this(p.getId(), p.getName(), p.getCategory(), p.getPrice());
	}
}
