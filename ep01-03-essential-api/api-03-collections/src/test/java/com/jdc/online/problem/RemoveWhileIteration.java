package com.jdc.online.problem;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RemoveWhileIteration {

	@ParameterizedTest
	@MethodSource("test_data")
	void test_for_each(List<Integer> input, List<Integer> output) {
		
		for(Integer data : input) {
			if(data % 2 == 0) {
				input.remove(data);
			}
		}
		
		assertTrue(input.equals(output));
	}
	
	@ParameterizedTest
	@MethodSource("test_data")
	void test_for_index(List<Integer> input, List<Integer> output) {
		
		for(var i = 0; i < input.size(); i ++) {
			
			Integer data = input.get(i);
			
			if(data % 2 == 0) {
				input.remove(data);
			}
		}
		
		assertTrue(input.equals(output));
	}
	
	@ParameterizedTest
	@MethodSource("test_data")
	void test_while(List<Integer> input, List<Integer> output) {
		
		int index = 0;
		
		while(index < input.size()) {
			if(input.get(index ++) % 2 == 0) {
				input.remove(index);
			}
		}
		
		assertTrue(input.equals(output));
	}
	
	@ParameterizedTest
	@MethodSource("test_data")
	void test_iterator(List<Integer> input, List<Integer> output) {
		
		var iterator = input.iterator();
		
		while(iterator.hasNext()) {
			
			var data = iterator.next();
			
			if(data % 2 == 0) {
				iterator.remove();
			}
		}
		
		assertTrue(input.equals(output));
	}

	static Stream<Arguments> test_data() {
		return Stream.of(
			Arguments.of(
				new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 8)),
				new ArrayList<>(List.of(1, 3, 5, 7, 9))
			)
		);
	}
}
