package com.jdc.pattern.switchs.statement;

public class LabelDominanceDemo {

	public static void test(Integer number) {
		switch (number) {
		case Integer i when i < 0 -> System.out.println("Integer");
		case 0 -> System.out.println("Zero");
		case Integer i -> System.out.println("Integer");
		}
	}
}
