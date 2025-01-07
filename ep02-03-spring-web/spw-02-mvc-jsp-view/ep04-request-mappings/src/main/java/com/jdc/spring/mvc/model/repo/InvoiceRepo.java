package com.jdc.spring.mvc.model.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.spring.mvc.model.entity.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice, UUID>{

}
