package com.jdc.web.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		System.out.println("================= Initializing Servlet ====================");
		var maxFileSize = getServletConfig().getInitParameter("maxFileSize");
		var pageSize = getServletConfig().getInitParameter("pageSize");
		var maxWait = getServletContext().getInitParameter("maxWait");
		
		System.out.printf("Max File Size : %s%n", maxFileSize);
		System.out.printf("Page Size     : %s%n", pageSize);
		System.out.printf("Max Wait      : %s%n", maxWait);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var name = req.getParameter("name");
		var phone = req.getParameter("phone");
		
		resp.getWriter().append("""
			<!DOCTYPE html>
			<html>
			<head>
			<meta charset="UTF-8">
			<title>Hello Java Web</title>
			</head>
			<body>
			
				<h1>Hello from Servlet</h1>
				
				<table>
					<tr>
						<td>Name</td>
						<td>%s</td>
					</tr>
					<tr>
						<td>Phone</td>
						<td>%s</td>
					</tr>
				</table>
				
				<a href='/ep01-servlet-with-xml'>Home</a>
			</body>
			</html>				
			""".formatted(name, phone));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("================= Destroying Servlet ====================");
	}
}
