package com.jdc.spring.pos.domain.input;

import lombok.Data;

@Data
public class SaleItem {

	private int saleId;
	private String productCode;
	private int unitPrice;
	private int quantity;
}
