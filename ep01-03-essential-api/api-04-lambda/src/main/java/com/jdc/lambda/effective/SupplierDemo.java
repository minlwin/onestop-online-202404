package com.jdc.lambda.effective;

import java.util.Optional;

public class SupplierDemo {

	public static void main(String[] args) {
		printLegth(Optional.ofNullable(null));
	}
	
	public static void printLegth(Optional<String> str) {
		System.out.println(str.orElseGet(() -> "Default Value"));
	}
}
