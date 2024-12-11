package com.jdc.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.web.spring.service.CategoryService;
import com.jdc.web.spring.service.ProductService;
import com.jdc.web.spring.service.input.ProductForm;
import com.jdc.web.spring.service.input.ProductSearch;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
	"/products",
	"/products/edit",
	"/products/details",
	"/products/upload",
})
public class ProductController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private ProductService productService;
	private CategoryService categoryService;
	
	@Override
	public void init() throws ServletException {
		productService = getBean(ProductService.class);
		categoryService = getBean(CategoryService.class);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch (req.getServletPath()) {
		case "/products" -> search(req, resp);
		case "/products/edit" -> edit(req, resp);
		case "/products/details" -> details(req, resp);
		default -> throw new IllegalArgumentException();
		}

	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch (req.getServletPath()) {
		case "/products/edit" -> save(req, resp);
		case "/products/upload" -> upload(req, resp);
		default -> throw new IllegalArgumentException();
		}
	}

	private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var productId = req.getParameter("productId");
		var categoryId = req.getParameter("categoryId");
		var name = req.getParameter("name");
		var price = req.getParameter("price");
		var status = req.getParameter("status");
		
		var messages = new ArrayList<String>();
		
		if(!StringUtils.hasLength(categoryId)) {
			messages.add("Please select category.");
		}

		if(!StringUtils.hasLength(name)) {
			messages.add("Please enter product name.");
		}

		if(!StringUtils.hasLength(price)) {
			messages.add("Please enter price of product.");
		}
		
		if(!StringUtils.hasLength(status)) {
			messages.add("Please enter select status.");
		}

		if(!messages.isEmpty()) {
			req.setAttribute("errors", messages);
			getServletContext().getRequestDispatcher("/products/edit.jsp").forward(req, resp);
			return;
		}
		
		var form = new ProductForm();
		form.setName(name);
		form.setCategoryId(Integer.parseInt(categoryId));
		form.setPrice(Integer.parseInt(price));
		form.setDeleted(status.equals("Deleted"));
		
		var id = StringUtils.hasLength(productId) ? productService.update(Integer.parseInt(productId), form) : productService.create(form);
		
		resp.sendRedirect(req.getContextPath().concat("/products/details?id=%d".formatted(id)));
	}

	private void upload(HttpServletRequest req, HttpServletResponse resp) {
	}

	private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var search = new ProductSearch();
		search.setCreateFrom(req.getParameter("createFrom"));
		search.setCreateTo(req.getParameter("createTo"));
		search.setKeyword(req.getParameter("keyword"));
		
		var list = productService.search(search);
		req.setAttribute("list", list);
		
		getServletContext().getRequestDispatcher("/products/list.jsp").forward(req, resp);
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var productId = req.getParameter("id");
		
		var categoryId = req.getParameter("categoryId");
		
		if(!StringUtils.hasLength(categoryId)) {
			throw new IllegalArgumentException();
		}
		
		var category = categoryService.findById(Integer.parseInt(categoryId));
		req.setAttribute("category", category);
		
		if(StringUtils.hasLength(productId)) {
			var id = Integer.parseInt(productId);
			
			var product = productService.findById(id);
			req.setAttribute("product", product);
		}
		
		getServletContext().getRequestDispatcher("/products/edit.jsp").forward(req, resp);
	}
	
	private void details(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var productId = req.getParameter("id");
		var id = Integer.parseInt(productId);
		
		var product = productService.findById(id);
		req.setAttribute("product", product);
		
		getServletContext().getRequestDispatcher("/products/details.jsp").forward(req, resp);
	}
	
}
