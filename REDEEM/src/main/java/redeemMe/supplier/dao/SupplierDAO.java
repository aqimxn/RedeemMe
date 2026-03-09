 package redeemMe.supplier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import redeemMe.connection.ConnectionManager;
import redeemMe.supplier.model.Supplier;

public class SupplierDAO {

    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static void addSupplier(Supplier supplier) {
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO supplier (SupplierName, SupplierNum, SupplierEmail, SupplierAdd1, SupplierAdd2, SupplierPostcode, SupplierCity, SupplierState) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, supplier.getSupplierName());
            ps.setInt(2, supplier.getSupplierNum());
            ps.setString(3, supplier.getSupplierEmail());
            ps.setString(4, supplier.getSupplierAdd1());
            ps.setString(5, supplier.getSupplierAdd2());
            ps.setInt(6, supplier.getSupplierPostcode());
            ps.setString(7, supplier.getSupplierCity());
            ps.setString(8, supplier.getSupplierState());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateSupplier(Supplier supplier, int id) throws SQLException {
        try {
            con = ConnectionManager.getConnection();
            ps = con.prepareStatement("UPDATE supplier SET SupplierNum = ?, SupplierEmail = ?, SupplierAdd1 = ?, SupplierAdd2 = ?, SupplierPostcode = ?, SupplierCity = ?, SupplierState = ? WHERE SupplierId = ?");
            ps.setInt(1, supplier.getSupplierNum());
            ps.setString(2, supplier.getSupplierEmail());
            ps.setString(3, supplier.getSupplierAdd1());
            ps.setString(4, supplier.getSupplierAdd2());
            ps.setInt(5, supplier.getSupplierPostcode());
            ps.setString(6, supplier.getSupplierCity());
            ps.setString(7, supplier.getSupplierState());
            ps.setInt(8, id);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteSupplier(int supplierId) throws SQLException {
        try {
            con = ConnectionManager.getConnection();
            String sql = "DELETE FROM supplier WHERE SupplierId = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, supplierId);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Supplier getSupplier(int supplierId) {
        Supplier supplier = new Supplier();
        try {
            con = ConnectionManager.getConnection();
            ps = con.prepareStatement("SELECT * FROM supplier WHERE SupplierId = ?");
            ps.setInt(1, supplierId);
            rs = ps.executeQuery();
            if (rs.next()) {
                supplier.setSupplierId(rs.getInt("SupplierId"));
                supplier.setSupplierName(rs.getString("SupplierName"));
                supplier.setSupplierNum(rs.getInt("SupplierNum"));
                supplier.setSupplierEmail(rs.getString("SupplierEmail"));
                supplier.setSupplierAdd1(rs.getString("SupplierAdd1"));
                supplier.setSupplierAdd2(rs.getString("SupplierAdd2"));
                supplier.setSupplierPostcode(rs.getInt("SupplierPostcode"));
                supplier.setSupplierCity(rs.getString("SupplierCity"));
                supplier.setSupplierState(rs.getString("SupplierState"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return supplier;
    }

    public static List<Supplier> getAllSupplier() {
        List<Supplier> suppliers = new ArrayList<Supplier>();
        try {
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM supplier ORDER BY SupplierId";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Supplier supplier = new Supplier();
                supplier.setSupplierId(rs.getInt("SupplierId"));
                supplier.setSupplierName(rs.getString("SupplierName"));
                supplier.setSupplierNum(rs.getInt("SupplierNum"));
                supplier.setSupplierEmail(rs.getString("SupplierEmail"));
                supplier.setSupplierAdd1(rs.getString("SupplierAdd1"));
                supplier.setSupplierAdd2(rs.getString("SupplierAdd2"));
                supplier.setSupplierPostcode(rs.getInt("SupplierPostcode"));
                supplier.setSupplierCity(rs.getString("SupplierCity"));
                supplier.setSupplierState(rs.getString("SupplierState"));
                suppliers.add(supplier);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suppliers;
    }
    
	public static int getSuppliersCount() {
	    int count = 0;

	    try {
	        // Call getConnection() method
	        con = redeemMe.connection.ConnectionManager.getConnection();
	        
	        // Create statement
	        stmt = con.createStatement();
	        String sql = "SELECT COUNT(SupplierId) AS total_count FROM supplier";
	        
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
