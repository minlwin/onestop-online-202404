package com.jdc.web.spring.service.output;

import java.time.LocalDateTime;

import com.jdc.web.spring.entity.Sale;
import com.jdc.web.spring.entity.SaleItem_;
import com.jdc.web.spring.entity.Sale_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record SaleInfo(
		int id,
		String customer,
		String phone,
		String email,
		LocalDateTime saleAt,
		int items,
		int saleTotal) {

	public static void select(CriteriaBuilder cb, CriteriaQuery<SaleInfo> cq, Root<Sale> root) {
		
		var saleItems = root.join(Sale_.items);
		
		cq.multiselect(
			root.get(Sale_.id),
			root.get(Sale_.customer),
			root.get(Sale_.phone),
			root.get(Sale_.email),
			root.get(Sale_.saleAt),
			cb.sum(saleItems.get(SaleItem_.quantity)),
			cb.sum(cb.prod(saleItems.get(SaleItem_.quantity), saleItems.get(SaleItem_.salePrice)))
		);
		
		cq.groupBy(
			root.get(Sale_.id),
			root.get(Sale_.customer),
			root.get(Sale_.phone),
			root.get(Sale_.email),
			root.get(Sale_.saleAt)
		);
	}
}
