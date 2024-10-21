package com.jdc.spring.orm.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Tag implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String logo;
}
