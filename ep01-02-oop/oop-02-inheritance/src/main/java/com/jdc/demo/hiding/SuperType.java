package com.jdc.demo.hiding;

public class SuperType {

	protected String instanceVariable = "Variable From Parent";
	protected static String staticVariable = "Static Variable From Parent";

	public static void doStaticMathod() {
		System.out.println("Static Method From Parent");
	}
}
