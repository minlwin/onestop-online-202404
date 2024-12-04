package com.jdc.web.cookies.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInformation {

	private String name;
	private String phone;
	private String email;
}
