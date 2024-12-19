package com.jdc.web.filter;

import java.io.IOException;

import com.jdc.web.spring.utils.BusinessException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class ProductUploadCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		var req = (HttpServletRequest)request;
		
		if(null == req.getPart("file")) {
			throw new BusinessException("Please select product file");
		}
		
		chain.doFilter(request, response);
	}

}
