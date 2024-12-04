package com.jdc.web.cookies.controller;

import java.io.IOException;

import com.jdc.web.cookies.controller.model.UserInformationMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
	urlPatterns = "/user-info"
)
public class UserInfoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var cookies = req.getCookies();
		
		for(var cookie : cookies) {
			if(cookie.getName().equals("userInfo")) {
				var json = cookie.getValue();
				var user = UserInformationMapper.fromJson(json);
				req.setAttribute("userInfo", user);
			}
		}
		
		getServletContext().getRequestDispatcher("/user-info.jsp").forward(req, resp);
	}

}
