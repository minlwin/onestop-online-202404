package com.jdc.spring.jpa.entity.converter;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import jakarta.persistence.AttributeConverter;

public class DaysConverter implements AttributeConverter<List<DayOfWeek>, String>{

	@Override
	public String convertToDatabaseColumn(List<DayOfWeek> attribute) {
		
		if(null != attribute) {
			return attribute.stream()
				.map(DayOfWeek::name)
				.collect(Collectors.joining(","));
		}

		
		return null;
	}

	@Override
	public List<DayOfWeek> convertToEntityAttribute(String dbData) {
		
		if(StringUtils.hasLength(dbData)) {
			return Arrays.stream(dbData.split(",")).map(str -> DayOfWeek.valueOf(str))
			.toList();
		}
		
		return null;
	}

}
