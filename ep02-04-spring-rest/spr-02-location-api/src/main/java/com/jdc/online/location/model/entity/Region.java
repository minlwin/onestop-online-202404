package com.jdc.online.location.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Region {

	@Id
	private int id;
	@Column(nullable = false)
	private String name;
}
