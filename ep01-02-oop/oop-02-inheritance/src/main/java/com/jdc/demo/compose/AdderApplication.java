package com.jdc.demo.compose;

public class AdderApplication {
	
	// AdderApplication HAS A Calculator
	private Calculator calc;
	
	public AdderApplication(Calculator calc) {
		super();
		this.calc = calc;
	}

	public void add(int a, int b) {
		var result = calc.add(a, b);
		System.out.printf("%s + %s = %s%n", a, b, result);
	}
}
