package com.jdc.exceptions.demo;

public class Class2 {

	private Class3 instance;
	
	public Class2() {
		instance = new Class3();
	}
	
	public int divide(int a, int b) {
		
		System.out.println("Class 2 Work");
		
		try {
			var value = instance.divide(a, b);
			
			return value;
		} catch (NullPointerException 
				| ArithmeticException 
				| ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Class 2 Work End");
		}
		
		return 0;
	}

}
