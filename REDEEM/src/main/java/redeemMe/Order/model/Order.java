package redeemMe.Order.model;

import java.io.Serializable;

/**
 * Author: FES
 */
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;	
	private int orderId, productId, userId;
	private String userFirstName, userLastName;
	private String orderDate;
	private String orderTime;
	private String shipmentStatus;
	private String productName;
	private int productQuantity;
	private int count;
	
	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getcount() {
		return count;
	}
	
	public void setcount(int count) {
		this.count = count;
	}

	public int getproductId() {
		return productId;
	}

	public void setproductId(int productId) {
		this.productId = productId;
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}
	
	public int getorderId() {
		return orderId;
	}
	public void setorderId(int orderId) {
		this.orderId = orderId;
	}
	public String getorderDate() {
		return orderDate;
	}
	public void setorderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getorderTime() {
		return orderTime;
	}
	public void setorderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
}