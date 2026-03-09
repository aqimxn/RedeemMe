package redeemMe.product.controller;

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
import redeemMe.product.dao.*;
import redeemMe.product.model.*;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class UpdateProductController
 */
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//create Shawl object
				Product product = new Product();
				
				int ProductId = Integer.parseInt(request.getParameter("productId"));
				
				//retrieve input from HTML and set the values to the Shawl object
				int totalQuantity = Integer.parseInt(request.getParameter("productQuantity")) + Integer.parseInt(request.getParameter("productAddQuantity"));
				product.setproductPoints(Integer.parseInt(request.getParameter("productPoints")));
				product.setproductQuantity(totalQuantity);
				
				try {
					ProductDAO.updateProduct(product, ProductId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//set attribute to a servlet request. Set the attribute name to products and call getAllproduct() from productDAO class
				request.setAttribute("products", ProductDAO.getAllProducts());
				
				//Obtain the RequestDispatcher from the request object. The pathname to the resource is listShawl.jsp
				RequestDispatcher req = request.getRequestDispatcher("ListProductController");

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