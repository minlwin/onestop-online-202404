package com.jdc.web.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.util.StringUtils;

import com.jdc.web.spring.service.SaleService;
import com.jdc.web.spring.service.input.SaleSearch;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/sales")
public class SaleController extends AbstractController{

	private static final long serialVersionUID = 1L;

	private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	private SaleService service;
	
	@Override
	public void init() throws ServletException {
		this.service = getBean(SaleService.class);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var search = new SaleSearch();
		
		var dateFrom = req.getParameter("dateFrom");
		
		if(StringUtils.hasLength(dateFrom)) {
			search.setDateFrom(LocalDate.parse(dateFrom, DF));
		}
		
		var dateTo = req.getParameter("dateTo");
		
		if(StringUtils.hasLength(dateTo)) {
			search.setDateTo(LocalDate.parse(dateTo, DF));
		}
		
		search.setCustomer(req.getParameter("customer"));
		
		req.setAttribute("list", service.search(search));

		getServletContext().getRequestDispatcher("/sales/list.jsp").forward(req, resp);
	}
}
