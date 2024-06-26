package com.jdc.pattern.switchs.expression;

import com.jdc.pattern.switchs.Ractangle;
import com.jdc.pattern.switchs.Shape;
import com.jdc.pattern.switchs.Square;
import com.jdc.pattern.switchs.Triangle;

public class SwitchExpressionDemo {

	public static double getAreaTypePattern(Shape shape) {
		return switch(shape) {
		case Square s -> s.base() * s.base();
		case Ractangle s -> s.base() * s.height();
		case Triangle s -> s.base() * s.height() / 2;
		default -> throw new IllegalArgumentException();
		};
	}
	
	public static double getAreaRecordPattern(Shape shape) {
		return switch(shape) {
		case Square (var b) -> b * b;
		case Ractangle (var b, var h) -> b * h;
		case Triangle (var b, var h) -> b * h / 2;
		default -> throw new IllegalArgumentException();
		};
	}	
}
