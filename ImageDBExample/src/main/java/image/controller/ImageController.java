package image.controller;

/*
 * Author: FES
 * Date: June 2024
 */

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import image.dao.ImageDAO;
import image.model.ImageBean;

/**
 * Servlet implementation class ImageController
 */
@MultipartConfig(maxFileSize = 16177215)
public class ImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//set attribute to a servlet request
		request.setAttribute("images", ImageDAO.getAllImages());

		//Obtain the RequestDispatcher from the request object.
		RequestDispatcher req = request.getRequestDispatcher("listImages.jsp");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
		ImageBean img = new ImageBean();

		InputStream inputStream = null; // input stream of the upload file

		// obtains the upload file part in this multipart request
		Part filePart = request.getPart("photo");
		
		// obtains input stream of the upload file
		inputStream = filePart.getInputStream();
		
		img.setFile(inputStream);
		ImageDAO.uploadFile(img);

		request.setAttribute("images", ImageDAO.getAllImages());

		//Obtain the RequestDispatcher from the request object. 
		RequestDispatcher req = request.getRequestDispatcher("listImages.jsp");

		//Dispatch the request to another resource using forward() methods of the RequestDispatcher
		req.forward(request, response); 
	}

}
