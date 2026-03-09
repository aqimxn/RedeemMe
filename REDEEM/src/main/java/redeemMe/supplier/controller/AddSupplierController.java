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
 * Servlet implementation class AddShawlServlet
 */
public class AddSupplierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSupplierController() {
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
		Supplier supplier = new Supplier();
		
		//retrieve input from HTML and set the values to the Shawl object
		supplier.setSupplierName(request.getParameter("SupplierName"));
		supplier.setSupplierNum(Integer.parseInt(request.getParameter("SupplierNum")));
		supplier.setSupplierEmail(request.getParameter("SupplierEmail"));
		supplier.setSupplierAdd1(request.getParameter("SupplierAdd1"));
		supplier.setSupplierAdd2(request.getParameter("SupplierAdd2"));
		supplier.setSupplierPostcode(Integer.parseInt(request.getParameter("SupplierPostcode")));
		supplier.setSupplierCity(request.getParameter("SupplierCity"));
		supplier.setSupplierState(request.getParameter("SupplierState"));

		//call addSupplier() from SupplierDAO class
		try {
			SupplierDAO.addSupplier(supplier);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//set attribute to a servlet request. Set the attribute name to suppliers and call getAllSupplier() from SupplierDAO class
		request.setAttribute("suppliers", SupplierDAO.getAllSupplier());
		
		//Obtain the RequestDispatcher from the request object. The pathname to the resource is admin-supplier-add.jsp
		RequestDispatcher req = request.getRequestDispatcher("admin-supplier-list.jsp");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);

		
	}
}
