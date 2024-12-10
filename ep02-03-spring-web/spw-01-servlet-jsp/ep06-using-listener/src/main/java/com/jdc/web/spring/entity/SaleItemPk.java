package com.jdc.web.spring.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SaleItemPk {

	private int saleId;
	private int productId;
}
