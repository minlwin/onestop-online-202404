package com.jdc.demo;

import org.junit.jupiter.api.Test;

public class IsARelationshipTest {
	
	@Test
	void test() {
		var car = new Car();
		var truck = new TruckCar();
		
		testDrive(car);
		testDrive(truck);
	}

	void testDrive(Car car) {
		car.drive();
		car.park();
		
		if(car instanceof TruckCar) {
			TruckCar truck = (TruckCar)car;
			truck.loading();
		}
	}
}
