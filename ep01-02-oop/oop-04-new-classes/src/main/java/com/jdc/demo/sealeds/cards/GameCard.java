package com.jdc.demo.sealeds.cards;

public enum GameCard implements Card {

	CardA(1), CardB(2);

	private int value;

	private GameCard(int value) {
		this.value = value;
	}

	@Override
	public int value() {
		return this.value;
	}

}
