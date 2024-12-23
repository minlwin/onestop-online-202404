package com.jdc.web.spring.service.output;

import java.time.LocalDateTime;

import com.jdc.web.spring.entity.SaleItem;

import lombok.Data;

@Data
public class SaleItemInfo {

	private String product;
	private String category;
	private LocalDateTime saleAt;
	private int quantity;
	private int salePrice;
	
	public int getTotal() {
		return quantity * salePrice;
	}
	
	public static SaleItemInfo from(SaleItem entity) {
		
		var info = new SaleItemInfo();
		info.setProduct(entity.getProduct().getName());
		info.setCategory(entity.getProduct().getCategory().getName());
		info.setSaleAt(entity.getSale().getSaleAt());
		info.setQuantity(entity.getQuantity());
		info.setSalePrice(entity.getSalePrice());
		
		return info;
	}
}
