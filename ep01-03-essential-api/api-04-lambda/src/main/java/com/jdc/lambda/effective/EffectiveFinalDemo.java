package com.jdc.lambda.effective;

import java.util.ArrayList;
import java.util.List;

public class EffectiveFinalDemo {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		Runnable runnable = () -> {
			list.forEach(data -> System.out.println(data));
			list.forEach(System.out::println);
		};
		
		runnable.run();
	}
}
