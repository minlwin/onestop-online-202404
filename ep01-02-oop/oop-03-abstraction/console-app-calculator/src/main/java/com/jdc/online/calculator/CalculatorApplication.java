package com.jdc.online.calculator;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.ConsoleApplication;
import com.jdc.online.calculator.feature.FeatureForAdding;

public class CalculatorApplication {

	public static void main(String[] args) {
		
		var features = new AbstractFeature[] {
			new FeatureForAdding(1)
		};
		
		var application = new ConsoleApplication("Calculator", features);
		application.launch();
	}
}
