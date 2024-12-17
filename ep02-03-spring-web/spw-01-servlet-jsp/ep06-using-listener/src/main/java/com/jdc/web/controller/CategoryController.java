package com.jdc.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.web.spring.service.CategoryService;
import com.jdc.web.spring.service.ProductService;
import com.jdc.web.spring.service.input.CategoryForm;
import com.jdc.web.spring.service.input.CategorySearch;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
		"/categories",
		"/categories/edit",
		"/categories/details"
})
public class CategoryController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private CategoryService categoryService;
	private ProductService productService;
	
	@Override
	public void init() throws ServletException {
		this.categoryService = getBean(CategoryService.class);
		this.productService = getBean(ProductService.class);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch (req.getServletPath()) {
		case "/categories/edit" -> edit(req, resp);
		case "/categories/details" -> showDetails(req, resp);
		default -> search(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Get Request Parameters
		var categoryId = req.getParameter("id");
		var name = req.getParameter("name");
		var status = req.getParameter("status");
		
		// Validate Parameters
		var messages = new ArrayList<String>();
		
		if(null == name || name.isBlank()) {
			messages.add("Please enter category name.");
		}
		
		if(null == status || status.isBlank()) {
			messages.add("Please select status.");
		}
		
		if(!messages.isEmpty()) {
			req.setAttribute("errors", messages);
			getServletContext().getRequestDispatcher("/categories/edit.jsp").forward(req, resp);
			return;
		}
		
		var form = new CategoryForm();
		form.setName(name);
		form.setDeleted(status);
		
		var result = (StringUtils.hasLength(categoryId)) ? categoryService.update(Integer.parseInt(categoryId), form)
				: categoryService.create(form);
		
		resp.sendRedirect(getServletContext().getContextPath().concat("/categories/details?id=%d".formatted(result)));
	}

	private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var search = new CategorySearch();
		search.setDeleted(req.getParameter("status"));
		search.setCreatedFrom(req.getParameter("createdFrom"));
		search.setCreatedTo(req.getParameter("createdTo"));
		search.setKeyword(req.getParameter("keyword"));
		
		req.setAttribute("list", categoryService.search(search));
		
		getServletContext().getRequestDispatcher("/categories/list.jsp").forward(req, resp);
	}
	
	private void showDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var categoryId = req.getParameter("categoryId");
		var id = Integer.parseInt(categoryId);
		
		req.setAttribute("category", categoryService.findById(id));
		req.setAttribute("products", productService.findByCategory(id));
		
		getServletContext().getRequestDispatcher("/categories/details.jsp").forward(req, resp);
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var categoryId = req.getParameter("id");
		
		if(StringUtils.hasLength(categoryId)) {
			var id = Integer.parseInt(categoryId);
			req.setAttribute("category", categoryService.findById(id));
		}
		
		getServletContext().getRequestDispatcher("/categories/edit.jsp").forward(req, resp);
	}
}
