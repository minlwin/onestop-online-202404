package com.jdc.spring.jpa.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class OfficeStaff {

	@Id
	private UUID id;
	
	@MapsId
	@OneToOne(optional = false)
	private Account account;
	
	private String name;
	private String phone;
	private String email;
	
	private Position position;
	
	private LocalDate entryAt;
	private LocalDate retiredAt;
	
	public enum Position {
		Employee, SuperVisor, Manager
	}
}
