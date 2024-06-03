package com.jdc.online.calculator.feature;

public class FeatureForDivision extends AbstractCalculation {

	public FeatureForDivision(int id) {
		super(id, "Divided Calculation");
	}

	@Override
	protected void calculateAndShowResult(int digit1, int digit2) {
		System.out.printf("%d / %d = %d%n", digit1, digit2, digit1 / digit2);
	}

}
