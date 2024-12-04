package com.jdc.web.cookies.controller.model;

import java.util.Base64;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserInformationMapper {

	private static ObjectMapper mapper = new ObjectMapper();

	public static UserInformation fromJson(String encodedValue) {
		
		if(null != encodedValue && !encodedValue.isBlank()) {
			try {
				var bytes = Base64.getDecoder().decode(encodedValue);
				var json = new String(bytes);
				return mapper.readValue(json, UserInformation.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public static String toJson(UserInformation info) {
		
		try {
			var json = mapper.writeValueAsString(info);
			return Base64.getEncoder().encodeToString(json.getBytes());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return null;
	}
}
