package com.jdc.spring.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Customer.update", 
	query = "update Customer c set c.name = :name, c.phone = :phone, c.lastModifiedAt = :now where c.id = :id")
@NamedQuery(name = "Customer.delete", 
	query = "delete from Customer c where c.id = :id")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false, unique = true)
	private String email;
	
	private LocalDateTime lastModifiedAt;
	
	@PreUpdate
	public void updateAt() {
		lastModifiedAt = LocalDateTime.now();
	}
	
	@PreRemove
	public void removeAt() {
		System.out.printf("Remove %s.%n", name);
	}
}
