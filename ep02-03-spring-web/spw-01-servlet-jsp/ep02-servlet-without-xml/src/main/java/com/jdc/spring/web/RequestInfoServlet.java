package com.jdc.spring.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/requestInfo")
public class RequestInfoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("contextPath", req.getContextPath());
		req.setAttribute("servletPath", req.getServletPath());
		req.setAttribute("serverPort", req.getServerPort());
		
		var dispatcher = getServletContext().getRequestDispatcher("/request-info.jsp");
		dispatcher.forward(req, resp);
	}

}
