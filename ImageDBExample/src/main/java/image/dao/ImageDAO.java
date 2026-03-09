package image.dao;

/*
 * Author: FES
 * Date: June 2024
 */

import java.io.ByteArrayOutputStream;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import image.connection.ConnectionManager;
import image.model.ImageBean;

public class ImageDAO {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static String sql;

	public static void uploadFile(ImageBean file){  

		try{  
			//call getConnection() method
			con = ConnectionManager.getConnection(); 
			
			//3. create statement
			sql = "INSERT INTO photos(photo)VALUES(?)";
			ps = con .prepareStatement(sql);  

			// fetches input stream of the upload file for the blob column
			ps.setBlob(1, file.getFile());

			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}  
	}  

	public static List<ImageBean> getAllImages(){  
		List<ImageBean> list=new ArrayList<ImageBean>();  

		try{  
			//call getConnection() method			
			con = ConnectionManager.getConnection();
			
			//3. create statement
			sql = "SELECT * FROM photos";
			ps=con.prepareStatement(sql);  
			
			//4. execute query
			rs=ps.executeQuery();  

			while(rs.next()){  
				ImageBean image=new ImageBean();  
				image.setId(rs.getInt("id")); 
				Blob blob = rs.getBlob("photo");

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);                  
				}
				byte[] imageBytes = outputStream.toByteArray();
				String photo = Base64.getEncoder().encodeToString(imageBytes);

				image.setPhoto(photo);
				inputStream.close();
				outputStream.close();

				list.add(image);  
			}  
			
			//5. close connection
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}  
		return list;  
	}  
}