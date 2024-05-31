package com.jdc.demo.hiding;

public class ChildType extends SuperType{

	private String instanceVariable = "Variable From Child";
	private static String staticVariable = "Static Variable From Child";

	public static void doStaticMathod() {
		System.out.println("Static Method From Child");
	}

	public void showFromChild() {
		
		System.out.printf("Instance Variable : %s.%n", instanceVariable);
		
		System.out.printf("Static Variable : %s.%n", staticVariable);
		
		doStaticMathod();
	}
	
	public void showFromChildForHidingMember() {
		
		System.out.printf("Instance Variable : %s.%n", super.instanceVariable);
		
		System.out.printf("Static Variable : %s.%n", SuperType.staticVariable);
		
		SuperType.doStaticMathod();
	}	
}
