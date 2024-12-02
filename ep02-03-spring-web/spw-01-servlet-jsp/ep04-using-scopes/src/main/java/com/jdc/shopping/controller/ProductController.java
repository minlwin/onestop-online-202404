package com.jdc.shopping.controller;

import java.io.IOException;

import com.jdc.shopping.model.ProductModel;
import com.jdc.shopping.model.ShoppingCart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
	"/products",
	"/products/add"
})
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ProductModel productModel;
	
	@Override
	public void init() throws ServletException {
		productModel = (ProductModel) getServletContext().getAttribute("productModel");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getServletPath().endsWith("/products/add")) {
			var productId = req.getParameter("productId");
			if(null != productId && !productId.isBlank()) {
				var id = Integer.parseInt(productId);
				
				var product = productModel.findById(id);
				
				if(null != product) {
					
					var session = req.getSession(true);
					
					var cart = (ShoppingCart)session.getAttribute("cart");
					
					if(null == cart) {
						cart = new ShoppingCart();
						session.setAttribute("cart", cart);
					}
					
					cart.addToCart(product);
				}
			}
		}
		
		
		getServletContext().getRequestDispatcher("/index.jsp")
			.forward(req, resp);
	}

}
