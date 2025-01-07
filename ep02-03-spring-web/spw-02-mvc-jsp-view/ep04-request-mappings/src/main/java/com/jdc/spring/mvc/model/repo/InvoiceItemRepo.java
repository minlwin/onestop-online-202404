package com.jdc.spring.mvc.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.spring.mvc.model.entity.InvoiceItem;
import com.jdc.spring.mvc.model.entity.InvoiceItemPk;

public interface InvoiceItemRepo extends JpaRepository<InvoiceItem, InvoiceItemPk>{

}
