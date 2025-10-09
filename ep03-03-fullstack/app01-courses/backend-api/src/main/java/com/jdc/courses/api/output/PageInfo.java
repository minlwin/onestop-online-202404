package com.jdc.courses.api.output;

import java.util.List;

public record PageInfo(
		int page,
		int size,
		int totalCount) {
	
	public int getTotalPage() {
		var rem = totalCount % size;
		var pages = totalCount / size;
		return rem == 0 ? pages : pages + 1; 
	}

	public List<Integer> getLinks() {
		return List.of();
	}
}
