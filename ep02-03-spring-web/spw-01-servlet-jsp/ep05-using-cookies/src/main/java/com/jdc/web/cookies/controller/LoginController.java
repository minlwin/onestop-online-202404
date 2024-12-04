package com.jdc.web.cookies.controller;

import java.io.IOException;

import com.jdc.web.cookies.controller.model.UserInformation;
import com.jdc.web.cookies.controller.model.UserInformationMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var user = new UserInformation();
		user.setName(req.getParameter("name"));
		user.setPhone(req.getParameter("phone"));
		user.setEmail(req.getParameter("email"));
		
		var json = UserInformationMapper.toJson(user);
		
		var cookie = new Cookie("userInfo", json);
		cookie.setMaxAge(60 * 30);
		resp.addCookie(cookie);
		
		resp.sendRedirect(getServletContext().getContextPath().concat("/login-result.jsp"));
	}

}
