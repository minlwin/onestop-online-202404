package com.jdc.web.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class SaleItem {

	@EmbeddedId
	private SaleItemPk id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "sale_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Sale sale;

	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Product product;
	
	@Column(nullable = false)
	private int quantity;

	@Column(nullable = false)
	private int salePrice;
	
}
