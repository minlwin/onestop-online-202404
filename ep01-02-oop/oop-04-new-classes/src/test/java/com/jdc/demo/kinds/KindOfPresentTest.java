package com.jdc.demo.kinds;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.lang.annotation.Annotation;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.demo.kinds.model.Child;
import com.jdc.demo.kinds.model.Parent;

@TestMethodOrder(value = OrderAnnotation.class)
public class KindOfPresentTest {

	@Test
	@Order(1)
	void test_directly_present() {
		System.out.println("Directly Present");
		
		var annotations = Parent.class.getDeclaredAnnotations();
		
		for(var annotation : annotations) {
			System.out.println(annotation.annotationType());
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
	
	@Test
	@Order(2)
	void test_indirectly_present() {
		
		System.out.println("Indirectly Present");
		
		Single [] list1 = Parent.class.getDeclaredAnnotationsByType(Single.class);
		
		for(var annotation : list1) {
			System.out.println(annotation.annotationType());
			System.out.printf("Value : %d%n", annotation.value());
		}
		
		Singles[] list2 = Parent.class.getDeclaredAnnotationsByType(Singles.class);
		for(var annotation : list2) {
			System.out.println(annotation.annotationType());
		}
	}
	
	@Test
	@Order(3)
	void test_present() {
		
		System.out.println("Present");

		Annotation [] array = Child.class.getAnnotations();
		
		for(Annotation anno : array) {
			System.out.println(anno.annotationType());
		}
		
		// Present
		Singles singles = Child.class.getAnnotation(Singles.class);
		assertNotNull(singles);
		
		// Directly Present
		Other other = Child.class.getAnnotation(Other.class);
		assertNotNull(other);
	}

	@Test
	@Order(4)
	void test_associate() {
		
		System.out.println("Associate");
		
		// Associate 
		Single [] array1 = Child.class.getAnnotationsByType(Single.class);
		for(var anno : array1) {
			System.out.println(anno.annotationType());
		}
		
		// Present
		Singles [] array2 = Child.class.getAnnotationsByType(Singles.class);
		for(var anno : array2) {
			System.out.println(anno.annotationType());
		}
		
		// Indirectly Present
		Another [] array3 = Child.class.getAnnotationsByType(Another.class);
		for(var anno : array3) {
			System.out.println(anno.annotationType());
		}
		
		// Directly Present
		Other [] array4 = Child.class.getAnnotationsByType(Other.class);
		for(var anno : array4) {
			System.out.println(anno.annotationType());
		}
	}
}
