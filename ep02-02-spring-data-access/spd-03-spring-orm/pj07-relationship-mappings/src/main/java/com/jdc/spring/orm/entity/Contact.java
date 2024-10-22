package com.jdc.spring.orm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Contact {

	@Id
	private int id;
	
	@MapsId
	@OneToOne(optional = false)
	private Merchant merchant;
	
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false)
	private String email;

	private String building;
	private String street;
	private String quarter;
	private String township;
}
