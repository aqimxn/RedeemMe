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
import redeemMe.product.dao.ProductDAO;
import redeemMe.supplier.dao.*;
import redeemMe.supplier.model.*;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class UpdateShawlController
 */
public class UpdateSupplierController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSupplierController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Supplier supplier = new Supplier();
		
		//get id from input parameter
		int SupplierId = Integer.parseInt(request.getParameter("supplierId"));
		supplier.setSupplierNum(Integer.parseInt(request.getParameter("supplier-contact")));
		supplier.setSupplierEmail(request.getParameter("supplier-email"));
		supplier.setSupplierAdd1(request.getParameter("supplier-address1"));
		supplier.setSupplierAdd2(request.getParameter("supplier-address2"));
		supplier.setSupplierPostcode(Integer.parseInt(request.getParameter("supplier-postcode")));
		supplier.setSupplierCity(request.getParameter("supplier-city"));
		supplier.setSupplierState(request.getParameter("supplier-state"));
		
		try {
			SupplierDAO.updateSupplier(supplier, SupplierId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//set attribute to a servlet request. Set the attribute name to supplier and call getSupplier() from SupplierDAO class
		request.setAttribute("suppliers", SupplierDAO.getAllSupplier());

		//Obtain the RequestDispatcher from the request object. The pathname to the resource is admin-supplier-list.jsp
		RequestDispatcher req = request.getRequestDispatcher("ListSupplierController");

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