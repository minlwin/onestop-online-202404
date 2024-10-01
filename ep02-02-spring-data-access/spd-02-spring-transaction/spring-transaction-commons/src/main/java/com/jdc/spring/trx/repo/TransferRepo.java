package com.jdc.spring.trx.repo;

import com.jdc.spring.trx.dto.TransferForm;

public interface TransferRepo {

	int initiate(TransferForm form);

	void updateStatus(int trxId, String string);

}
