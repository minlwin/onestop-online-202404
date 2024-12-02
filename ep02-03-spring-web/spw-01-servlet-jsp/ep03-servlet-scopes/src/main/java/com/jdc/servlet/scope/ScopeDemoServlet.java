package com.jdc.servlet.scope;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/scope")
public class ScopeDemoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Request Scope
		var requestCounter = (Counter)req.getAttribute("counter");
		
		if(null == requestCounter) {
			requestCounter = new Counter();
			req.setAttribute("counter", requestCounter);
		}
		
		requestCounter.countUp();
		
		// Session Scope
		var session = req.getSession(true);
		
		var sessionCounter = (Counter)session.getAttribute("counter");
		
		if(null == sessionCounter) {
			sessionCounter = new Counter();
			session.setAttribute("counter", sessionCounter);
		}
		
		sessionCounter.countUp();
		
		// Application Scope
		var application = getServletContext();
		
		var applicationCounter = (Counter)application.getAttribute("counter");
		
		if(null == applicationCounter) {
			applicationCounter = new Counter();
			application.setAttribute("counter", applicationCounter);
		}
		
		applicationCounter.countUp();
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
