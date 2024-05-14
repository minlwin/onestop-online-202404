package com.jdc.app;

import com.jdc.app.domain.*;
import static com.jdc.app.utils.MessageUtils.*;

public class Application {

	public static void main(String[] args) {

		Teacher t = new Teacher();
		t.sayHello();

		Student s = new Student();
		s.sayHello();

		Parent p = new Parent();
		p.sayHello();

		System.out.println(MESSAGE);

		sayHello();

		System.out.println("Hello My first Package");
	}
}