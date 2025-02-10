package com.jdc.spring.model.entity;

import com.jdc.spring.model.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Account extends AuditableEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	private String profileImage;
	
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private Role role;
	
	@Column(name = "disable_column")
	private boolean disabled;
	
	public enum Role {
		Admin, Member
	}
}
