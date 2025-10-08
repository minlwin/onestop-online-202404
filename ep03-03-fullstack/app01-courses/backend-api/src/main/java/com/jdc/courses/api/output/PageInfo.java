package com.jdc.courses.api.output;

import java.util.List;

public record PageInfo(
		int page,
		int size,
		int totalCount,
		int totalPage,
		List<Integer> links) {

}
