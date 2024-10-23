package com.jdc.spring.orm.entity;

import java.math.BigDecimal;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class InvoiceItem {

	@EmbeddedId
	private InvoiceItemPk id;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Invoice invoice;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Product product;
	
	private int quantiry;
	private BigDecimal purchasePrice;
}
