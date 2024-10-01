package com.jdc.spring.trx.repo;

import java.util.Optional;

import com.jdc.spring.trx.dto.AccountInfo;
import com.jdc.spring.trx.dto.AmountUpdateForm;

public interface AccountRepo {

	Optional<AccountInfo> findByAccountId(String accountNum);

	void updateAmount(AmountUpdateForm fromAmountForm);

}
