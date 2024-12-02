package com.jdc.shopping.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class SaleItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Product product;
	private int quantity;
	
	public SaleItem(Product product) {
		this.product = product;
	}
	
	public int getTotal() {
		return product.getPrice() * quantity;
	}
}
