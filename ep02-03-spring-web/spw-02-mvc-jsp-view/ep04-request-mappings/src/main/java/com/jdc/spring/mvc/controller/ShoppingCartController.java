package com.jdc.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jdc.spring.mvc.model.ShoppingCart;
import com.jdc.spring.mvc.model.repo.ProductRepo;

@Controller
@RequestMapping("cart")
@SessionAttributes("cart")
public class ShoppingCartController {
	
	@Autowired
	private ProductRepo productRepo;
	
	@GetMapping("add/{id}")
	String addToCart(@PathVariable int id, @ModelAttribute("cart") ShoppingCart shoppingCart) {
		
		productRepo.findById(id).ifPresent(product -> {
			shoppingCart.addToCart(product);
		});
		
		return "redirect:/product";
	}

	@ModelAttribute("cart")
	ShoppingCart shoppingCart() {
		return new ShoppingCart();
	}
}
