package com.jdc.web.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/categories")
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("list", search(req));
		
		getServletContext().getRequestDispatcher("/categories/list.jsp").forward(req, resp);
	}

	private List<?> search(HttpServletRequest req) {
		return List.of(1, 2, 3, 4, 5, 6, 7);
	}

}
