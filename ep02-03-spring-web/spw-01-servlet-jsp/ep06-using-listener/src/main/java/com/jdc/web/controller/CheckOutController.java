package com.jdc.web.controller;

import java.io.IOException;

import com.jdc.web.spring.service.CheckOutService;
import com.jdc.web.spring.service.input.CheckOutForm;
import com.jdc.web.spring.service.output.ShoppingCart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
		"/checkout",
		"/checkout/add",
		"/checkout/remove"
})
public class CheckOutController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private CheckOutService service;
	
	@Override
	public void init() throws ServletException {
		this.service = getBean(CheckOutService.class);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var session = req.getSession(true);
		var cart = (ShoppingCart)session.getAttribute("cart");
		var productId = req.getParameter("productId");
		
		if(req.getServletPath().endsWith("add")) {
			cart.addOne(Integer.parseInt(productId));
		} else if (req.getServletPath().endsWith("remove")) {
			cart.removeOne(Integer.parseInt(productId));
			
			if(cart.getTotalItems() == 0) {
				resp.sendRedirect(getServletContext().getContextPath());
				return;
			}
		}
		
		getServletContext().getRequestDispatcher("/checkout/view.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var session = req.getSession(true);
		var cart = (ShoppingCart)session.getAttribute("cart");
		
		if(null != cart && cart.getTotalItems() > 0) {
			var form = new CheckOutForm();
			
			form.setCustomerName(req.getParameter("name"));
			form.setCustomerPhone(req.getParameter("phone"));
			form.setEmail(req.getParameter("email"));
			
			form.setItems(cart.getItems());
			service.checkOut(form);
		}
		
		session.invalidate();
		
		resp.sendRedirect(getServletContext().getContextPath().concat("/sales"));
	}

}
