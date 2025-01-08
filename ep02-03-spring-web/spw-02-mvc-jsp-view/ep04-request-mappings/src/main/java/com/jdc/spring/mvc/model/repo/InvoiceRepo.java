package com.jdc.spring.mvc.model.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.spring.mvc.controller.output.InvoiceInfo;
import com.jdc.spring.mvc.model.entity.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice, UUID>{

	@Query("select new com.jdc.spring.mvc.controller.output.InvoiceInfo(i.id, i.issueAt, i.totalCount, i.totalAmount) from Invoice i")
	List<InvoiceInfo> searchAll();
}
