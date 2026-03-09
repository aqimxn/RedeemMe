package redeemMe.user.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import redeemMe.product.dao.ProductDAO;
import redeemMe.supplier.dao.SupplierDAO;
import redeemMe.user.dao.UserDAO;
import redeemMe.user.model.User;

import java.io.IOException;

/**
 * Servlet implementation class CheckOutCustomerController
 */
public class CheckOutCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOutCustomerController() {
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
            System.out.println("Pass To CheckOutCustomer");
           
                int userId = (Integer) session.getAttribute("sessionId");
                request.setAttribute("userId", userId);

                // Set products attribute
                request.setAttribute("user", UserDAO.getUser(userId));
                request.setAttribute("product", ProductDAO.getProduct(userId));

                // Forward to customer-shop.jsp
                RequestDispatcher req = request.getRequestDispatcher("customer-checkout.jsp");
                req.forward(request, response);
            }
                else {
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
		doGet(request, response);
	}

}
