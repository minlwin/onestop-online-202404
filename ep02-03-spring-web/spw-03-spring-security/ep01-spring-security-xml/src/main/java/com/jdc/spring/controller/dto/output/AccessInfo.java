package com.jdc.spring.controller.dto.output;

import java.time.LocalDateTime;
import java.util.UUID;

import com.jdc.spring.model.entity.AccessHistory;
import com.jdc.spring.model.entity.AccessHistory.Status;
import com.jdc.spring.model.entity.AccessHistory.Type;
import com.jdc.spring.model.entity.AccessHistory_;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record AccessInfo(
		UUID id,
		String username,
		Type action,
		Status status,
		LocalDateTime accessAt,
		String remark) {

	public static void select(CriteriaQuery<AccessInfo> cq, Root<AccessHistory> root) {
       cq.multiselect(
           root.get(AccessHistory_.id),
           root.get(AccessHistory_.username),
           root.get(AccessHistory_.type),
           root.get(AccessHistory_.status),
           root.get(AccessHistory_.accessAt),
           root.get(AccessHistory_.remark)
       );
   }
}
