package event.model;

import java.io.Serializable;

/*
 * Author: FES
 * Date: March 2024
 */

import java.util.Date;

public class Event implements Serializable{
	private static final long serialVersionUID = 1L;
	private Date departDate;
	private Date returnDate;
	
	public Event() {}
	
	public Date getDepartDate() {
		return departDate;
	}
	public void setDepartDate(Date departDate) {
		this.departDate = departDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

}
