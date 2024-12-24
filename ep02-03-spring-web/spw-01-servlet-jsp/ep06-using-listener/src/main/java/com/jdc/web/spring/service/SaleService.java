package com.jdc.web.spring.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.web.spring.entity.Sale;
import com.jdc.web.spring.entity.Sale_;
import com.jdc.web.spring.repo.SaleRepo;
import com.jdc.web.spring.service.input.SaleSearch;
import com.jdc.web.spring.service.output.SaleInfo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleService {
	
	private final SaleRepo repo;
	
	@Transactional(readOnly = true)
	public List<SaleInfo> search(SaleSearch search) {
		return repo.search(queryFunc(search));
	}

	private Function<CriteriaBuilder, CriteriaQuery<SaleInfo>> queryFunc(SaleSearch search) {
		return cb -> {
			var cq = cb.createQuery(SaleInfo.class);
			var root = cq.from(Sale.class);
			
			SaleInfo.select(cb, cq, root);
			cq.where(search.where(cb, root));
			
			cq.orderBy(cb.desc(root.get(Sale_.saleAt)));
			
			return cq;
		};
	}

}
