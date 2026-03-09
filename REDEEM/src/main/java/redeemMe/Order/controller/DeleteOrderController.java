package redeemMe.Order.controller;

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
import redeemMe.Order.dao.*;
import redeemMe.Order.model.*;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class DeleteShawlController
 */
public class DeleteOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get id from input parameter
		
		int OrderId = Integer.parseInt(request.getParameter("OrderId"));
		
		//call deleteShawl() from ShawlDAO class
		try {
			OrderDAO.deleteOrder(OrderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//set attribute to a servlet request. Set the attribute name to shawls and call getAllShawls() from ShawlDAO class
		request.setAttribute("orders", OrderDAO.getAllOrder());
		
		//Obtain the RequestDispatcher from the request object. The pathname to the resource is listShawl.jsp
		RequestDispatcher req = request.getRequestDispatcher("admin-order.jsp");

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
