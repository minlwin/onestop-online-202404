package com.jdc.web.spring.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(optional = false)
	private Category category;
	
	@Column(nullable =  false)
	private String name;
	
	private String image;
	private int price;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	private boolean deleted;

	@OneToMany(mappedBy = "product")
	private List<SaleItem> saleItems;
}
