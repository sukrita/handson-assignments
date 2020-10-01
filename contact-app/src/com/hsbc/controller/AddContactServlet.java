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
import com.hsbc.model.beans.Contacts;
import com.hsbc.model.beans.User;
import com.hsbc.model.service.UserService;
import com.hsbc.model.util.Type;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class AddContactServlet
 */
@WebServlet("/AddContactServlet")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Contacts contact = new Contacts();
		contact.setName(request.getParameter("contactName"));
		contact.setPhoneNumber(Long.parseLong(request.getParameter("phoneNumber")));
		UserService service = (UserService)UserFactory.getInstance(Type.SERVICE);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userKey");
		long profileId = user.getProfileId();
		
		try {
			Contacts contactStored = service.addContact(profileId, contact);
			session.setAttribute("contactKey", contact);
			RequestDispatcher rd = request.getRequestDispatcher("addcontactsuccess.jsp");
			rd.forward(request, response);
		} catch (Exception e) {	
			RequestDispatcher rd = request.getRequestDispatcher("addcontactfailure.jsp");
			request.setAttribute("err", e.getMessage());
			rd.forward(request, response);
		}
	}

}
