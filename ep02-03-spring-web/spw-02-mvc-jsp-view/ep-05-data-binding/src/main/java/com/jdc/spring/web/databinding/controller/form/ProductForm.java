package com.jdc.spring.web.databinding.controller.form;


import com.jdc.spring.web.databinding.model.entity.Category;

import lombok.Data;

@Data
public class ProductForm {

	private String name;
	private int price;
	private Category category;
}
