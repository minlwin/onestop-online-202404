package com.jdc.spring.pos.domain.output;

import lombok.Data;

@Data
public class ProductDto {

	private String code;
	private String name;
	private int price;
}
