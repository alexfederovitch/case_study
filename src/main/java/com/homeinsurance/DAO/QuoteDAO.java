package com.homeinsurance.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import homeinsurance.model.Quote;
import homeinsurance.model.User;

public class QuoteDAO {

	public List<Quote> getAllQuotes() throws SQLException {

		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Quote q = null;
		List<Quote> quoteList = null;
		// Assign query string to a variable
		String qString = "select * from quotes";
		// Create MySqlConnection class instance
		OracleConnection mysql = new OracleConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database
			conn = mysql.getConnection();
			// If the connection fails the application won't make it to this point
			System.out.println("Connected to database.");
			// Create Statement instance/object
			stmt = conn.createStatement();
			// Run query and assign to ResultSet
			rs = stmt.executeQuery(qString);
			// Create list to hold User objects
			quoteList = new ArrayList<Quote>();
			// Read the ResultSet
			while (rs.next()) {
				// Each iteration creates a new user
				q = new Quote(0, 0, 0, 0, 0, 0, 0, 0, 0);
				// Assign columns/fields to related fields in the User object
				// 1,2 and 3 represent column numbers/positions
				q.setQuoteId(rs.getInt(1));
				q.setLocationId(rs.getInt(2));
				q.setMonthlyPremium(rs.getFloat(3));
				q.setDwellingCoverage(rs.getFloat(4));
				q.setDetatchedStructures(rs.getFloat(5));
				q.setPersonalProperty(rs.getFloat(6));
				q.setAddLivingExp(rs.getFloat(7));
				q.setMedicalExpenses(rs.getFloat(8));
				q.setDeductible(rs.getFloat(9));

				// Add the quote to the list
				quoteList.add(q);
				// Repeat until rs.next() returns false (i.e., end of ResultSet)
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
		return quoteList;
	} // End of getAllQuotes method

	public int createQuote(Quote quote) throws SQLException {
		// TODO Auto-generated method stub
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign query string to a variable
		String iString = "insert into quotes (location_id, monthly_premium, dwelling_coverage, detached_structures, personal_property, add_living_exp, medical_expenses, deductible) values (?,?,?,?,?,?,?,?)";

		int ID = -1;
		String[] COL = { "quote_id" };

		// Create OracleConnection class instance
		OracleConnection mysql = new OracleConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database
			conn = mysql.getConnection();
			// If the connection fails the application won't make it to this point
			stmt = conn.prepareStatement(iString, COL);

			System.out.println("Connected to database.");

			stmt.setInt(1, quote.getLocationId());
			stmt.setFloat(2, quote.getMonthlyPremium());
			stmt.setFloat(3, quote.getDwellingCoverage());
			stmt.setFloat(4, quote.getDetatchedStructures());
			stmt.setFloat(5, quote.getPersonalProperty());
			stmt.setFloat(6, quote.getAddLivingExp());
			stmt.setFloat(7, quote.getMedicalExpenses());
			stmt.setFloat(8, quote.getDeductible());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
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

	public Quote getQuoteById(int quoteId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Quote q = null;

		// Assign query string to variable
		String qString = "select * from quotes where quote_id = ?";

		// Create MySqlConnection class instance
		OracleConnection oracle = new OracleConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setInt(1, quoteId); // user_id if from String parameter passed to method

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				
				q = new Quote();
				// Assign columns/fields to related fields in the User object
				// 1,2 and 3 represent column numbers/positions
				q.setQuoteId(rs.getInt(1));
				q.setLocationId(rs.getInt(2));
				q.setMonthlyPremium(rs.getFloat(3));
				q.setDwellingCoverage(rs.getFloat(4));
				q.setDetatchedStructures(rs.getFloat(5));
				q.setPersonalProperty(rs.getFloat(6));
				q.setAddLivingExp(rs.getFloat(7));
				q.setMedicalExpenses(rs.getFloat(8));
				q.setDeductible(rs.getFloat(9));
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
		return q;
	} // End of getUserById() method

}
