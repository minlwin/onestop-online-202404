package com.jdc.demo.kinds;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.jdc.demo.kinds.model.Parent;

public class KindOfPresentTest {

	@Test
	void test_directly_present() {
		System.out.println("Directly Present");
		var annotations = Parent.class.getDeclaredAnnotations();
		
		for(var annotation : annotations) {
			System.out.println(annotation.annotationType().getName());
		}
		
		var singles = Parent.class.getDeclaredAnnotation(Singles.class);
		assertNotNull(singles);
		
		var singlesValues = singles.value();
		
		for(var single : singlesValues) {
			System.out.println(single.value());
		}
		
		var single = Parent.class.getDeclaredAnnotation(Single.class);
		assertNull(single);
	}

}
