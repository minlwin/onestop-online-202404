package com.jdc.web.filter;

import java.io.IOException;

import org.springframework.util.StringUtils;

import com.jdc.web.spring.utils.BusinessException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ProductIdCheckFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		var productId = request.getParameter("productId");
		
		if(!StringUtils.hasLength(productId)) {
			throw new BusinessException("Please select product id.");
		}
		
		chain.doFilter(request, response);
	}

}
