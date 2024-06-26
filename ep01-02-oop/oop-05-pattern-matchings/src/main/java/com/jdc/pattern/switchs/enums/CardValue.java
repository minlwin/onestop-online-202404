package com.jdc.pattern.switchs.enums;

public record CardValue<T extends Card>(
		T card,
		int value
		) {

}
