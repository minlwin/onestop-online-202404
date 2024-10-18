package com.jdc.spring.orm.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String phone;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	public enum Gender {
		Male, Female
	}
}
