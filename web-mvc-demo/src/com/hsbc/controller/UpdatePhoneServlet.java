package com.hsbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.User;
import com.hsbc.model.service.UserService;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class UpdatePhoneServlet
 */
@WebServlet("/UpdatePhoneServlet")
public class UpdatePhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String userId = request.getParameter("userphone");
				int id = Integer.parseInt(userId);
				long phone = Long.parseLong(request.getParameter("phone"));
				UserService service = (UserService)UserFactory.getInstance("service");
				
				try {
					User user = service.updatePhone(id, phone);
					HttpSession session = request.getSession();
					session.setAttribute("userUpdate", user);
					RequestDispatcher rd = request.getRequestDispatcher("updatesuccess.jsp");
					rd.forward(request, response);
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					RequestDispatcher rd = request.getRequestDispatcher("updatefailure.jsp");
					request.setAttribute("err", e.getMessage());
					rd.forward(request, response);

				}
		
	}

}
