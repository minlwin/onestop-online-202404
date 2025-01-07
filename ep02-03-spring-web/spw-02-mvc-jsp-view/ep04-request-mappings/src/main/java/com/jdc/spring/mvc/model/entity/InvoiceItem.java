package com.jdc.spring.mvc.model.entity;

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
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "invoice_id", insertable = false, updatable = false)
	private Invoice invoice;

	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	private Product product;
	
	private int quantity;
	private int price;
}
