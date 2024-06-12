package com.jdc.abstraction.ddod;

public class MultipleInheritanceDemo {

}

interface A {
	void a();
	
	default void problem() {
		System.out.println("This is problem from A");
	}
}

interface B extends A{
	void b();

	default void problem() {
		System.out.println("This is problem from B");
	}
}

interface C extends A{
	void c();

	default void problem() {
		System.out.println("This is problem from C");
	}
}

interface D extends B, C {
	void d();
	
	default void problem() {
		C.super.problem();
	}
	
}
