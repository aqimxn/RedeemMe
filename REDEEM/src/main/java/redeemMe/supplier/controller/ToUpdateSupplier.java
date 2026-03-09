package redeemMe.supplier.controller;

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
import redeemMe.supplier.dao.SupplierDAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class UpdateProductController
 */
public class ToUpdateSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ToUpdateSupplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//get id from input parameter
		int SupplierId = Integer.parseInt(request.getParameter("supplierId"));

		//set attribute to a servlet request. Set the attribute name to Product and call getProduct() from ProductDAO class
		request.setAttribute("supplier", SupplierDAO.getSupplier(SupplierId));
		request.setAttribute("suppliers", SupplierDAO.getAllSupplier());

		//Obtain the RequestDispatcher from the request object. The pathname to the resource is admin-product-list.jsp
		RequestDispatcher req = request.getRequestDispatcher("update-supplier-admin.jsp");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

}