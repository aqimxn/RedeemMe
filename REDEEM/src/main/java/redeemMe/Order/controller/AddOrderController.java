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
 * Servlet implementation class AddShawlServlet
 */
public class AddOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderController() {
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

		//create Shawl object
		Order order = new Order();
		
		//retrieve input from HTML and set the values to the Shawl object
		order.setorderDate(request.getParameter("OrderDate"));
		order.setorderTime(request.getParameter("OrderTime"));
		order.setShipmentStatus(request.getParameter("ShipmentStatus"));
		order.setProductName(request.getParameter("ProductName"));
		order.setProductQuantity(Integer.parseInt(request.getParameter("ProductQuantity")));
		
		//call addShawl() from ShawlDAO class
		try {
			OrderDAO.addOrder(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//set attribute to a servlet request. Set the attribute name to shawls and call getAllShawls() from ShawlDAO class
		request.setAttribute("orders", OrderDAO.getAllOrder());
		
		//Obtain the RequestDispatcher from the request object. The pathname to the resource is listShawl.jsp
		RequestDispatcher req = request.getRequestDispatcher("admin-Order.jsp");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);

		
	}
}
