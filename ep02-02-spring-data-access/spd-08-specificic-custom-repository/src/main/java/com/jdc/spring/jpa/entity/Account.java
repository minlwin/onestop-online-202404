package com.jdc.spring.jpa.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false, unique = true)
	private String loginId;
	private String password;
	
	@Column(nullable = false)
	private Role role;

	private LocalDateTime activatedAt;
	private LocalDateTime expiredAt;
	
	public enum Role {
		Admin, Customer, Staff
	}
}
