package com.jdc.web.spring.service.output;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jdc.web.spring.entity.Product;

public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ShoppingCartItem> items = new ArrayList<>();
	
	public List<ShoppingCartItem> getItems() {
		return items;
	}
	
	public void add(Product p) {
		var item =  items.stream().filter(a -> a.getProductId() == p.getId()).findAny().orElse(null);
		
		if(item != null) {
			item.setQuantity(item.getQuantity() + 1);
		} else {
			item = new ShoppingCartItem();
			item.setCategory(p.getCategory().getName());
			item.setProductId(p.getId());
			item.setProductName(p.getName());
			item.setImage(p.getDefaultImage());
			item.setQuantity(1);
			item.setSalePrice(p.getPrice());
			items.add(item);
		}
	}
	
	public void addOne(int productId) {
		items.stream().filter(a -> a.getProductId() == productId).findAny().ifPresent(item -> {
			item.setQuantity(item.getQuantity() + 1);
		});
		
	}
	
	public void removeOne(int productId) {
		var item = items.stream().filter(a -> a.getProductId() == productId).findAny().orElse(null);
		
		if(null != item) {
			item.setQuantity(item.getQuantity() - 1);
			if(item.getQuantity() == 0) {
				items.remove(item);
			}
		}
	}
	
	public void clear() {
		items.clear();
	}
	
	public int getTotalItems() {
		return items.stream().mapToInt(a -> a.getQuantity()).sum();
	}
	
	public int getTotalPrice() {
		return items.stream().mapToInt(a -> a.getTotal()).sum();
	}
}
