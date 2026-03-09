package redeemMe.user.controller;

/*
 * Author: FES 
 * March 2024
 */

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import redeemMe.user.dao.*;
import redeemMe.user.model.*;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class DeleteShawlController
 */
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get id from input parameter
		
		int UserId = Integer.parseInt(request.getParameter("UserId"));

		
		//call deleteUser() from UserDAO class
		try {
			UserDAO.deleteUser(UserId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//set attribute to a servlet request. Set the attribute name to users and call getAllUser() from UserDAO class
		request.setAttribute("users", UserDAO.getAllUser());
		
		//Obtain the RequestDispatcher from the request object. The pathname to the resource is listUser.jsp
		RequestDispatcher req = request.getRequestDispatcher("customer-profile.jsp");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
