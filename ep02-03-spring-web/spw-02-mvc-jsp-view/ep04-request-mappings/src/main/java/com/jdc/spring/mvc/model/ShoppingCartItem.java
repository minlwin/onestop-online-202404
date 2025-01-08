package com.jdc.spring.mvc.model;

import com.jdc.spring.mvc.model.entity.Product;

import lombok.Data;

@Data
public class ShoppingCartItem {

	private Product product;
	private int quantity;
	
	public void plusOne() {
		quantity ++;
	}

	public void removeOne() {
		quantity --;
	}
}
