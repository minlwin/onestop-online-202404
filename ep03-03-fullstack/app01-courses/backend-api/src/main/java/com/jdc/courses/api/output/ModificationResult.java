package com.jdc.courses.api.output;

public record ModificationResult<T>(
		T id,
		boolean success,
		String message) {

}
