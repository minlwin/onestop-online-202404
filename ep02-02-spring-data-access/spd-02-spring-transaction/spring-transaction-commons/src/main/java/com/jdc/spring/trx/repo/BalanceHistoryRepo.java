package com.jdc.spring.trx.repo;

import com.jdc.spring.trx.dto.BalanceHistoryForm;

public interface BalanceHistoryRepo {

	void create(BalanceHistoryForm history);

}
