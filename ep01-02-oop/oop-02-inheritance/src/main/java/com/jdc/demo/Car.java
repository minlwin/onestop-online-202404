package com.jdc.demo;

public class Car {
	
	private String type;
	
	{
		System.out.println("Init Block of Car");
	}
	
	public Car() {
		this.type = "Car";
		System.out.println("Default Constructor of Car");
	}
	
	public Car(String type) {
		this.type = type;
		System.out.println("One Argument Constructor of Car");
	}

	public void drive() {
		System.out.printf("%s is driving%n", type);
	}
	
	public void park() {
		System.out.printf("%s is parking%n", type);
	}
}
