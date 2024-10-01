package com.jdc.spring.trx.service;

import com.jdc.spring.trx.BusinessException;
import com.jdc.spring.trx.dto.AmountUpdateForm;
import com.jdc.spring.trx.dto.BalanceHistoryForm;
import com.jdc.spring.trx.dto.TransferForm;
import com.jdc.spring.trx.repo.AccountRepo;
import com.jdc.spring.trx.repo.BalanceHistoryRepo;
import com.jdc.spring.trx.repo.TransferRepo;

public class TransferServiceImpl implements TransferService{

	private AccountRepo accountRepo;
	private BalanceHistoryRepo historyRepo;
	private TransferRepo transferRepo;
	
	@Override
	public int transfer(TransferForm form) {
		
		// Get Account From Information
		var fromAccount = accountRepo.findByAccountId(form.from())
				.orElseThrow(() -> new BusinessException("Invalid account number : %s".formatted(form.from())));
		
		// Check Amount to transfer
		if(fromAccount.amount() < form.amount()) {
			throw new BusinessException("%s has no enough amout to transfer.".formatted(form.from()));
		}
		
		// Initiate Transfer Transaction
		var trxId = transferRepo.initiate(form);
		
		// Create Account from balance history
		var fromHistory = new BalanceHistoryForm(fromAccount.accountNum(), fromAccount.version() + 1, fromAccount.amount(), trxId, false, form.amount(), form.remark());
		historyRepo.create(fromHistory);
		
		// Update Account from Amount
		var fromAmountForm = new AmountUpdateForm(fromAccount.accountNum(), form.amount(), fromAccount.version() + 1);
		accountRepo.updateAmount(fromAmountForm);
		
		// Get Account To Information
		var toAccount = accountRepo.findByAccountId(form.to())
				.orElseThrow(() -> new BusinessException("Invalid account number : %s".formatted(form.to())));
				
		
		// Create Account to Balance History
		var toHistory = new BalanceHistoryForm(toAccount.accountNum(), toAccount.version() + 1, toAccount.amount(), trxId, true, form.amount(), form.remark());
		historyRepo.create(toHistory);
		
		// Update Account to Amount
		var toAmountForm = new AmountUpdateForm(toAccount.accountNum(), form.amount(), toAccount.version() + 1);
		accountRepo.updateAmount(toAmountForm);
		
		// Update Transfer Transaction Status
		transferRepo.updateStatus(trxId, "Success");
		
		return trxId;
	}

}
