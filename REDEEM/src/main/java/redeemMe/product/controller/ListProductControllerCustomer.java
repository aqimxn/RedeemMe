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
import jakarta.servlet.http.HttpSession;
import redeemMe.connection.ConnectionManager;
import redeemMe.product.dao.*;
import redeemMe.product.model.*;
import redeemMe.supplier.dao.SupplierDAO;
import redeemMe.user.dao.UserDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ListProductControllerCustomer
 */
public class ListProductControllerCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductControllerCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
            	System.out.println("Pass To ListProductCustomer");
                int userId = (Integer) session.getAttribute("sessionId");
                request.setAttribute("userId", userId);

                // Set products attribute
                request.setAttribute("products", ProductDAO.getAllProducts());
                request.setAttribute("user", UserDAO.getUser(userId));

                // Forward to customer-shop.jsp
                RequestDispatcher req = request.getRequestDispatcher("customer-shop.jsp");
                req.forward(request, response);
            } else {
                response.sendRedirect("login.jsp"); // Redirect to login if session is invalid
            }
        } catch (Exception e) {
            e.printStackTrace();
			/*
			 * response.sendRedirect("error.html"); // Redirect to an error page or handle
			 * exception
			 */        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
		
	}

}
