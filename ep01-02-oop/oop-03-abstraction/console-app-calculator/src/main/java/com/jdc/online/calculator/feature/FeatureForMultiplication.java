package com.jdc.online.calculator.feature;

public class FeatureForMultiplication extends AbstractCalculation {

	public FeatureForMultiplication(int id) {
		super(id, "Multiply Calculation");
	}

	@Override
	protected void calculateAndShowResult(int digit1, int digit2) {
		System.out.printf("%d * %d = %d%n", digit1, digit2, digit1 * digit2);
	}

}
