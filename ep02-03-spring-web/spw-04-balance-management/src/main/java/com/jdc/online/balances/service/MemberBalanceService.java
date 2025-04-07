package com.jdc.online.balances.service;

import static com.jdc.online.balances.utils.EntityOperations.safeCall;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.online.balances.controller.member.dto.LedgerEntryDetails;
import com.jdc.online.balances.model.entity.embeddables.LedgerEntryPk;
import com.jdc.online.balances.model.repo.LedgerEntryRepo;
import com.jdc.online.balances.model.repo.MemberRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberBalanceService {
	
	private final MemberRepo memberRepo;
	private final LedgerEntryRepo entryRepo;
	
	public LedgerEntryDetails findById(String id) {
		
		var username = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		var member = memberRepo.findOneByAccountUsername(username).get();
		
		var entryId = LedgerEntryPk.parse(member.getId(), id);
		
		return safeCall(entryRepo.findById(entryId)
				.map(LedgerEntryDetails::from), "Ledger Entry", "id", id);
	}

}
