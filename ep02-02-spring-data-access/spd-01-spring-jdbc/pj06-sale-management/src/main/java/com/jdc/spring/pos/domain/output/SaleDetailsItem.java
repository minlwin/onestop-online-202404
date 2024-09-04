package com.jdc.spring.pos.domain.output;

import lombok.Data;

@Data
public class SaleDetailsItem {

	private int id;
	private String productCode;
	private String productName;
	private int unitPrice;
	private int quantity;
	
	public int getTotal() {
		return unitPrice * quantity;
	}
}
