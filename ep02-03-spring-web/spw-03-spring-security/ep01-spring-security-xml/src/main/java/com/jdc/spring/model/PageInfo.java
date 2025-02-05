package com.jdc.spring.model;

import java.util.List;

public record PageInfo<T>(
		List<T> contents,
		int page,
		int size,
		long count) {

}
