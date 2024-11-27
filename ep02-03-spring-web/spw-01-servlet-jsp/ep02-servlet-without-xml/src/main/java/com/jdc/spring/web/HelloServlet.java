package com.jdc.spring.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
		name = "helloServlet",
		urlPatterns = "/hello",
		loadOnStartup = 1
)
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.getWriter().append("""
			<!DOCTYPE html>
			<html>
			<head>
			<meta charset="UTF-8">
			<title>Servlet Without Web XML</title>""");
		
		var dispatcher = req.getRequestDispatcher("bootstrap.jsp");
		dispatcher.include(req, resp);
		
		resp.getWriter().append("""
			</head>
			<body>
				
				<div class="container mt-4">
					<h1>Hello from Servlet</h1>
					
					<a href="./" class="btn btn-primary">Home</a>
				</div>
			
			</body>
			</html>""");
	}
}
