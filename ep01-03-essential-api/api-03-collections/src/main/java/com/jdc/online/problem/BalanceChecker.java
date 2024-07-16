package com.jdc.online.problem;

import java.util.ArrayDeque;
import java.util.Collections;

public class BalanceChecker {

	public boolean isBalance(String value) {

		if(null == value || value.isBlank()) {
			throw new IllegalArgumentException();
		}
		
		var chars = value.toCharArray();
		var stack = Collections.asLifoQueue(new ArrayDeque<Character>());
		
		for(var current : chars) {
			switch(current) {
			case '(', '[', '{' -> stack.offer(current);
			case ')', ']', '}' -> {
				var last = stack.poll();
				if(null == last || !isMatch(last, current)) {
					return false;
				}
			}
			default -> throw new IllegalArgumentException();
			}
		}
		
		return stack.isEmpty();
	}

	private boolean isMatch(Character last, char current) {
		return (last == '(' && current == ')')
				|| (last == '[' && current == ']')
				|| (last == '{' && current == '}');
	}

}
