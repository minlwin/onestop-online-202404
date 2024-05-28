package com.jdc.demo.override;

public class Child extends Parent{

	public void jobForChild() {
		System.out.println("Job for child");
	}
	
	@Override
	public ReturnChild doSomething() {
		System.out.println("Doing something from child");
		return null;
	}
}
