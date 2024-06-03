package com.jdc.online.calculator.feature;

public class FeatureForAdding extends AbstractCalculation {

	public FeatureForAdding(int id) {
		super(id, "Plus Calculation");
	}

	protected void calculateAndShowResult(int digit1, int digit2) {
		System.out.printf("%d + %d = %d%n", digit1, digit2, digit1 + digit2);
	}

}
