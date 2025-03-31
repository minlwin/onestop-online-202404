package com.jdc.online.balances.controller.member.dto;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.online.balances.model.entity.Account_;
import com.jdc.online.balances.model.entity.Ledger;
import com.jdc.online.balances.model.entity.Ledger_;
import com.jdc.online.balances.model.entity.Member_;
import com.jdc.online.balances.model.entity.consts.BalanceType;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Data
public class LedgerSearch {

	private BalanceType type;
	private String keyword;
	
	public Predicate[] where(String username, CriteriaBuilder cb, Root<Ledger> root) {
		
		var params = new ArrayList<Predicate>();
		
		// root.member.account.username = :username
		params.add(cb.equal(root.get(Ledger_.member)
				.get(Member_.account)
				.get(Account_.username), username));
		
		if(null != type) {
			params.add(cb.equal(root.get(Ledger_.type), type));
		}
		
		if(StringUtils.hasLength(keyword)) {
			params.add(cb.like(cb.lower(root.get(Ledger_.name)), 
					keyword.toLowerCase().concat("%")));
		}
		
		return params.toArray(size -> new Predicate[size]);
	}
}
