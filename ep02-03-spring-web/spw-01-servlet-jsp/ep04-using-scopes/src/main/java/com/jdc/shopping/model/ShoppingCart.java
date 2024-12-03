package com.jdc.shopping.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	public void plus(int id) {
		var optional = findByProductId(id);
		
		optional.ifPresent(item -> {
			item.setQuantity(item.getQuantity() + 1);
		});
	}
	
	public void minus(int id) {
		var optional = findByProductId(id);
		
		optional.ifPresent(item -> {
			item.setQuantity(item.getQuantity() - 1);
			
			if(item.getQuantity() == 0) {
				items.remove(item);
			}
		});
	}
	
	private Optional<SaleItem> findByProductId(int id) {
		return items.stream().filter(a -> a.getProduct().getId() == id)
				.findAny();
	}

	public List<SaleItem> getItems() {
		return items;
	}
	
	public int getItemCount() {
		return items.stream().mapToInt(a -> a.getQuantity()).sum();
	}
	
	public int getAllTotal() {
		return items.stream().mapToInt(a -> a.getTotal()).sum();
	}
	
	public void clear() {
		items.clear();
	}
}
