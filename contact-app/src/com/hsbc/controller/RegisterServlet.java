package com.hsbc.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.model.beans.User;
import com.hsbc.model.service.UserService;
import com.hsbc.model.util.Type;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("pass"));
		user.setPhoneNumber(Long.parseLong(request.getParameter("phone")));
		user.setDateOfBirth(request.getParameter("date"));

		
		UserService service = (UserService)UserFactory.getInstance(Type.SERVICE);
		
		try {
			User userStored = service.createUser(user);
			System.out.println(userStored);
			HttpSession session = request.getSession();
			session.setAttribute("userKey", user);
			RequestDispatcher rd = request.getRequestDispatcher("profilesuccess.jsp");
			rd.forward(request, response);
		} catch (Exception e) {	
			RequestDispatcher rd = request.getRequestDispatcher("registerfailure.jsp");
			request.setAttribute("err", e.getMessage());
			rd.forward(request, response);
		}

	}

}
