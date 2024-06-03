package com.jdc.online.calculator.feature;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;

public abstract class AbstractCalculation extends AbstractFeature {

	public AbstractCalculation(int id, String name) {
		super(id, name);
	}
	
	@Override
	public void doBusiness() {
		
		// get digit one
		var digit1 = getDigitOne();
		
		// get digit two
		var digit2 = getDigitTwo();
		
		// show result
		calculateAndShowResult(digit1, digit2);
		
	}
	
	protected abstract void calculateAndShowResult(int digit1, int digit2);

	private int getDigitTwo() {
		return UserInputs.readInt("Digit 2 : ");
	}

	private int getDigitOne() {
		return UserInputs.readInt("Digit 1 : ");
	}
}
