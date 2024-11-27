package com.jdc.spring.web;

import java.io.IOException;

import com.jdc.spring.web.model.StudentModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		
 		var strId = request.getParameter("id");
 		var id = Integer.parseInt(strId);
 		
 		var student = StudentModel.getInstance().findById(id);
 		request.setAttribute("student", student);
 		
 		request.getRequestDispatcher("registration-result.jsp")
 			.forward(request, response);
 	}
 	
 	@Override
 	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 		
 		var name = req.getParameter("name");
 		var phone = req.getParameter("phone");
 		var email = req.getParameter("mail");
 		
 		var id = StudentModel.getInstance().addStudent(name, phone, email);
 		
 		resp.sendRedirect(req.getContextPath().concat("/registration?id=").concat(String.valueOf(id)));
 	}

}
