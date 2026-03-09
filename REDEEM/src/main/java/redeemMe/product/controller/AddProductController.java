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
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class AddShawlServlet
 */
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductController() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//create Shawl object
		Product product = new Product();
		
		//retrieve input from HTML and set the values to the Shawl object
		product.setproductId(Integer.parseInt("0"));
		product.setproductName(request.getParameter("ProductName"));
		product.setproductCategory(request.getParameter("ProductCategory"));
		product.setproductPoints(Integer.parseInt(request.getParameter("ProductPoints")));
		product.setproductQuantity(Integer.parseInt(request.getParameter("ProductQuantity")));
		product.setproductImage(request.getParameter("ProductImage"));
		product.setproductDescription(request.getParameter("ProductDescription"));
		product.setsupplierId(Integer.parseInt(request.getParameter("SupplierId")));
		
		//call addProduct() from ProductDAO class
		try {
			ProductDAO.addProduct(product);
			out.print("<script>alert('New product successfully added!')</script>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.print("<script>alert('New product unsuccessfully added!')</script>");
			e.printStackTrace();
		}
		
		//set attribute to a servlet request. Set the attribute name to products and call getAllproduct() from productDAO class
		request.setAttribute("products", ProductDAO.getAllProducts());
		
		//Obtain the RequestDispatcher from the request object. The pathname to the resource is listShawl.jsp
		RequestDispatcher req = request.getRequestDispatcher("ListProductController");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response);

		
	}
}
