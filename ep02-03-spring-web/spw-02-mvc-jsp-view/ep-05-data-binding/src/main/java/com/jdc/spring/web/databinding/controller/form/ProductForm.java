package com.jdc.spring.web.databinding.controller.form;


import java.time.LocalDate;

import com.jdc.spring.web.databinding.model.entity.Category;
import com.jdc.spring.web.databinding.model.entity.Price;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductForm {

	private Integer id;
	
	@NotBlank(message = "Please enter product name.")
	private String name;
	@NotNull(message = "Please enter price.")
	private Price price;
	@NotNull(message = "Please select category.")
	private Category category;
	
	private LocalDate date;
}
