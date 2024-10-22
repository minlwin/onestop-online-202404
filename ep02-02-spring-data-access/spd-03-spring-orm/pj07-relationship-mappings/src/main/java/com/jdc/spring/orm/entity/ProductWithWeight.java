package com.jdc.spring.orm.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductWithWeight extends Product {

	private WeightUnit unit;
	
	public enum WeightUnit {
		Gram, KG
	}

}
