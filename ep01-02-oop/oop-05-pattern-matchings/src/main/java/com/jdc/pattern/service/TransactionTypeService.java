package com.jdc.pattern.service;

import com.jdc.pattern.domain.TransactionType;
import com.jdc.pattern.domain.TransactionTypeForCashOut;
import com.jdc.pattern.domain.TransactionTypeForTransfer;

public class TransactionTypeService {

	public void show(TransactionType type) {
		System.out.println("Transaction Type Information");
		
		System.out.printf("%-16s : %s%n", "Type Name", type.name());
		
		if(type instanceof TransactionTypeForCashOut (var name, var consumer, var agent)) {
			System.out.printf("%-16s : %s%n", "Agent Name", agent);
			System.out.printf("%-16s : %s%n", "Consumer Name", consumer);
		}

		if(type instanceof TransactionTypeForTransfer (var name, var from, var to)) {
			System.out.printf("%-16s : %s%n", "From", from);
			System.out.printf("%-16s : %s%n", "To", to);
		}
	}
}
