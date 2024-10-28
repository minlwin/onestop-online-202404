package com.jdc.spring.attr.entity;

import java.util.List;

import com.jdc.spring.attr.entity.converter.ListToStringConverter;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String phone;
	
	@Column(columnDefinition = "LONGTEXT")
	@Convert(converter = ListToStringConverter.class)
	private List<String> interests;
	
	@AttributeOverride(name = "name", column = @Column(name = "father_name"))
	@AttributeOverride(name = "occupation", column = @Column(name = "father_occupation"))
	private Parent father;

	@AttributeOverride(name = "name", column = @Column(name = "mother_name"))
	@AttributeOverride(name = "occupation", column = @Column(name = "mother_occupation"))
	private Parent mother;
}
