package com.jdc.web.controller;

import java.io.IOException;

import org.springframework.util.StringUtils;

import com.jdc.web.spring.service.CategoryService;
import com.jdc.web.spring.service.ProductService;
import com.jdc.web.spring.service.input.CategorySearch;
import com.jdc.web.spring.service.input.ProductSearch;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/home")
public class HomeController extends AbstractController {

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
		
		var categories = categoryService.search(new CategorySearch()).stream()
				.filter(a -> !a.isDeleted())
				.filter(a -> a.getProducts().intValue() > 0)
				.toList();
		
		Integer categoryId = null;
		
		if(categories.size() > 0) {
			categoryId = categories.get(0).getId();
		}
		
		var requestCategoryId = req.getParameter("categoryId");
		
		if(StringUtils.hasLength(requestCategoryId)) {
			categoryId = Integer.parseInt(requestCategoryId);
		}
		
		var search = new ProductSearch();
		
		if(null != categoryId) {
			search.setCategoryId(categoryId);
		}
		
		var products = productService.search(search);
		
		req.setAttribute("categoryId", categoryId);
		req.setAttribute("categories", categories);
		req.setAttribute("products", products);
		
		getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
	}
}
