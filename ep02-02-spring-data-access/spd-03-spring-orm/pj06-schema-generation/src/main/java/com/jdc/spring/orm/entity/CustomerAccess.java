package com.jdc.spring.orm.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Entity
@Data
@IdClass(CustomerAccessId.class)
public class CustomerAccess {

	@Id
	private int customerId;
	@Id
	private LocalDateTime accessAt;
	
	private boolean success;
	private String remark;
}
