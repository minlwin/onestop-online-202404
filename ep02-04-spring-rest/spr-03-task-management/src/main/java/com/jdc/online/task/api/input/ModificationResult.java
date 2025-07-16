package com.jdc.online.task.api.input;

public record ModificationResult<ID>(
		ID id, 
		boolean success,
		String message) {

	public static<ID> ModificationResult<ID> success(ID id) {
		return new ModificationResult<>(id, true, null);
	}

}
