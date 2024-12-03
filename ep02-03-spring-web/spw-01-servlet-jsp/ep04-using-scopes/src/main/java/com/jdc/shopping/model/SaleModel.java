package com.jdc.shopping.model;

import java.util.ArrayList;
import java.util.List;

public class SaleModel {

	private List<Sale> sales;
	
	public SaleModel() {
		sales = new ArrayList<>();
	}
	
	public int addSale(Sale sale) {
		sale.setId(sales.size() + 1);
		sales.add(sale);
		return sale.getId();
	}
	
	public Sale findById(int id) {
		return sales.stream().filter(a -> a.getId() == id)
				.findAny().orElse(null);
	}
	
	public List<Sale> getSales() {
		return new ArrayList<>(sales);
	}
	
	public int getAllTotal() {
		return sales.stream()
				.mapToInt(a -> a.getTotal()).sum();
	}
}
