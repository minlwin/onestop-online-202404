package com.jdc.demo.functional;

@FunctionalInterface
public interface Flyable {

	void fly();
	
	default void test() {
		
	}
}
