package com.jdc.online.location.api.dto;

import java.util.ArrayList;
import java.util.function.Function;

import org.springframework.util.StringUtils;

import com.jdc.online.location.model.entity.Region_;
import com.jdc.online.location.model.entity.State;
import com.jdc.online.location.model.entity.State_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;

public record StateSearch(
		Integer regionId, 
		String keyword) {

	public Function<CriteriaBuilder, CriteriaQuery<State>> queryFunc() {
		return cb -> {
			var cq = cb.createQuery(State.class);
			var root = cq.from(State.class);
			cq.select(root);
			
			var predicates = new ArrayList<Predicate>();
			
			var region = root.join(State_.region);
			
			if(null != regionId) {
				predicates.add(cb.equal(region.get(Region_.id), regionId));
			}
			
			if(StringUtils.hasLength(keyword)) {
				predicates.add(cb.or(
					cb.like(cb.lower(region.get(Region_.name)), keyword.toLowerCase().concat("%")),
					cb.like(cb.lower(root.get(State_.name)), keyword.toLowerCase().concat("%")),
					cb.like(cb.lower(root.get(State_.capital)), keyword.toLowerCase().concat("%"))
				));
			}
			
			cq.where(predicates.toArray(size -> new Predicate[size]));
			
			return cq;
		};
	}
}
