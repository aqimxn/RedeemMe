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
import redeemMe.product.dao.ProductDAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class UpdateShawlController
 */
public class UpdateOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateOrderController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Order order = new Order();

		//get id from input parameter
		int id = Integer.parseInt(request.getParameter("orderId"));
		order.setShipmentStatus(request.getParameter("shipment-status"));

		//set attribute to a servlet request. Set the attribute name to shawl and call getShawl() from ShawlDAO class
		request.setAttribute("orders", OrderDAO.getOrder(id));
		
		
		try {
			OrderDAO.updateOrder(order, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Obtain the RequestDispatcher from the request object. The pathname to the resource is updateShawl.jsp
		RequestDispatcher req = request.getRequestDispatcher("admin-order.jsp");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Order order = new Order();

		//get id from input parameter
		int id = Integer.parseInt(request.getParameter("orderId"));
		order.setShipmentStatus(request.getParameter("shipment-status"));

		//set attribute to a servlet request. Set the attribute name to shawl and call getShawl() from ShawlDAO class
		request.setAttribute("orders", OrderDAO.getOrderWithJoin(id));
		
		
		try {
			OrderDAO.updateOrder(order, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Obtain the RequestDispatcher from the request object. The pathname to the resource is updateShawl.jsp
		RequestDispatcher req = request.getRequestDispatcher("ListOrderController");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);
		
	}

}