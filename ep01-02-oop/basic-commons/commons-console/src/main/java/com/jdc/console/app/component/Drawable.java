package com.jdc.console.app.component;

public interface Drawable {

	void draw();
	
	default void drawLine(int size) {
		for(var i = 0 ; i < size; i ++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
