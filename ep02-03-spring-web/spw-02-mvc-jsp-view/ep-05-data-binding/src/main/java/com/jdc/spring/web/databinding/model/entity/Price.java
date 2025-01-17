package com.jdc.spring.web.databinding.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Price {

	private Integer price;
	private String currency;
}
