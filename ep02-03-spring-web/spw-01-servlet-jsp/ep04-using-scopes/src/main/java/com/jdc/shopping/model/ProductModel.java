package com.jdc.shopping.model;

import java.util.ArrayList;
import java.util.List;

public class ProductModel {

	private List<Product> products = new ArrayList<>();
	
	public ProductModel() {
		
		products.add(new Product(1, "Pepsi", "Drinks", 1200));
		products.add(new Product(2, "Coke", "Drinks", 1500));
		products.add(new Product(3, "Potato Chips", "Snacks", 1500));
		products.add(new Product(4, "Fish Chip", "Snacks", 1000));
		
	}
	
	public List<Product> getProducts() {
		return new ArrayList<Product>(products);
	}
	
	public Product findById(int id) {
		return products.stream()
				.filter(a -> a.getId() == id)
				.findAny()
				.orElse(null);
	}
}
