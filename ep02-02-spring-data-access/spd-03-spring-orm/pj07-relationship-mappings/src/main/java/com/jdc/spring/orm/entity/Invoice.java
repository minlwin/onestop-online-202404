package com.jdc.spring.orm.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Invoice extends SecurityInfo{

	@Id
	@GeneratedValue
	private UUID id;
	
	@ManyToOne(optional = false)
	private Merchant merchant;
	
	@Column(nullable = false)
	private LocalDate invoiceDate;
	
	@Column(nullable = false)
	private LocalDate dueDate;
	
	@Column(nullable = false)
	private BigDecimal invoiceTotal;
	
	@ManyToOne
	private Settlement settlement;
}
