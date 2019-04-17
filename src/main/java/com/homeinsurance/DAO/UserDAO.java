package com.homeinsurance.DAO;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import homeinsurance.model.User;

public class UserDAO {
	
	public Integer insertUser(User user) throws SQLException, ClassNotFoundException, IOException{
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// Assign query string to a variable
		String iString = "insert into users (user_name, password, admin_role) values (?,?,?)";
		
		int ID = -1;
	    String[] COL = {"user_id"};

		// Create OracleConnection class instance
		OracleConnection mysql = new OracleConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database
			conn = mysql.getConnection();
                        // If the connection fails the application won't make it to this point
			stmt = conn.prepareStatement(iString, COL);
			
			System.out.println("Connected to database.");

			// Run query and assign to ResultSet
			
	        stmt.setString(1, user.getUserName());
	        stmt.setString(2, user.getPassword());
	        stmt.setString(3, user.getAdminRole());	      
	        
	        stmt.executeUpdate();
	        
	        rs = stmt.getGeneratedKeys();
	        if(rs != null && rs.next()) {
	            ID = rs.getInt(1);
	            user.setUserId(ID);
	            System.out.println("User ID # " + ID + " has been set");
	        }	            	

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

	public List<User> getAllUsers() throws SQLException {
		
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		User u = null;
		List<User> userList = null;
		// Assign query string to a variable
		String qString = "select * from users";
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
			rs = stmt.executeQuery(qString);
                        //Create list to hold User objects
			userList = new ArrayList<User>();
			// Read the ResultSet
			while (rs.next()) {
				// Each iteration creates a new user
				u = new User(qString, qString, qString);
				// Assign columns/fields to related fields in the User object
                                // 1,2 and 3 represent column numbers/positions
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setAdminRole(rs.getString(4));

				// Add the user to the list
				userList.add(u);
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
		return userList;
	} // End of getAllUsers method

	public User getUserByName(String userName) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User u = null;
		
		// Assign query string to variable
		String qString = "select * from users where user_name = ?";
		
		// Create MySqlConnection class instance
		OracleConnection oracle = new OracleConnection();
		// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(qString);
			
			// Set query parameters (?)
			stmt.setString(1, userName);
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
			System.out.println(e.getStackTrace());
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
	}  // End of getUserByName() method
	
	//****************getUserById() method*****************

		public User getUserById(int userId) throws ClassNotFoundException, IOException, SQLException {
			// Declare variables
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			User u = null;
			
			// Assign query string to variable
			String qString = "select * from users where user_id = ?";
			
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
			String deleteString = "delete from users where user_id = ?";
			
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

