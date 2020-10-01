package com.hsbc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.exception.ContactNotFoundException;
import com.hsbc.model.beans.Contacts;
import com.hsbc.model.beans.User;
import com.hsbc.model.service.UserService;
import com.hsbc.model.util.Type;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class DisplayContacts
 */
@WebServlet("/DisplayContacts")
public class DisplayContacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
UserService service = (UserService)UserFactory.getInstance(Type.SERVICE);

			List<Contacts> list;
			try {
				list = service.fetchAllContacts();
				request.setAttribute("listKey", list);
				RequestDispatcher rd = request.getRequestDispatcher("displaycontacts.jsp");
				rd.forward(request, response);
			} catch (ContactNotFoundException e) {
				// TODO Auto-generated catch block
				request.setAttribute("err", e.getMessage());
				e.printStackTrace();
			}
			

	}


}
