package com.jdc.spring.orm.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CustomerAccessId {

	private int customerId;
	private LocalDateTime accessAt;

}
