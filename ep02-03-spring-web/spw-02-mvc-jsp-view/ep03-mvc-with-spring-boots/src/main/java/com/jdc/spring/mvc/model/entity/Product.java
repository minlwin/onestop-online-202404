package com.jdc.spring.mvc.model.entity;

import java.time.LocalDateTime;

import org.springframework.util.StringUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

	public String getDefaultImage() {
		if(StringUtils.hasLength(image)) {
			
			var array = image.split(",");
			
			if(array.length > 0) {
				return array[0];
			}
		}
		
		return "default-image.jpg";
	}
}
