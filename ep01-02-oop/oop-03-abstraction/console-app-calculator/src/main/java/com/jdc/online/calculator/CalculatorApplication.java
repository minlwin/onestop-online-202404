package com.jdc.online.calculator;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.ConsoleApplication;
import com.jdc.online.calculator.feature.AbstractCalculation;
import com.jdc.online.calculator.feature.FeatureForAdding;
import com.jdc.online.calculator.feature.FeatureForDivision;
import com.jdc.online.calculator.feature.FeatureForMultiplication;
import com.jdc.online.calculator.feature.FeatureForSubstraction;

public class CalculatorApplication {

	public static void main(String[] args) {
		
		var features = new AbstractFeature[] {
			new FeatureForAdding(1),
			new FeatureForSubstraction(2),
			new FeatureForMultiplication(3),
			new FeatureForDivision(4),
			new AbstractCalculation(5, "Modulus Calculation") {
				
				@Override
				protected void calculateAndShowResult(int digit1, int digit2) {
					System.out.printf("%d %% %d = %d%n", digit1, digit2, digit1 % digit2);
				}
			}
		};
		
		var application = new ConsoleApplication("Calculator", features);
		application.launch();
	}
}
