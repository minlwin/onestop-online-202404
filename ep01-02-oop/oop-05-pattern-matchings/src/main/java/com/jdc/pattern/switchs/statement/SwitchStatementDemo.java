package com.jdc.pattern.switchs.statement;

import com.jdc.pattern.switchs.Ractangle;
import com.jdc.pattern.switchs.Shape;
import com.jdc.pattern.switchs.Square;
import com.jdc.pattern.switchs.Triangle;

public class SwitchStatementDemo {

	public static void showAreaInstanceOfTypePattern(Shape shape) {
		
		if(shape instanceof Square s) {
			System.out.println(s.base() * s.base());
		} else if(shape instanceof Ractangle s) {
			System.out.println(s.base() * s.height());
		} else if(shape instanceof Triangle s) {
			System.out.println(s.base() * s.height() / 2);
		}
	}
	
	public static void showAreaInstanceOfRecordPattern(Shape shape) {
		
		if(shape instanceof Square (var b)) {
			System.out.println(b * b);
		} else if(shape instanceof Ractangle (var b, var h)) {
			System.out.println(b * h);
		} else if(shape instanceof Triangle(var b, var h)) {
			System.out.println(b * h / 2);
		}
	}	
	
	public static void showAreaSwitchTypePattern(Shape shape) {
		
		switch(shape) {
		case Square s -> System.out.println(s.base() * s.base());
		case Ractangle s -> System.out.println(s.base() * s.height());
		case Triangle s -> System.out.println(s.base() * s.height() / 2);
		default -> System.out.println("Invalid Shape");
		}		
	}
	
	public static void showAreaSwitchRecordPattern(Shape shape) {
		
		switch(shape) {
		case Square (var b) -> System.out.println(b * b);
		case Ractangle(var b, var h) -> System.out.println(b * h);
		case Triangle (var b, var h) -> System.out.println(b * h / 2);
		default -> System.out.println("Invalid Shape");
		}		
	}
}
