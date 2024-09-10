package com.jdc.spring.pos.domain.input;

import java.util.List;

import lombok.Data;

@Data
public class ShoppingCart {

	private String salePerson;
	private List<SaleItem> items;
	
	
	public static ShoppingCart withName(String name) {
		var cart = new ShoppingCart();
		cart.setSalePerson(name);
		return cart;
	}
}
