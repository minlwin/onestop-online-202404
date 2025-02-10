package com.jdc.spring.controller.dto.output;

import java.time.LocalDateTime;

import com.jdc.spring.model.entity.Account;
import com.jdc.spring.model.entity.Account_;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record AccountInfo(
		int id,
		String name, 
		String email,
		boolean disabled,
		LocalDateTime createdAt,
		LocalDateTime modifiedAt
		) {

	public static void select(CriteriaQuery<AccountInfo> cq, Root<Account> root) {
		cq.multiselect(
			root.get(Account_.id),
			root.get(Account_.name),
			root.get(Account_.email),
			root.get(Account_.disabled),
			root.get(Account_.createdAt),
			root.get(Account_.modifiedAt)
		);
	}
}
