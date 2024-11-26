package com.jdc.web.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HeaderInfoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var headerNames = req.getHeaderNames();
		
		resp.getWriter().append("""
			<!DOCTYPE html>
			<html>
			<head>
			<meta charset="UTF-8">
			<title>Hello Java Web</title>
			</head>
			<body>
			
				<h1>Header Info Servlet</h1>
				
				<table>
				""");
		
		while(headerNames.hasMoreElements()) {
			var name = headerNames.nextElement();
			var value = req.getHeader(name);
			resp.getWriter().append("<tr><td>%s</td><td>%s</td>".formatted(name, value));
		}
		
		resp.getWriter().append("""
				</table>
				
				<a href='/ep01-servlet-with-xml'>Home</a>
			</body>
			</html>					
				""");
	}
}
