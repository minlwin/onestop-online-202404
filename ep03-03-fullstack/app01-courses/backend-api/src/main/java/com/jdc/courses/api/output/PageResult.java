package com.jdc.courses.api.output;

import java.util.List;

public record PageResult<T>(
		List<T> list,
		PageInfo pageInfo) {

}
