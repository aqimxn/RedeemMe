package redeemMe.supplier.model;

import java.io.Serializable;

public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;
    private int supplierId;
    private String supplierName;
    private int supplierNum;
    private String supplierEmail;
    private String supplierAdd1;
    private String supplierAdd2;
    private int supplierPostcode;
    private String supplierCity;
    private String supplierState;
	private int count;
	
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
    
    public String getSupplierState() {
        return supplierState;
    }

    public void setSupplierState(String supplierState) {
        this.supplierState = supplierState;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getSupplierNum() {
        return supplierNum;
    }

    public void setSupplierNum(int supplierNum) {
        this.supplierNum = supplierNum;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierAdd1() {
        return supplierAdd1;
    }

    public void setSupplierAdd1(String supplierAdd1) {
        this.supplierAdd1 = supplierAdd1;
    }

    public String getSupplierAdd2() {
        return supplierAdd2;
    }

    public void setSupplierAdd2(String supplierAdd2) {
        this.supplierAdd2 = supplierAdd2;
    }

    public int getSupplierPostcode() {
        return supplierPostcode;
    }

    public void setSupplierPostcode(int supplierPostcode) {
        this.supplierPostcode = supplierPostcode;
    }

    public String getSupplierCity() {
        return supplierCity;
    }

    public void setSupplierCity(String supplierCity) {
        this.supplierCity = supplierCity;
    }
}
