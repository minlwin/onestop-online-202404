package com.jdc.spring.mvc.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdc.spring.mvc.model.ShoppingCart;
import com.jdc.spring.mvc.model.entity.Invoice;
import com.jdc.spring.mvc.model.entity.InvoiceItem;
import com.jdc.spring.mvc.model.entity.InvoiceItemPk;
import com.jdc.spring.mvc.model.repo.InvoiceItemRepo;
import com.jdc.spring.mvc.model.repo.InvoiceRepo;
import com.jdc.spring.mvc.model.repo.ProductRepo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("checkout")
public class CheckOutController {
	
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private InvoiceRepo invoiceRepo;
	@Autowired
	private InvoiceItemRepo itemRepo;

	@GetMapping
	String index(@SessionAttribute(required = false) ShoppingCart cart) {
		if(null == cart || cart.getTotalItems() == 0) {
			return "redirect:/product";
		}
		return "products/checkout";
	}
	
	@GetMapping("add/{id}")
	String addOne(@PathVariable int id, @SessionAttribute(required = false) ShoppingCart cart) {
		if(null == cart || cart.getTotalItems() == 0) {
			return "redirect:/product";
		}
		productRepo.findById(id).ifPresent(cart::addToCart);
		
		return "redirect:/checkout";
	}

	@GetMapping("remove/{id}")
	String removeOne(@PathVariable int id, @SessionAttribute(required = false) ShoppingCart cart) {
		if(null == cart || cart.getTotalItems() == 0) {
			return "redirect:/product";
		}
		cart.removeFromCart(id);
		
		return "redirect:/checkout";
	}
	
	@GetMapping("clear")
	String clearCart(HttpSession session) {
		if(null != session) {
			session.invalidate();
		}
		return "redirect:/product";
	}
	
	@PostMapping
	@Transactional
	String checkOut(HttpSession session, 
			@SessionAttribute(required = false) ShoppingCart cart, 
			RedirectAttributes redirectAttributes) {
		
		if(cart == null || cart.getTotalItems() == 0) {
			return "redirect:/product";
		}
		
		var items = cart.getItems();
		
		var invoice = new Invoice();
		invoice.setIssueAt(LocalDateTime.now());
		invoice.setTotalCount(cart.getTotalItems());
		invoice.setTotalAmount(cart.getTotalAmount());
		invoice = invoiceRepo.save(invoice);
		
		for(var cartItem : items) {
			var item = new InvoiceItem();
			var itemId = new InvoiceItemPk();
			itemId.setInvoiceId(invoice.getId());
			itemId.setProductId(cartItem.getProduct().getId());
			
			item.setId(itemId);
			item.setPrice(cartItem.getProduct().getPrice());
			item.setQuantity(cartItem.getQuantity());
			
			itemRepo.save(item);
		}
		
		redirectAttributes.addFlashAttribute("message", "Your order has been approved with id %s.".formatted(invoice.getId()));
		
		return "redirect:/invoice";
	}

}
