package com.jdc.demo.sealeds.cards;

public enum TarotCard implements Card{

	TarotA(1), TarotB(2);
	
	private int value;

	private TarotCard(int value) {
		this.value = value;
	}
	
	@Override
	public int value() {
		return this.value;
	}
}
