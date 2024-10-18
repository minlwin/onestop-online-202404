package com.jdc.spring.orm.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Invoice {
	
	@EmbeddedId
	private InvoiceId id;
	
	private int amount;
	private LocalDate dueDate;
	private LocalDateTime invoiceAt;
	
}
