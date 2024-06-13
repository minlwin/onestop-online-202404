package com.jdc.demo.constants;

public class StatusChecker {

	public static void check(int status) {
		switch (status) {
		case TransactionStatus.PENDING:
			System.out.println("Pending Transaction");
			break;
		case TransactionStatus.APPROVED: 
			System.out.println("Approved Transaction");
			break;
		case TransactionStatus.CANCELED:
			System.out.println("Canceled Transaction");
			break;
		default:
			System.out.println("Invalid Transaction");
			break;
		}
		
		System.out.println(status);
	}
	
	public static void checkEnum(TransactionState status) {
		switch (status) {
		case APPLIED:
			System.out.println("Applied Transaction");
			break;
		case APPROVED:
			System.out.println("Approved Transaction");
			break;
		case CANCELED:
			System.out.println("Canceled Transaction");
			break;
		}
		
		System.out.println(status);
	}
}
