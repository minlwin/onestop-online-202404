package com.jdc.spring.mvc.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private LocalDate dob;
	@Column(nullable = false)
	private Gender gender;
	@Column(nullable = false)
	private String phone;
	
	public enum Gender {
		Male, Female
	}
}
