package com.jdc.demo;

public class RaceCar extends Car {

	@Override
	public void drive() {
		System.out.println("I am running too fast!");
	}
	
	public void turboOn() {
		System.out.println("Yee ha!");
	}
}
