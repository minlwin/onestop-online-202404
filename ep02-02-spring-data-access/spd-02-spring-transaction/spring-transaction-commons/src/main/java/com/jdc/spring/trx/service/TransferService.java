package com.jdc.spring.trx.service;

import com.jdc.spring.trx.dto.TransferForm;

public interface TransferService {

	int transfer(TransferForm form);
}
