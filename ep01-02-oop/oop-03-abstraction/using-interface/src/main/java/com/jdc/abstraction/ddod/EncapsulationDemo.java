package com.jdc.abstraction.ddod;

import com.jdc.abstraction.demo.Flyable;
import com.jdc.abstraction.demo.birds.Eagle;

public class EncapsulationDemo {
	
	public static void main(String[] args) {
		var eagle = new Eagle();
		fly(eagle);
	}

	static void fly(Flyable flyable) {
		flyable.fly();
	}
}
