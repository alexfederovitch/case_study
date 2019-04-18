package com.homeinsurance.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import homeinsurance.model.Policy;
import homeinsurance.model.Quote;
import homeinsurance.model.User;

public class PolicyDAO {
	
	public Policy createPolicy(Policy policy) throws SQLException {
		// TODO Auto-generated method stub
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign query string to a variable
		String iString = "insert into policies (policy_id, quote_id, user_id, effective_date, end_date, term, policy_status) values (?,?,?,?,?,?,?)";


		// Create OracleConnection class instance
		OracleConnection mysql = new OracleConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database
			conn = mysql.getConnection();
			// If the connection fails the application won't make it to this point
			stmt = conn.prepareStatement(iString);

			System.out.println("Connected to database.");

			stmt.setInt(1, policy.getPolicyId());
			stmt.setInt(2, policy.getQuoteId());
			stmt.setInt(3, policy.getUserId());
			stmt.setDate(4, (Date) policy.getEffectiveDate());
			stmt.setDate(5, (Date) policy.getEndDate());
			stmt.setInt(6, policy.getTerm());
			stmt.setString(7, policy.getPolicyStatus());

			stmt.executeUpdate();

//			rs = stmt.getGeneratedKeys();
//			if (rs != null && rs.next()) {
//				ID = rs.getInt(1);
//			}
//			System.out.print(ID);
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
		return policy;
	}
	
	public Policy getPolicyByUserId(User userId) throws SQLException {
		
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Policy p = null;
		List<Policy> policies = null;
		// Assign query string to a variable
		String pString = "select * from policies where user_id = ?";
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

			// Read the ResultSet
			while (rs.next()) {
				// Each iteration creates a new user
				p = new Policy();
				// Assign columns/fields to related fields in the User object
                                // 1,2 and 3 represent column numbers/positions
				p.setPolicyId(rs.getInt(1));
				p.setQuoteId(rs.getInt(2));
				p.setUserId(rs.getInt(3));
				p.setEffectiveDate(rs.getDate(4));
				p.setEndDate(rs.getDate(5));
				p.setTerm(rs.getInt(6));
				p.setPolicyStatus(rs.getString(7));

				// Add the policy to the list
				policies.add(p);
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
		return p;
	} // End of getAllPolicies method
	
	public List<Policy> getAllPolicies() throws SQLException {
		
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Policy p = null;
		List<Policy> policyList = null;
		// Assign query string to a variable
		String pString = "select * from policies";
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
			policyList = new ArrayList<Policy>();
			// Read the ResultSet
			while (rs.next()) {
				// Each iteration creates a new user
				p = new Policy();
				// Assign columns/fields to related fields in the User object
                                // 1,2 and 3 represent column numbers/positions
//				p.setPolicyId(rs.getInt(1));
//				p.setQuoteId(rs.getInt(2));
//				p.setUserId(rs.getInt(3));
//				p.setTerm(rs.getInt(4));
//				p.setEffectiveDate(rs.getDate(5));
//				p.setEndDate(rs.getDate(6));
//				p.setPolicyStatus(rs.getString(7));
				
				p.setPolicyId(rs.getInt(1));
				p.setQuoteId(rs.getInt(2));
				p.setUserId(rs.getInt(3));
				p.setEffectiveDate(rs.getDate(4));
				p.setEndDate(rs.getDate(5));
				p.setTerm(rs.getInt(6));
				p.setPolicyStatus(rs.getString(7));

				// Add the policy to the list
				policyList.add(p);
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
		return policyList;
	} // End of getAllPolicies method
	
	public Policy getPolicyById(int policyId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Policy p = null;

		// Assign query string to variable
		String qString = "select * from policies where policy_id = ?";

		// Create MySqlConnection class instance
		OracleConnection oracle = new OracleConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setInt(1, policyId); // user_id if from String parameter passed to method

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				
				p = new Policy();
				// Assign columns/fields to related fields in the User object
				// 1,2 and 3 represent column numbers/positions
				p.setPolicyId(rs.getInt(1));
				p.setQuoteId(rs.getInt(2));
				p.setUserId(rs.getInt(3));
				p.setEffectiveDate(rs.getDate(4));
				p.setEndDate(rs.getDate(5));
				p.setTerm(rs.getInt(6));
				p.setPolicyStatus(rs.getString(7));
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
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
		return p;
	} // End of getUserById() method

}
