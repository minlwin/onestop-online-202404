package com.jdc.spring.model.entity;

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
public class AccessHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false)
	private String username;
	private Type type;
	private Status status;
	private LocalDateTime accessAt;
	private String remark;
	
	public enum Type {
		Login, RememberMeLogin, Logout
	}
	
	public enum Status {
		Success, Fails
	}
}
