package com.homeinsurance.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import homeinsurance.model.Location;
import homeinsurance.model.User;

public class LocationDAO {
	
	public Integer insertLocation(Location location) throws SQLException, ClassNotFoundException, IOException{
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// Assign query string to a variable
		String iString = "insert into locations (user_id, residence_type, address_line_1, address_line_2, city, location_state, zip_code, residence_use) values (?,?,?,?,?,?,?,?)";
		
		int ID = -1;
	    String[] COL = {"location_id"};

		// Create OracleConnection class instance
		OracleConnection mysql = new OracleConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database
			conn = mysql.getConnection();
                        // If the connection fails the application won't make it to this point
			stmt = conn.prepareStatement(iString, COL);
			
			System.out.println("Connected to database.");
		
			stmt.setInt(1, location.getUserId());
			stmt.setString(2, location.getResidenceType());
			stmt.setString(3, location.getAddressLine1());
			stmt.setString(4, location.getAddressLine2());
			stmt.setString(5, location.getCity());
			stmt.setString(6, location.getLocationState());
			stmt.setString(7, location.getZipCode());
			stmt.setString(8, location.getResidenceUse());
	        
	        stmt.executeUpdate();
	        
	        rs = stmt.getGeneratedKeys();
	        if(rs != null && rs.next()) {
	            ID = rs.getInt(1);
	        }	            	
	        System.out.print(ID);
	        } catch (ClassNotFoundException | IOException | SQLException e) {
	        e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}			
		}
		return ID;
	}
	
	public List<Location> getAllLocations() throws SQLException {
		
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Location l = null;
		List<Location> locationList = null;
		// Assign query string to a variable
		String pString = "select * from locations";
		// Create MySqlConnection class instance
		OracleConnection mysql = new OracleConnection();
		// Begin try/catch block to query the database
		try
		{
			// Connect to database
			conn = mysql.getConnection();
                        // If the connection fails the application won't make it to this point
			System.out.println("Connected to database.");
                        // Create Statement instance/object
			stmt = conn.createStatement();
			// Run query and assign to ResultSet
			rs = stmt.executeQuery(pString);
                        //Create list to hold User objects
			locationList = new ArrayList<Location>();
			// Read the ResultSet
			while (rs.next()) {
				// Each iteration creates a new user
				l = new Location(0, 0, pString, pString, pString, pString, pString, pString, pString);
				// Assign columns/fields to related fields in the User object
                                // 1,2 and 3 represent column numbers/positions
				l.setLocationId(rs.getInt(1));
				l.setUserId(rs.getInt(2));
				l.setResidenceType(rs.getString(3));
				l.setAddressLine1(rs.getString(4));
				l.setAddressLine2(rs.getString(5));
				l.setCity(rs.getString(6));
				l.setLocationState(rs.getString(7));
				l.setZipCode(rs.getString(8));
				l.setResidenceUse(rs.getString(9));

				// Add the policy to the list
				locationList.add(l);
				// Repeat until rs.next() returns false (i.e., end of ResultSet)
			}
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		}
		finally
		{
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return locationList;
	} // End of getAllLocations method
	
	//****************getUserById() method*****************

			public User getLocationById(int userId) throws ClassNotFoundException, IOException, SQLException {
				// Declare variables
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;
				User u = null;
				
				// Assign query string to variable
				String qString = "select * from locations where user_id = ?";
				
				// Create MySqlConnection class instance
				OracleConnection oracle = new OracleConnection();
				
				// Begin try/catch block to query the database
				try
				{
					// Connect to database and assign query string to PreparedStatement object
					conn = oracle.getConnection();
					stmt = conn.prepareStatement(qString);
					
					// Set query parameters (?)
					stmt.setInt(1, userId); // user_id if from String parameter passed to method
					
					// Run query and assign to ResultSet
					rs = stmt.executeQuery();
					
					// Retrieve ResultSet and assign to new User
					if (rs.next()) {
						u = new User();
						u.setUserId(rs.getInt(1));
						u.setUserName(rs.getString(2));
						u.setPassword(rs.getString(3));
						u.setAdminRole(rs.getString(4));
					}
				}
				catch (ClassNotFoundException | IOException | SQLException e)
				{
					System.out.println("Error: " + e.getMessage());
					e.getStackTrace();
				}
				finally
				{
					if (rs != null) {
						rs.close();
					}
					if (stmt != null) {
						stmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				}
				return u;
			} // End of getUserById() method
			
			//****************removeUser() method (i.e., delete)*****************
			
			public Boolean removeUser(int userId) throws IOException, SQLException {
				// Declare variables
				Connection conn = null;
				PreparedStatement stmt = null;
				Integer updateResult = null;
				
				// Assign delete string to variable
				String deleteString = "delete from locations where user_id = ?";
				
				// Create MySqlConnection class instance
				OracleConnection oracle = new OracleConnection();
				// Begin try/catch block to query the database
				try
				{
					// Connect to database and assign query string to PreparedStatement object
					conn = oracle.getConnection();
					stmt = conn.prepareStatement(deleteString);
					
					// Set query parameters (?)
					stmt.setInt(1, userId);
					// Run query and assign to ResultSet
					updateResult = stmt.executeUpdate();
				}
				catch (ClassNotFoundException | SQLException e)
				{
					System.out.println("Error: " + e.getMessage());
				}
				finally
				{
					if (stmt != null) {
						stmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				}
				if (updateResult > 0) {
					return true;
				}
				return false;
			} // End of removeUser() method
			
			//****************updateUser() method*****************
			
			public Boolean updateUser(User u) throws SQLException, ClassNotFoundException, IOException {
				// Declare variables
				Connection conn = null;
				PreparedStatement stmt = null;
				Integer updateResult = null;
				
				// Assign update string to variable
				String updateString = "update users "
						+ "set user_name = ?, password = ?, location_city = ?, location_state = ? "
						+ "where user_id = ?";
				
				// Create MySqlConnection class instance
				OracleConnection oracle = new OracleConnection();
				// Begin try/catch block to query the database
				try
				{
					// Connect to database and assign query string to PreparedStatement object
					conn = oracle.getConnection();
					stmt = conn.prepareStatement(updateString);
					
					// Set query parameters (?)
					stmt.setString(1, u.getUserName());
					stmt.setString(2, u.getPassword());
					stmt.setString(3,  u.getAdminRole());
					
					stmt.setInt(4, u.getUserId());
					// Run query and assign to ResultSet
					updateResult = stmt.executeUpdate();
				}
				catch (ClassNotFoundException | SQLException e)
				{
					System.out.println("Error: " + e.getMessage());
				}
				finally
				{
					if (stmt != null) {
						stmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				}
				if (updateResult > 0) {
					return true;
				}
				return false;
			} // End of updateUser() method

}
