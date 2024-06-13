package com.jdc.demo.model;

import com.jdc.demo.metadata.NotBlank;

import lombok.Data;

@Data
public class Category {

	private int id;
	@NotBlank(value = 10, messages = "Please enter name")
	private String name;
	private String image;
}
