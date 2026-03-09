package event.dao;

/*
 * Author: FES
 * Date: March 2024
 */
import java.sql.*;
import java.util.Date;
import event.connection.ConnectionManager;
import event.model.Event;

public class EventDAO {
	private static Connection con = null;
	private static ResultSet rs = null; 
	private static PreparedStatement ps=null;
	private static Statement stmt=null;
	private static Date departureDate, returnDate;
	
	
	public static void addEvent(Event bean){	
		//get the date
		departureDate = bean.getDepartDate();
		returnDate = bean.getReturnDate();
		
        //convert java date to sql date
        java.sql.Date ddate = new java.sql.Date(departureDate.getTime());
        java.sql.Date rdate = new java.sql.Date(returnDate.getTime());
        
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement  
			ps=con.prepareStatement("insert into event(departureDate,returnDate)values(?,?)");
			ps.setDate(1,ddate);
			ps.setDate(2,rdate);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();		
		}		
	}

}
