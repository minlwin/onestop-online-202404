package com.jdc.spring.attr.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Parent {

	private String name;
	private String occupation;
}
