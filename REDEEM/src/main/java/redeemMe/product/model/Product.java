package redeemMe.product.model;

import java.io.Serializable;
import redeemMe.supplier.model.*;

/**
 * Author: FES
 */
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private int productId;
	private String productName;
	private String productCategory;
	private int productPoints;
	private int productQuantity;
	private String productImage;
	private String productDescription;
	private int supplierId;
	private int count;
	private String supplierName;
	private int orderId;
	private String firstName;
	private String lastName;
	private String Mobile;
	private String Address1;
	private String Address2;
	private String postcode;
	private String city;
	private String state;
	private int userId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getproductId() {
		return productId;
	}
	public void setproductId(int productId) {
		this.productId = productId;
	}
	public String getproductName() {
		return productName;
	}
	public void setproductName(String productName) {
		this.productName = productName;
	}
	public String getproductCategory() {
		return productCategory;
	}
	public void setproductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public int getproductPoints() {
		return productPoints;
	}
	public void setproductPoints(int productPoints) {
		this.productPoints = productPoints;
	}
	public int getproductQuantity() {
		return productQuantity;
	}
	public void setproductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getproductImage() {
		return productImage;
	}
	public void setproductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getproductDescription() {
		return productDescription;
	}
	public void setproductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getsupplierId() {
		return supplierId;
	}
	public void setsupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String address1) {
		Address1 = address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String address2) {
		Address2 = address2;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	
	
	
}