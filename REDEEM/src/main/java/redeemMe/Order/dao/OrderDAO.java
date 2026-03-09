package redeemMe.Order.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import redeemMe.connection.ConnectionManager;
import redeemMe.Order.model.*;
import redeemMe.user.model.*;

public class OrderDAO {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//insert shawl
	public static void addOrder(Order order) throws SQLException{
		
		try {
			//call getConnection() method
			con = redeemMe.connection.ConnectionManager.getConnection();

			//3. create statement
			String sql = "INSERT INTO `order`(OrderId,OrderDate,OrderTime,ShipmentStatus,ProductId,UserId)VALUES(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//get values from Shawl object and set parameter values
			ps.setInt(1, 0);
			ps.setString(2, order.getorderDate());
			ps.setString(3, order.getorderTime());
			ps.setString(4,"Pending");
			ps.setInt(5, order.getproductId());
			ps.setInt(6, order.getuserId());
			ps.executeUpdate();
			
			con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}	
	}	
	
	
	//update shawl
	public static void updateOrder(Order order, int oid) throws SQLException {
	    String sql = "UPDATE `order` " +
	                 "SET ShipmentStatus = ? " +
	                 "WHERE OrderId = ?";

	    try (Connection con = redeemMe.connection.ConnectionManager.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {
	        
	        // Set parameter values
	        ps.setString(1, order.getShipmentStatus());
	        ps.setInt(2, oid);
	        
	        // Execute update
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Consider logging the exception properly
	        throw e; // Rethrow the exception to propagate it upwards
	    }
	}

	
	
	//delete shawl
	public static void deleteOrder(int OrderId) throws SQLException{
		try {
			//call getConnection() method
			con = redeemMe.connection.ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "DELETE FROM `order` WHERE OrderId=?";
			ps = con.prepareStatement(sql);
			
			//set parameter values
			ps.setInt(1, OrderId);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			}catch(SQLException e) {
			e.printStackTrace();
			}
	}
	
	//get shawl by id
	public static Order getOrder(int OrderId) {
		
		Order order = new Order();
		
		try {
			//call getConnection() method
			con = redeemMe.connection.ConnectionManager.getConnection();
			
			//3. create statement
			ps = con.prepareStatement("SELECT * FROM `order` WHERE OrderId=?");
			
			//set parameter values
			ps.setInt(1, OrderId);
			
			//4. execute query
			rs = ps.executeQuery();
			
			//process ResultSet and set the values to the Shawl object
			if(rs.next()) {
				order.setorderId(rs.getInt("OrderId"));
				order.setorderDate(rs.getString("OrderDate"));
				order.setorderTime(rs.getString("OrderTime"));
				order.setShipmentStatus(rs.getString("ShipmentStatus"));
				order.setproductId(rs.getInt("ProductId"));
				order.setuserId(rs.getInt("UserId"));
			}
			
			//5. close connection
			con.close();
			}catch(Exception e) {
			e.printStackTrace();
			}
		
		return order;
	}
	
	public static Order getOrderWithJoin(int oid) {
		
		Order order = new Order();
		
		try {
			//call getConnection() method
			con = redeemMe.connection.ConnectionManager.getConnection();
			
			//3. create statement
			ps = con.prepareStatement("SELECT * "
					+ "					FROM `order` o"
					+ "					JOIN product p"
					+ "					ON o.ProductId = p.ProductId"
					+ "					JOIN user u"
					+ "					ON o.UserId = u.UserId"
					+ "					WHERE o.OrderId=?");
			
			//set parameter values
			ps.setInt(1, oid);
			
			//4. execute query
			rs = ps.executeQuery();
			
			//process ResultSet and set the values to the Shawl object
			if(rs.next()) {
				order.setorderId(rs.getInt("OrderId"));
				order.setorderDate(String.valueOf(rs.getString("OrderDate")));
				order.setorderTime(String.valueOf(rs.getString("OrderTime")));
				order.setproductId(rs.getInt("ProductId"));
				order.setuserId(rs.getInt("UserId"));
				order.setproductId(rs.getInt("ProductId"));
				order.setuserId(rs.getInt("UserId"));
				order.setUserFirstName(rs.getString("FirstName"));
				order.setUserLastName(rs.getString("LastName"));
				order.setShipmentStatus(rs.getString("ShipmentStatus"));
				order.setProductName(rs.getString("ProductName"));
			}
			
			//5. close connection
			con.close();
			}catch(Exception e) {
			e.printStackTrace();
			}
		
		return order;
	}


		public static Order getProduct(int OrderId) {
			
			Order order = new Order();
			
			try {
				//call getConnection() method
				con = redeemMe.connection.ConnectionManager.getConnection();
				
				//3. create statement
				ps = con.prepareStatement("SELECT * FROM `order` o JOIN product p ON o.OrderId=p.OrderId WHERE o.OrderId=?");
				
				//set parameter values
				ps.setInt(1, OrderId);
				
				//4. execute query
				rs = ps.executeQuery();
				
				//process ResultSet and set the values to the Shawl object
				if(rs.next()) {
					order.setorderId(rs.getInt("OrderId"));
					order.setorderDate(rs.getString("OrderDate"));
					order.setorderTime(rs.getString("OrderTime"));
					order.setproductId(rs.getInt("ProductId"));
					order.setuserId(rs.getInt("UserId"));
				}
				
				//5. close connection
				con.close();
				}catch(Exception e) {
				e.printStackTrace();
				}
			
			return order;
		}
	
	//get all shipment
		public static List<Order> getAllOrder() {
	        List<Order> orders = new ArrayList<Order>();
	        Connection con = null;
	        Statement stmt = null;
	        ResultSet rs = null;

	        try {
	            // Get connection
	            con = redeemMe.connection.ConnectionManager.getConnection();
	            
	            // Create statement
	            stmt = con.createStatement();
	            String sql = "SELECT * " +
	                         "FROM `order` o " +
	                         "JOIN user u ON o.UserId = u.UserId " +
	                         "JOIN product p ON o.ProductId = p.ProductId " +
	                         "ORDER BY o.OrderId";
	            
	            // Execute query
	            rs = stmt.executeQuery(sql);
	            
	            // Process ResultSet
	            while (rs.next()) {
	                Order order = new Order();
	                order.setorderId(rs.getInt("o.OrderId"));
	                order.setorderDate(rs.getString("o.OrderDate"));
	                order.setorderTime(rs.getString("o.OrderTime"));
	                order.setShipmentStatus(rs.getString("o.ShipmentStatus"));
	                order.setproductId(rs.getInt("p.ProductId"));
	                order.setProductName(rs.getString("p.ProductName"));
	                order.setProductQuantity(rs.getInt("p.ProductQuantity"));
	                order.setuserId(rs.getInt("u.UserId"));
	                order.setUserFirstName(rs.getString("u.FirstName"));
	                order.setUserLastName(rs.getString("u.LastName"));
	                orders.add(order);
	            }
	        } catch (Exception e) {
	            e.printStackTrace(); // Consider using a logger instead
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (stmt != null) stmt.close();
	                if (con != null) con.close();
	            } catch (Exception e) {
	                e.printStackTrace(); // Consider using a logger instead
	            }
	        }

	        return orders;
	    }
	
	public static int getOrdersCount() {
	    int count = 0;

	    try {
	        // Call getConnection() method
	        con = redeemMe.connection.ConnectionManager.getConnection();
	        
	        // Create statement
	        stmt = con.createStatement();
	        String sql = "SELECT COUNT(OrderId) AS total_count FROM `order`";
	        
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