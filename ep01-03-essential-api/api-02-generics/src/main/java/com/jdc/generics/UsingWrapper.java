package com.jdc.generics;

public class UsingWrapper {
	
	public static void use(Wrapper<?> wrapper) {
		
	}
	
	public static void useNumber(NumberWrapper<?> wrapper) {
		
	}
	
	public Wrapper<?> getWrapper() {
		return null;
	}

	public static void main(String[] args) {
		use(new NumberWrapper<Number>());
		
		use(new NumberWrapper<Integer>());
		
		useNumber(new NumberWrapper<Number>());
		
		useNumber(new NumberWrapper<Integer>());
		
		Wrapper<?> wrapper = new NumberWrapper<Number>();
		
		System.out.println(wrapper.getData());
	}
}
