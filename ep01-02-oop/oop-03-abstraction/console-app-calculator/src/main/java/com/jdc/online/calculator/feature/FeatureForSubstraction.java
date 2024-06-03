package com.jdc.online.calculator.feature;

public class FeatureForSubstraction extends AbstractCalculation {

	public FeatureForSubstraction(int id) {
		super(id, "Substract Calculation");
	}

	@Override
	protected void calculateAndShowResult(int digit1, int digit2) {
		System.out.printf("%d - %d = %d%n", digit1, digit2, digit1 - digit2);
	}

}
