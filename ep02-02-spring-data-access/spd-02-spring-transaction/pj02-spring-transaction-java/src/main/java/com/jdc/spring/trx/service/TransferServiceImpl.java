package com.jdc.spring.trx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.trx.BusinessException;
import com.jdc.spring.trx.dto.AmountUpdateForm;
import com.jdc.spring.trx.dto.BalanceHistoryForm;
import com.jdc.spring.trx.dto.TransferForm;
import com.jdc.spring.trx.repo.AccountRepo;
import com.jdc.spring.trx.repo.BalanceHistoryRepo;
import com.jdc.spring.trx.repo.TransferRepo;

@Service
public class TransferServiceImpl implements TransferService{

	@Autowired
	private AccountRepo accountRepo;
	@Autowired
	private BalanceHistoryRepo historyRepo;
	@Autowired
	private TransferRepo transferRepo;
	
	@Override
	@Transactional
	public int transfer(TransferForm form) {
		
		// Get Account From Information
		var fromAccount = accountRepo.findByAccountId(form.accountFrom())
				.orElseThrow(() -> new BusinessException("Invalid account number : %s".formatted(form.accountFrom())));
		
		// Check Amount to transfer
		if(fromAccount.amount() < form.amount()) {
			throw new BusinessException("%s has no enough amout to transfer.".formatted(form.accountFrom()));
		}
		
		// Initiate Transfer Transaction
		var trxId = transferRepo.initiate(form);
		
		// Create Account from balance history
		var fromHistory = BalanceHistoryForm.builder()
				.accountNum(fromAccount.accountNum())
				.nextVersion(fromAccount.nextVersion())
				.trxId(trxId)
				.trxAmount(form.amount())
				.isDebit(true)
				.lastAmount(fromAccount.amount())
				.remark(form.remark())
				.build();
		historyRepo.create(fromHistory);
		
		// Update Account from Amount
		var fromAccountUpdateForm = AmountUpdateForm.builder()
				.accountNum(fromAccount.accountNum())
				.nextVersion(fromAccount.nextVersion())
				.updatedAmount(fromAccount.amount() - form.amount())
				.build();
		accountRepo.updateAmount(fromAccountUpdateForm);
		
		// Get Account To Information
		var toAccount = accountRepo.findByAccountId(form.accountTo())
				.orElseThrow(() -> new BusinessException("Invalid account number : %s".formatted(form.accountTo())));
				
		
		// Create Account to Balance History
		var toHistory = BalanceHistoryForm.builder()
				.accountNum(toAccount.accountNum())
				.nextVersion(toAccount.nextVersion())
				.trxId(trxId)
				.trxAmount(form.amount())
				.isDebit(false)
				.lastAmount(toAccount.amount())
				.remark(form.remark())
				.build();
		historyRepo.create(toHistory);
		
//		System.out.printf("%d", 1 / 0);
		
		// Update Account to Amount
		var toAccountUpdateForm = AmountUpdateForm.builder()
				.accountNum(toAccount.accountNum())
				.nextVersion(toAccount.nextVersion())
				.updatedAmount(toAccount.amount() + form.amount())
				.build();
		
		accountRepo.updateAmount(toAccountUpdateForm);
		
		// Update Transfer Transaction Status
		transferRepo.updateStatus(trxId, "Success");
		
		return trxId;
	}

}
