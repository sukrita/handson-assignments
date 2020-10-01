package com.hsbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.exception.ContactNotFoundException;
import com.hsbc.model.beans.Contacts;
import com.hsbc.model.beans.User;
import com.hsbc.model.service.UserService;
import com.hsbc.model.util.Type;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class UpdateContactNameServlet
 */
@WebServlet("/UpdateContactNameServlet")
public class UpdateContactNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("userKey");
		long profileId = u.getProfileId();
		long contactId = Long.parseLong(request.getParameter("contactIdName"));
		String name = request.getParameter("name");
		UserService service = (UserService)UserFactory.getInstance(Type.SERVICE);
		
		try {
			Contacts contact = service.updateContactName(profileId, contactId, name);
			session.setAttribute("contactUpdate", contact);
			RequestDispatcher rd = request.getRequestDispatcher("updatecontactsuccess.jsp");
			rd.forward(request, response);
		} catch (ContactNotFoundException e) {
			// TODO Auto-generated catch block
			RequestDispatcher rd = request.getRequestDispatcher("updatecontactfailure.jsp");
			request.setAttribute("err", e.getMessage());
			rd.forward(request, response);

		}
	}

}
