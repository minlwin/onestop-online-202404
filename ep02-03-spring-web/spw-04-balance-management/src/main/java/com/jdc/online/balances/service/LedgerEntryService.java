package com.jdc.online.balances.service;

import org.springframework.stereotype.Service;

import com.jdc.online.balances.controller.member.dto.LedgerEntryForm;
import com.jdc.online.balances.controller.member.dto.LedgerEntryListItem;
import com.jdc.online.balances.controller.member.dto.LedgerEntrySearch;
import com.jdc.online.balances.model.PageResult;
import com.jdc.online.balances.model.entity.consts.BalanceType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LedgerEntryService {
	
	public PageResult<LedgerEntryListItem> search(String username, BalanceType type, LedgerEntrySearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	public LedgerEntryForm findForEdit(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
