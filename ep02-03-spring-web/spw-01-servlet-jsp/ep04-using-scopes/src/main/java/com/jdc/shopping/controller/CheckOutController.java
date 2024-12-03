package com.jdc.shopping.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import com.jdc.shopping.model.Sale;
import com.jdc.shopping.model.SaleModel;
import com.jdc.shopping.model.ShoppingCart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
		"/checkout",
		"/checkout/plus",
		"/checkout/minus",
}, loadOnStartup = 1)
public class CheckOutController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private SaleModel saleModel;
	
	@Override
	public void init() throws ServletException {
		saleModel = (SaleModel) getServletContext().getAttribute("saleModel");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var productId = req.getParameter("productId");
		
		var session = req.getSession(true);
		var cart = (ShoppingCart)session.getAttribute("cart");
		
		if(null == cart) {
			resp.sendRedirect(getServletContext().getContextPath().concat("/products"));
			return;
		}
		
		switch(req.getServletPath()) {
		case "/checkout" -> {
			getServletContext().getRequestDispatcher("/checkout.jsp")
				.forward(req, resp);
		}
		case "/checkout/plus" -> {
			cart.plus(Integer.parseInt(productId));
			resp.sendRedirect(getServletContext().getContextPath().concat("/checkout"));
		}
		case "/checkout/minus" -> {
			cart.minus(Integer.parseInt(productId));
			
			if(cart.getItemCount() == 0) {
				resp.sendRedirect(getServletContext().getContextPath().concat("/products"));
			} else {
				resp.sendRedirect(getServletContext().getContextPath().concat("/checkout"));
			}
		}
		default -> throw new IllegalArgumentException();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var session = req.getSession(true);
		var cart = (ShoppingCart)session.getAttribute("cart");
		
		if(null == cart) {
			resp.sendRedirect(getServletContext().getContextPath().concat("/products"));
			return;
		}
		
		var sale = new Sale();
		sale.setItems(cart.getItems());
		sale.setCustomer(req.getParameter("name"));
		sale.setPhone(req.getParameter("phone"));
		sale.setEmail(req.getParameter("email"));
		sale.setSaleAt(LocalDateTime.now());
		
		var id = saleModel.addSale(sale);
		
		session.removeAttribute("cart");
		
		resp.sendRedirect(getServletContext().getContextPath().concat("/sales?id=%d".formatted(id)));
	}

}
