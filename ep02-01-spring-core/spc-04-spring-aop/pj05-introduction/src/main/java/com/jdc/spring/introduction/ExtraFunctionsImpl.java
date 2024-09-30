package com.jdc.spring.introduction;

import java.time.LocalDateTime;

public class ExtraFunctionsImpl implements ExtraFunctions{
	
	private int accessCount;
	
	@Override
	public void logTime() {
		System.out.printf("Access Count : %d%n", ++ accessCount);
		System.out.printf("Access At    : %s%n", LocalDateTime.now());
	}

}
