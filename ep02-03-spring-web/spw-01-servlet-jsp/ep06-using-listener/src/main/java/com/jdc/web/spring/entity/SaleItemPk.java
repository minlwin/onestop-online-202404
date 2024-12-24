package com.jdc.web.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SaleItemPk {

	@Column(name = "sale_id")
	private int saleId;
	@Column(name = "product_id")
	private int productId;
}
