package com.jdc.demo;

import org.junit.jupiter.api.Test;

public class TypeCastingTest {

	@Test
	void test_implicit_casting() {
		Car car = new TruckCar();
		car.drive();
	}
	
	@Test
	void test_explicit_casting() {

		Car car = new TruckCar();
		
		TruckCar truck = (TruckCar)car;
		truck.drive();
	}
}
