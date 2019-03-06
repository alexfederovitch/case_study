package homeinsurance.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import homeinsurance.model.Quote;

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
			quoteList = new ArrayList<Quote>();
			// Read the ResultSet
			while (rs.next()) {
				// Each iteration creates a new user
				q = new Quote(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
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
		return quoteList;
	} // End of getAllQuotes method

}
