package com.jdc.web.filter;

import java.io.IOException;

import org.springframework.util.StringUtils;

import com.jdc.web.spring.utils.BusinessException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class CategoryIdCheckFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		var req = (HttpServletRequest)request;
		
		var categoryId = req.getParameter("categoryId");
		
		if(!StringUtils.hasLength(categoryId)) {
			throw new BusinessException("You need to define category id.");
		}
		
		chain.doFilter(request, response);
	}

}
