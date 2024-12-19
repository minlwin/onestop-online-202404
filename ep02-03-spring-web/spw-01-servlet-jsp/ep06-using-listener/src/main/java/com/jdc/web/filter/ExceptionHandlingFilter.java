package com.jdc.web.filter;

import java.io.IOException;

import com.jdc.web.spring.utils.BusinessException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

public class ExceptionHandlingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		try {
			chain.doFilter(request, response);
		} catch (BusinessException e) {
			var resp = (HttpServletResponse)response;
			resp.sendRedirect(request.getServletContext().getContextPath().concat("/error.jsp?error=%s".formatted(e.getMessage())));
		}
	}

}
