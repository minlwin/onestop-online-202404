package com.jdc.online.balances.utils.patch;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.online.balances.model.entity.consts.BalanceType;
import com.jdc.online.balances.model.repo.LedgerEntryRepo;
import com.jdc.online.balances.model.repo.MemberRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Patch_20250417 {
	
	@Value("${app.patch.p20250417.run}")
	private boolean patchRun;
	
	private final MemberRepo memberRepo;
	private final LedgerEntryRepo entryRepo;

	@Transactional
	@EventListener(classes = ContextRefreshedEvent.class)
	public void execute() {
		
		if(patchRun) {
			// Get Members
			var members = memberRepo.findAll();
			
			// Calculate Balances
			for(var member : members) {
				var entries = entryRepo.findByIdMemberId(member.getId());
				
				entries = entries.stream()
						.sorted((a, b) -> {
							var result = a.getId().getIssueDate().compareTo(b.getId().getIssueDate());
							if(result == 0) {
								return a.getId().getSeqNumber() - b.getId().getSeqNumber();
							}
							return result;
						}).toList();
				
				var lastAmount = BigDecimal.ZERO;
				for(var entry : entries) {
					entry.setLastAmount(lastAmount);
					lastAmount = entry.getLedger().getType() == BalanceType.Incomes ? 
							lastAmount.add(entry.getAmount()) : lastAmount.subtract(entry.getAmount());
				}
				
				member.getActivity().setBalance(lastAmount);
			}
		}
	}
}
