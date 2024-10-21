package com.jdc.spring.orm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import lombok.Data;

@Data
@Entity
@TableGenerator(name = "employee_seq", allocationSize = 1)
public class Employee {

	@Id
	@GeneratedValue(generator = "employee_seq")
	private long id;
	private String name;
}
