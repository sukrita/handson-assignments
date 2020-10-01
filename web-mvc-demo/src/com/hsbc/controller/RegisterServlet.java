package com.hsbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.DatabaseException;
import com.hsbc.model.beans.User;
import com.hsbc.model.service.UserService;
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
		user.setUserId(Integer.parseInt(request.getParameter("userId")));
		user.setName(request.getParameter("username"));
		user.setPassword(request.getParameter("pass"));
		user.setPhone(Long.parseLong(request.getParameter("phone")));
		UserService service = (UserService)UserFactory.getInstance("service");
		
		try {
			User userStored = service.createUser(user);
			HttpSession session = request.getSession();
			session.setAttribute("userKeyRegisteration", userStored);
			RequestDispatcher rd = request.getRequestDispatcher("registersuccess.jsp");
			rd.forward(request, response);
		} catch (DatabaseException e) {	
			RequestDispatcher rd = request.getRequestDispatcher("registerfailure.jsp");
			request.setAttribute("err", e.getMessage());
			rd.forward(request, response);
		}

	}

}
