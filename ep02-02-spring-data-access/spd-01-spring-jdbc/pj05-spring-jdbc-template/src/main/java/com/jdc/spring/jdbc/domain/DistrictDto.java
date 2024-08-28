package com.jdc.spring.jdbc.domain;

public record DistrictDto(
		int id,
		String name,
		int divisionId,
		String divisionName,
		long townships
		) {

}
