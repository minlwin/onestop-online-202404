package com.jdc.web.spring.service.output;

import java.io.Serializable;

import lombok.Data;

@Data
public class ShoppingCartItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int productId;
	private String productName;
	private String image;
	private String category;
	private int quantity;
	private int salePrice;
	
	public int getTotal() {
		return quantity * salePrice;
	}
}
