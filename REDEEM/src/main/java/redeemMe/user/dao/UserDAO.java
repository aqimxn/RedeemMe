package redeemMe.user.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import redeemMe.connection.ConnectionManager;
import redeemMe.user.model.*;

public class UserDAO {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	//insert shawl
	public static void addUser(User user) throws SQLException, NoSuchAlgorithmException{
		
		try {
			//call getConnection() method
			con = redeemMe.connection.ConnectionManager.getConnection();
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(user.getpassword().getBytes());
			byte byteData[] = md.digest();

			//convert the byte to hex format
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

			//3. create statement
			String sql = "INSERT INTO user(FirstName,LastName,Email,Password,Mobile,Picture,Address1,Address2,Postcode,City,State,Points,UserType)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			//get values from Shawl object and set parameter values
			ps.setString(1, user.getfirstName());
			ps.setString(2, user.getlastName());
			ps.setString(3, user.getemail());
			ps.setString(4, sb.toString());
			ps.setString(5, user.getmobile());
			ps.setString(6, user.getpicture());
			ps.setString(7, user.getaddress1());
			ps.setString(8, user.getaddress2());
			ps.setString(9, user.getpostcode());
			ps.setString(10, user.getcity());
			ps.setString(11, user.getstate());
			ps.setInt(12, 0);
			ps.setString(13, "Customer");
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			}catch(SQLException e) {
			e.printStackTrace();
			}		
	}	
	
	
	//update shawl
	public static void updateUser(User user, int id) throws SQLException{
		try {
			//call getConnection() method
			con = redeemMe.connection.ConnectionManager.getConnection();
			
			//3. create statement and get the values from Shawl object
			ps = con.prepareStatement("UPDATE user SET Points=? WHERE UserId=?");
			
			//get values from Shawl object and set parameter values
			ps.setInt(1, user.getpoints());
			ps.setInt(2, id);

			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			}catch(Exception e) {
			e.printStackTrace();
			}
		
		
	}	
	
	
	//delete shawl
	public static void deleteUser(int UserId) throws SQLException{
		try {
			//call getConnection() method
			con = redeemMe.connection.ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "DELETE FROM user WHERE UserId=?";
			ps = con.prepareStatement(sql);
			
			//set parameter values
			ps.setInt(1, UserId);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			}catch(SQLException e) {
			e.printStackTrace();
			}
		
	}
	
	
	//get shawl by id
	public static User getUser(int UserId) {
		
		User user = new User();
		
		try {
			//call getConnection() method
			con = redeemMe.connection.ConnectionManager.getConnection();
			
			//3. create statement
			ps = con.prepareStatement("SELECT * FROM user WHERE UserId=?");
			
			//set parameter values
			ps.setInt(1, UserId);
			
			//4. execute query
			rs = ps.executeQuery();
			
			//process ResultSet and set the values to the Shawl object
			if(rs.next()) {
			user.setuserId(rs.getInt("UserId"));
			user.setfirstName(rs.getString("FirstName"));
			user.setlastName(rs.getString("LastName"));
			user.setemail(rs.getString("Email"));
			user.setpassword(rs.getString("Password"));
			user.setmobile(rs.getString("Mobile"));
			user.setpicture(rs.getString("Picture"));
			user.setaddress1(rs.getString("Address1"));
			user.setaddress2(rs.getString("Address2"));
			user.setpostcode(rs.getString("Postcode"));
			user.setcity(rs.getString("City"));
			user.setstate(rs.getString("State"));
			user.setpoints(rs.getInt("Points"));
			
			}
			
			//5. close connection
			con.close();
			}catch(Exception e) {
			e.printStackTrace();
			}
		
		
		return user;
	}
	
	
	//get all shawls
	public static List<User> getAllUser(){
		List<User> users = new ArrayList<User>();

		try {
			//call getConnection() method
			con = redeemMe.connection.ConnectionManager.getConnection();
			
			//3. create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM user WHERE UserType='Customer' ORDER BY UserId";
			
			//4. execute query
			rs = stmt.executeQuery(sql);
			
			//process ResultSet and set the values to the Shawl object
			while(rs.next()) {
			User user = new User();
			user.setuserId(rs.getInt("UserId"));
			user.setfirstName(rs.getString("FirstName"));
			user.setlastName(rs.getString("LastName"));
			user.setemail(rs.getString("Email"));
			user.setpassword(rs.getString("Password"));
			user.setmobile(rs.getString("Mobile"));
			user.setpicture(rs.getString("Picture"));
			user.setaddress1(rs.getString("Address1"));
			user.setaddress2(rs.getString("Address2"));
			user.setpostcode(rs.getString("Postcode"));
			user.setcity(rs.getString("City"));
			user.setstate(rs.getString("State"));
			user.setpoints(rs.getInt("Points"));
			users.add(user);
			}
			
			//5. close connection
			con.close();
			}catch(Exception e) {
			e.printStackTrace();
			}
		
		
		return users;
	}
	
	public static int getUsersCount() {
	    int count = 0;

	    try {
	        // Call getConnection() method
	        con = redeemMe.connection.ConnectionManager.getConnection();
	        
	        // Create statement
	        stmt = con.createStatement();
	        String sql = "SELECT COUNT(UserId) AS total_count FROM user WHERE UserType='Customer'";
	        
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
	
	public static User login(User user) throws NoSuchAlgorithmException{

		//convert the password to MD5
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(user.getpassword().getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "SELECT * FROM user WHERE Email = ? AND Password = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getemail());
			ps.setString(2, sb.toString());
			
		    //4. execute query
			rs = ps.executeQuery();

			// if user exists set the isValid variable to true
			if (rs.next()) {
				user.setuserId(rs.getInt("UserId"));
				user.setemail(rs.getString("Email"));
				user.setUserType(rs.getString("UserType"));
				user.setfirstName(rs.getString("FirstName"));
				user.setValid(true);
			}
			// if user does not exist set the isValid variable to false
			else{
				user.setValid(false);
			}

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return user;
	}
	
	public static User getUserByEmail(String email) {
		User user = new User();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement  
			String sql = "SELECT * FROM user WHERE Email=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			
			//execute statement
			rs = ps.executeQuery();

			if (rs.next()) {	            
				user.setuserId(rs.getInt("UserId"));
				user.setemail(rs.getString("Email"));				
				user.setpassword(rs.getString("Password"));
				user.setUserType(rs.getString("UserType"));
			}
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return user;
	}


}