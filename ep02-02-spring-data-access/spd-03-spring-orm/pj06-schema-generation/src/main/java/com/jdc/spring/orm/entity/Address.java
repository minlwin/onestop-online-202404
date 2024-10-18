package com.jdc.spring.orm.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {

	private String building;
	private String street;
	private String quarter;
	private String township;
}
