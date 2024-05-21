package com.jdc.demo;

import org.junit.jupiter.api.Test;

public class OverrideTest {

	@Test
	void test() {
		Car car1 = new Car();
		RaceCar car2 = new RaceCar();
		
		test(car1);
		System.out.println("=============");
		
		test(car2);
		
		MiniCar car3 = new MiniCar();
		car3.drive();
		car3.park();
	}
	
	void test(Car car) {
		car.drive();
	}
}
