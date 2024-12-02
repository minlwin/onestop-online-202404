package com.jdc.shopping.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<SaleItem> items;
	
	public ShoppingCart() {
		items = new ArrayList<>();
	}
	
	public void addToCart(Product product) {
		
		var item = items.stream()
			.filter(a -> a.getProduct().getId() == product.getId())
			.findAny().orElseGet(() -> new SaleItem(product));
		
		if(item.getQuantity() == 0) {
			items.add(item);
		}
		
		item.setQuantity(item.getQuantity() + 1);
	}
	
	public List<SaleItem> getItems() {
		return items;
	}
	
	public int getItemCount() {
		return items.stream().mapToInt(a -> a.getQuantity()).sum();
	}
	
	public void clear() {
		items.clear();
	}
}
