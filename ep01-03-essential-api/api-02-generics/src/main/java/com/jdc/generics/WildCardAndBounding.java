package com.jdc.generics;

public class WildCardAndBounding {

	public static void useInTypeVariable(Wrapper<? extends Number> wrapper) {
		useData(wrapper.getData());
	}
	
	private static void useData(Number number) {
		
	}
	
	public static void useOutTypeVariable(Wrapper<? super Number> wrapper) {
		wrapper.setData(getData());
	}
	
	private static Number getData() {
		return 10.1;
	}
	
	public static void main(String[] args) {
		
		useInTypeVariable(new NumberWrapper<Integer>());
		
		useOutTypeVariable(new NumberWrapper<Number>());
	}
}
