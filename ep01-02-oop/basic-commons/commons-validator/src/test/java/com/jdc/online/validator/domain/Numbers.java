package com.jdc.online.validator.domain;

import com.jdc.online.validator.annotations.MaxValue;
import com.jdc.online.validator.annotations.MinValue;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Numbers {

	@MinValue(value = 10)
	@MaxValue(value = 100)
	private byte byteValue;

	@MinValue(value = 10)
	@MaxValue(value = 100)
	private short shortValue;

	@MinValue(value = 10)
	@MaxValue(value = 100)
	private int intValue;

	@MinValue(value = 10)
	@MaxValue(value = 100)
	private long longValue;
}
