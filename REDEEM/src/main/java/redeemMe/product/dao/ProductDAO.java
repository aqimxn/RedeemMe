package redeemMe.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import redeemMe.connection.ConnectionManager;
import redeemMe.product.model.*;
import redeemMe.supplier.model.*;

public class ProductDAO {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static void addProduct(Product product) throws SQLException{	
		try {
			con = ConnectionManager.getConnection();
			String sql = "INSERT INTO product(ProductId,ProductName,ProductCategory,ProductPoints,ProductQuantity,ProductImage,ProductDescription,SupplierId)VALUES(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, product.getproductId());
			ps.setString(2, product.getproductName());
			ps.setString(3, product.getproductCategory());
			ps.setInt(4, product.getproductPoints());
			ps.setInt(5, product.getproductQuantity());
			ps.setString(6, product.getproductImage());
			ps.setString(7, product.getproductDescription());
			ps.setInt(8, product.getsupplierId());
			ps.executeUpdate();
			con.close();
			}catch(SQLException e) {
			e.printStackTrace();
			}		
	}	
	
	public static void updateProduct(Product product, int id) throws SQLException{
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("UPDATE product SET ProductPoints=?,ProductQuantity=? WHERE ProductId=?");
			ps.setInt(1, product.getproductPoints());
			ps.setInt(2, product.getproductQuantity());
			ps.setInt(3, id);
			ps.executeUpdate();
			con.close();
			}catch(Exception e) {
			e.printStackTrace();
			}	
	}	
	
	public static void deleteProduct(int id) throws SQLException{
		try {
			con = ConnectionManager.getConnection();
			String sql = "DELETE FROM product WHERE ProductId=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			con.close();
			}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Product getProductNull(int productId) {
	    Product product = new Product();	
	    try {
	        con = ConnectionManager.getConnection();
	        ps = con.prepareStatement("SELECT * FROM product WHERE ProductId=?");
	        ps.setInt(1, productId);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            product.setproductId(rs.getInt("ProductId"));
	            product.setproductName(rs.getString("ProductName"));
	            product.setproductCategory(rs.getString("ProductCategory"));
	            product.setproductPoints(rs.getInt("ProductPoints"));
	            product.setproductQuantity(rs.getInt("ProductQuantity"));
	            product.setproductImage("0");
	            product.setproductDescription(rs.getString("ProductDescription"));
	            product.setsupplierId(rs.getInt("SupplierId"));
	            product.setSupplierName(rs.getString("SupplierName"));
	        }
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return product;
	}
	
	public static Product getProduct(int pid) {
	    Product product = new Product();	
	    try {
	        con = ConnectionManager.getConnection();
	        ps = con.prepareStatement("SELECT * FROM product p JOIN supplier s ON p.SupplierId = s.SupplierId WHERE p.ProductId=?");
	        ps.setInt(1, pid);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            product.setproductId(rs.getInt("ProductId"));
	            product.setproductName(rs.getString("ProductName"));
	            product.setproductCategory(rs.getString("ProductCategory"));
	            product.setproductPoints(rs.getInt("ProductPoints"));
	            product.setproductQuantity(rs.getInt("ProductQuantity"));
	            product.setproductImage("0");
	            product.setproductDescription(rs.getString("ProductDescription"));
	            product.setsupplierId(rs.getInt("SupplierId"));
	            product.setSupplierName(rs.getString("SupplierName"));
	        }
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return product;
	}
	
	public static Product getProductByUser(int id) {
	    Product product = new Product();	
	    try {
	    	
	        con = ConnectionManager.getConnection();
	        ps = con.prepareStatement("SELECT p.*, o.*, u.* FROM product p JOIN `order` o ON p.ProductId = o.ProductId JOIN user u ON o.UserId = u.UserId WHERE p.ProductId=?");
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	        	System.out.println("masuk");
	        	product.setproductId(rs.getInt("ProductId"));
	            product.setproductName(rs.getString("ProductName"));
	            product.setproductCategory(rs.getString("ProductCategory"));
	            product.setproductPoints(rs.getInt("ProductPoints"));
	            product.setproductQuantity(rs.getInt("ProductQuantity"));  
	            product.setFirstName(rs.getString("FirstName"));
	            product.setLastName(rs.getString("LastName"));
	            product.setMobile(rs.getString("Mobile"));
	            product.setAddress1(rs.getString("Address1"));
	            product.setAddress2(rs.getString("Address2"));
	            product.setPostcode(rs.getString("Postcode"));
	            product.setUserId(rs.getInt("userId"));
	            System.out.print("dapat save");
	        }
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return product;
	}

	
	public static List<Product> getAllProducts(){
	    List<Product> products = new ArrayList<Product>();
	    try {
	        con = ConnectionManager.getConnection();
	        stmt = con.createStatement();
	        String sql = "SELECT * "
	                    + "FROM product p "
	                    + "LEFT JOIN supplier s "
	                    + "ON s.SupplierId = p.SupplierId "
	                    + "ORDER BY p.ProductId";
	        rs = stmt.executeQuery(sql);
	        while(rs.next()) {
	            Product product = new Product();
	            product.setproductId(rs.getInt("ProductId"));
	            product.setproductName(rs.getString("ProductName"));
	            product.setproductCategory(rs.getString("ProductCategory"));
	            product.setproductPoints(rs.getInt("ProductPoints"));
	            product.setproductQuantity(rs.getInt("ProductQuantity"));
	            product.setproductImage("0");
	            product.setproductDescription(rs.getString("ProductDescription"));
	            Integer supplierId = (Integer) rs.getObject("SupplierId");
	            if (supplierId == null) {
	                product.setSupplierName("null");
	            } else {
	                product.setsupplierId(supplierId);
	                product.setSupplierName(rs.getString("SupplierName"));
	            }
	            products.add(product);
	        }
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return products;
	}

	
	public static int getProductsCount() {
	    int count = 0;

	    try {
	        // Call getConnection() method
	        con = redeemMe.connection.ConnectionManager.getConnection();
	        
	        // Create statement
	        stmt = con.createStatement();
	        String sql = "SELECT COUNT(ProductId) AS total_count FROM product";
	        
	        // Execute query
	        rs = stmt.executeQuery(sql);
	        
	        // Process ResultSet to get the count
	        if (rs.next()) {
	            count = rs.getInt("total_count");
	        }
	        
	        // Close connection
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return count;
	}
}