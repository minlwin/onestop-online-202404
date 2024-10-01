package com.jdc.spring.trx.repo;

import java.util.Optional;

import com.jdc.spring.trx.dto.AccountInfo;
import com.jdc.spring.trx.dto.AmountUpdateForm;

public class AccountRepoImpl implements AccountRepo {

	@Override
	public Optional<AccountInfo> findByAccountId(String accountNum) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void updateAmount(AmountUpdateForm fromAmountForm) {
		// TODO Auto-generated method stub
		
	}

}
