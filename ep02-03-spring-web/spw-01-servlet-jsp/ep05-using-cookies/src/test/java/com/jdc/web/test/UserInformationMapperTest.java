package com.jdc.web.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jdc.web.cookies.controller.model.UserInformation;
import com.jdc.web.cookies.controller.model.UserInformationMapper;

public class UserInformationMapperTest {

	@Test
	void writeJson() {
		
		var object = new UserInformation("Aung Aung", "091717161", "aung@gmail.com");
		
		var json = UserInformationMapper.toJson(object);
		
		var parse = UserInformationMapper.fromJson(json);
		
		assertEquals(object, parse);
	}
}
