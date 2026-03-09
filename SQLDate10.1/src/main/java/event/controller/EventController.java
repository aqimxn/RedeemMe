package event.controller;

/*
 * Author: FES
 * Date: March 2024
 */
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import event.dao.EventDAO;
import event.model.Event;

/**
 * Servlet implementation class EventController
 */
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DateFormat formatter; 
	private RequestDispatcher view;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//convert date format from picker dd/MM/yyyy to yyyy-MM-dd
		    formatter = new SimpleDateFormat("yyyy-MM-dd");
		    
		    //get the date and convert to java date
		    java.util.Date date1=formatter.parse(request.getParameter("departDate"));
		    java.util.Date date2=formatter.parse(request.getParameter("returnDate"));
		    
		    //set converted date
		    Event eventDate = new Event();
		    eventDate.setDepartDate(date1);
		    eventDate.setReturnDate(date2);
		    
		    //invoke addEvent() in EventDAO
		    EventDAO.addEvent(eventDate);
		    
			}catch(Exception e){
				System.out.println(e);
			}
		//forward to event.jsp
		view = request.getRequestDispatcher("event.jsp");
		view.forward(request, response);
			
	}

}