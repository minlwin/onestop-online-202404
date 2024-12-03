package com.jdc.shopping.controller;

import java.io.IOException;

import com.jdc.shopping.model.SaleModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/sales", loadOnStartup = 1)
public class SalesController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private SaleModel saleModel;
	
	@Override
	public void init() throws ServletException {
		saleModel = (SaleModel) getServletContext().getAttribute("saleModel");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var id = req.getParameter("id");
		
		if(null != id) {
			var sale = saleModel.findById(Integer.parseInt(id));
			req.setAttribute("sale", sale);
			getServletContext().getRequestDispatcher("/sale-details.jsp").forward(req, resp);
		} else {
			getServletContext().getRequestDispatcher("/sale-history.jsp").forward(req, resp);
		}
	}

}
