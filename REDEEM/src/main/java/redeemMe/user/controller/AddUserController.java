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
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;


/**
 * Servlet implementation class AddShawlServlet
 */
public class AddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//create User object
		User user = new User();
		
		//retrieve input from HTML and set the values to the user object
		user.setfirstName(request.getParameter("first-name"));
		user.setlastName(request.getParameter("last-name"));
		user.setemail(request.getParameter("email"));
		user.setpassword(request.getParameter("password"));
		user.setmobile(request.getParameter("contact"));
		user.setpicture(request.getParameter("image"));
		user.setaddress1(request.getParameter("address1"));
		user.setaddress2(request.getParameter("address2"));
		user.setpostcode(request.getParameter("postcode"));
		user.setcity(request.getParameter("city"));
		user.setstate(request.getParameter("state"));
		
		//call addUser() from UserDAO class
		try {
			UserDAO.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Obtain the RequestDispatcher from the request object. The pathname to the resource is listUser.jsp
		RequestDispatcher req = request.getRequestDispatcher("login.jsp");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);

		
	}
}
