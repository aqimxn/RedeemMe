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
import redeemMe.connection.ConnectionManager;
import redeemMe.Order.dao.*;
import redeemMe.Order.model.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class ViewShawlController
 */
public class ViewOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewOrderController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get id from input parameter
		int OrderId = Integer.parseInt(request.getParameter("orderId"));

		//set attribute to a servlet request. Set the attribute name to shawls and call getShawl() from ShawlDAO class
		request.setAttribute("order", OrderDAO.getOrderWithJoin(OrderId));
		request.setAttribute("orders", OrderDAO.getAllOrder());
						
		//Obtain the RequestDispatcher from the request object. The pathname to the resource is viewShawl.jsp
		RequestDispatcher req = request.getRequestDispatcher("view-order-admin.jsp");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
