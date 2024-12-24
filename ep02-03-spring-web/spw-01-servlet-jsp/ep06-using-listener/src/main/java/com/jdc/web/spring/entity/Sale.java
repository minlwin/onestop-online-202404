package com.jdc.web.spring.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String customer;
	
	@Column(nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private String email;

	private LocalDateTime saleAt;
	
	@OneToMany(mappedBy = "sale")
	private List<SaleItem> items;
}
