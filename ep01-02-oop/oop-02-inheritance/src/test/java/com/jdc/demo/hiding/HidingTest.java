package com.jdc.demo.hiding;

import org.junit.jupiter.api.Test;

public class HidingTest {

	@Test
	void test_1() {
		var child = new ChildType();
		child.showFromChild();
		System.out.println("============");
		child.showFromChildForHidingMember();
	}
}
