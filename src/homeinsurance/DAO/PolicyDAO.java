package homeinsurance.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import homeinsurance.model.Policy;

public class PolicyDAO {
	
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
				p = new Policy(0, 0, 0, 0, null, null, pString);
				// Assign columns/fields to related fields in the User object
                                // 1,2 and 3 represent column numbers/positions
				p.setPolicyId(rs.getInt(1));
				p.setQuoteId(rs.getInt(2));
				p.setUserId(rs.getInt(3));
				p.setTerm(rs.getInt(4));
				p.setEffectiveDate(rs.getDate(5));
				p.setEndDate(rs.getDate(6));
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

}
