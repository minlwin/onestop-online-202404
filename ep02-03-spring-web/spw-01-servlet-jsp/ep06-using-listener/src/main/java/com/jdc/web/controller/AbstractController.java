package com.jdc.web.controller;

import org.springframework.context.ApplicationContext;

import jakarta.servlet.http.HttpServlet;

public abstract class AbstractController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected <T> T getBean(Class<T> type) {
		var applicationContext = (ApplicationContext)getServletContext().getAttribute("applicationContext");
		return applicationContext.getBean(type);
	}
}
