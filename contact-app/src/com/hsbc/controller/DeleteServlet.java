package com.hsbc.controller;

import java.io.IOException;
import java.util.List;

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
import com.hsbc.model.util.Type;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService service = (UserService)UserFactory.getInstance(Type.SERVICE);

			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("userKey");
			long profileId = user.getProfileId();
			try {
				service.deleteUser(profileId);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				request.setAttribute("err", e.getMessage());
				e.printStackTrace();
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
			rd.forward(request, response);

	}

}
