package com.jdc.web.spring.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.jdc.web.spring.entity.Sale;
import com.jdc.web.spring.entity.SaleItem;
import com.jdc.web.spring.entity.SaleItemPk;
import com.jdc.web.spring.repo.ProductRepo;
import com.jdc.web.spring.repo.SaleItemRepo;
import com.jdc.web.spring.repo.SaleRepo;
import com.jdc.web.spring.service.input.CheckOutForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CheckOutService {
	
	private final SaleRepo saleRepo;
	private final ProductRepo productRepo;
	private final SaleItemRepo saleItemRepo;
	
	public void checkOut(CheckOutForm form) {

		// Create Sale
		var sale = new Sale();
		sale.setCustomer(form.getCustomerName());
		sale.setPhone(form.getCustomerPhone());
		sale.setEmail(form.getEmail());
		sale.setSaleAt(LocalDateTime.now());
		
		sale = saleRepo.save(sale);
		
		// Create Sale Items
		for(var item : form.getItems()) {
			var id = new SaleItemPk();
			id.setProductId(item.getProductId());
			id.setSaleId(sale.getId());
			
			var saleItem = new SaleItem();
			saleItem.setId(id);
			
			saleItem.setSale(sale);
			saleItem.setProduct(productRepo.findById(item.getProductId()).orElseThrow());
			saleItem.setQuantity(item.getQuantity());
			saleItem.setSalePrice(item.getSalePrice());
			
			saleItemRepo.save(saleItem);
		}
	}

}
