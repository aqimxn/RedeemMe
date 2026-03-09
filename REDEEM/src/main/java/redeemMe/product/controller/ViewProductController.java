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
import redeemMe.connection.ConnectionManager;
import redeemMe.product.dao.*;
import redeemMe.product.model.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class ViewproductController
 */
public class ViewProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get id from input parameter
		int ProductId = Integer.parseInt(request.getParameter("productId"));

		//set attribute to a servlet request. Set the attribute name to products and call getProduct() from ProductDAO class
		request.setAttribute("product", ProductDAO.getProductNull(ProductId));	//ALL IN PRODUCTS ONLY
		request.setAttribute("PRODUCT", ProductDAO.getProduct(ProductId));		//JOIN TO GET SUPPLIER NAME
		request.setAttribute("products", ProductDAO.getAllProducts());
						
		//Obtain the RequestDispatcher from the request object. The pathname to the resource is admin-product-list.jsp
		RequestDispatcher req = request.getRequestDispatcher("view-product-admin.jsp");

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
