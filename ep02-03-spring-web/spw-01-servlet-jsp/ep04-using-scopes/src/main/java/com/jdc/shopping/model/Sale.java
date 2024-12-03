package com.jdc.shopping.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class Sale {

	private int id;
	private LocalDateTime saleAt;
	private String customer;
	private String phone;
	private String email;
	
	private List<SaleItem> items;
	
	public int getItemCount() {
		return items.stream().mapToInt(a -> a.getQuantity()).sum();
	}
	
	public int getTotal() {
		return items.stream().mapToInt(a -> a.getTotal()).sum();
	}
}
