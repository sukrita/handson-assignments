package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ContactDetails
 */
@WebServlet("/contact")
public class ContactDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.out.println("doGet is called");
				PrintWriter pw = response.getWriter();
				pw.print("<html><body><p>");
				pw.print("NameDetails Servlet GET method");
				pw.print("</p></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost is called");
		PrintWriter pw = response.getWriter();
		// getParameter takes name of the parameter & returns the value in string format
		
		HttpSession session = request.getSession(); // it uses the existing session created for the client
		String firstName = (String) session.getAttribute("firstName"); //getAttribute() can take any data, including object
		String lastName = (String) session.getAttribute("lastName");
		String phone = request.getParameter("number");
		String mail = request.getParameter("mail");
		pw.print("<html><body><p>");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("details.html");
		pw.print("First Name: "+ firstName+" ");
		pw.print("Second Name: "+ lastName+" ");;
		pw.print("Phone Number: "+ phone+" ");
		pw.print("Mail: "+ mail);
		
		
		requestDispatcher.include(request, response);
	}

}
