package com.jdc.spring.orm.entity;

import java.util.List;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyColumn;
import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int price;
	
	@ElementCollection
	@CollectionTable(name = "tag")
	private List<Tag> tags;
	
	@ElementCollection
	@MapKeyColumn(name = "language")
	@CollectionTable(name = "tag_languages")
	private Map<String, Tag> languageByTag;
}
