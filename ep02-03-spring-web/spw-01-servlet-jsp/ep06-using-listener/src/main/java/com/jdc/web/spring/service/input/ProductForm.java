package com.jdc.web.spring.service.input;

import lombok.Data;

@Data
public class ProductForm {

	private int categoryId;
	private String name;
	private int price;
	private boolean deleted;
}
