package com.jdc.web.filter;

import java.io.IOException;

import org.springframework.util.StringUtils;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {
		"/products/edit",
		"/products/upload",
		"/categories/details"
})
public class CategoryIdCheckFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		var req = (HttpServletRequest)request;
		
		var categoryId = req.getParameter("categoryId");
		
		if(!StringUtils.hasLength(categoryId)) {
			var resp = (HttpServletResponse)response;
			resp.sendError(400);
			return;
		}
		
		chain.doFilter(request, response);
	}

}
