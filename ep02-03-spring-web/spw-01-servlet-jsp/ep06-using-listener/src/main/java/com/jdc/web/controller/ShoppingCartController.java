package com.jdc.web.controller;

import java.io.IOException;

import org.springframework.util.StringUtils;

import com.jdc.web.spring.repo.ProductRepo;
import com.jdc.web.spring.service.output.ShoppingCart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cart")
public class ShoppingCartController extends AbstractController{

	private static final long serialVersionUID = 1L;
	
	private ProductRepo productRepo;
	
	@Override
	public void init() throws ServletException {
		this.productRepo = getBean(ProductRepo.class);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var productId = req.getParameter("productId");
		
		if(StringUtils.hasLength(productId)) {
			var id = Integer.parseInt(productId);
			productRepo.findById(id).ifPresent(product -> {
				
				var session = req.getSession(true);
				var cart = (ShoppingCart)session.getAttribute("cart");
				
				if(null == cart) {
					cart = new ShoppingCart();
					session.setAttribute("cart", cart);
				}
				
				cart.add(product);
			});
		}
		
		getServletContext().getRequestDispatcher("/home").forward(req, resp);
	}

}
