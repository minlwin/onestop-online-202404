package com.jdc.web.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
		"/categories",
		"/categories/edit",
		"/categories/details"
})
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch (req.getServletPath()) {
		case "/categories/edit" -> edit(req, resp);
		case "/categories/details" -> showDetails(req, resp);
		default -> search(req, resp);
		}
		
	}

	private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", List.of(1, 2, 3, 4, 5, 6, 7));
		getServletContext().getRequestDispatcher("/categories/list.jsp").forward(req, resp);
	}
	
	private void showDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("products", List.of(1, 2, 3, 4, 5));
		
		getServletContext().getRequestDispatcher("/categories/details.jsp").forward(req, resp);
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/categories/edit.jsp").forward(req, resp);
	}
}
