package redeemMe.user.controller;

/**
 * Author: Fadilah Ezlina Shahbudin (fadilahezlina@uitm.edu.my)
 * Date: June 2024
 */

import jakarta.servlet.RequestDispatcher;
import redeemMe.dashboard.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import redeemMe.user.dao.*;
import redeemMe.user.model.*;

import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private RequestDispatcher view;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {			
			User user = new User();
			//retrieve and set email and password
			user.setemail(request.getParameter("email"));
			user.setpassword(request.getParameter("password"));
			
			user = UserDAO.login(user);
			
			// Debug: Print user validity
			
			//set user session if user is valid
			if(user.isValid()){
				System.out.println("Pass To LoginAccount");
				HttpSession session = request.getSession(true);
				session.setAttribute("sessionId", user.getuserId());

				if(user.getUserType().equalsIgnoreCase("Admin")) {
					request.setAttribute("userEmail", UserDAO.getUserByEmail(user.getemail()));   					
					view = request.getRequestDispatcher("ViewDashboard"); 	 // customer page
					view.forward(request, response);
				}
				else {					
					response.sendRedirect("ListProductControllerCustomer?userId=" + user.getuserId()); 	 // customer page	
				}											
			}
			//redirect to invalidLoggin.jsp if user is not valid
			else{
				response.sendRedirect("login.jsp");
			}		
		}

		catch (Throwable ex) {
			ex.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}