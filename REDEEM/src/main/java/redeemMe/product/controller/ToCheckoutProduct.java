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
import redeemMe.product.dao.*;
import redeemMe.product.model.*;
import redeemMe.user.dao.UserDAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class ToCheckoutProduct
 */
public class ToCheckoutProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ToCheckoutProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            HttpSession session = request.getSession(false);
            if (session != null) {
            System.out.println("Pass To CheckoutProduct");
            	
            int userId = (Integer) session.getAttribute("sessionId");
            request.setAttribute("userId", userId);
            	
            int productPoints = Integer.parseInt(request.getParameter("productPoints"));
            int productId = Integer.parseInt(request.getParameter("productId"));
		
		request.setAttribute("product", ProductDAO.getProduct(productId));
        request.setAttribute("user", UserDAO.getUser(userId));
        request.setAttribute("productPoints", UserDAO.getUser(productPoints));
      
    	RequestDispatcher req = request.getRequestDispatcher("customer-checkout.jsp");
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
}

