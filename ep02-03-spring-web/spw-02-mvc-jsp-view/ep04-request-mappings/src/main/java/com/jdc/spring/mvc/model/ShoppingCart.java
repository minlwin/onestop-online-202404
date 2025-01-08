package com.jdc.spring.mvc.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jdc.spring.mvc.model.entity.Product;

public class ShoppingCart {

	private final Map<Integer, ShoppingCartItem> items = new LinkedHashMap<>();
	
	public void addToCart(Product p) {
		var item = items.get(p.getId());
		
		if(null == item) {
			item = new ShoppingCartItem();
			item.setProduct(p);
			items.put(p.getId(), item);
		}
		
		item.plusOne();
	}
	
	public void removeFromCart(int productId) {
		var item = items.get(productId);
		
		if(null != item) {
			item.removeOne();
			
			if(item.getQuantity() == 0) {
				items.remove(productId);
			}
		}
	}
	
	public int getTotalItems() {
		return items.values().stream()
				.mapToInt(a -> a.getQuantity())
				.sum();
	}
	
	public int getTotalAmount() {
		return items.values().stream()
				.mapToInt(a -> a.getQuantity() * a.getProduct().getPrice())
				.sum();
	}
	
	public List<ShoppingCartItem> getItems() {
		return new ArrayList<>(items.values());
	}
}
