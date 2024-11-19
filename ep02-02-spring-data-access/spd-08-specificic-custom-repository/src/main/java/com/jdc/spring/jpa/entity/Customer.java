package com.jdc.spring.jpa.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	private UUID id;
	
	@MapsId
	@OneToOne(optional = false)
	private Account account;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false)
	private String email;

	private LocalDate dob;
	private Gender gender;
	
	public enum Gender {
		Male, Female
	}
}
