package homeinsurance.DAO;

import java.io.IOException;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import homeinsurance.model.Homeowner;

public class HomeownerDAO {
	
	public List<Homeowner> getAllHomeowners() throws SQLException {
		
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Homeowner h = null;

		java.sql.Date Date = null;
		List<Homeowner> homeownerList = null;
		// Assign query string to a variable
		String pString = "select * from homeowners";
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
			homeownerList = new ArrayList<Homeowner>();
			// Read the ResultSet
			while (rs.next()) {
				// Each iteration creates a new user
				h = new Homeowner(0, pString, pString, Date, pString, pString, pString);
				// Assign columns/fields to related fields in the User object
                                // 1,2 and 3 represent column numbers/positions
				h.setUserId(rs.getInt(1));
				h.setFirstName(rs.getString(2));
				h.setLastName(rs.getString(3));
				h.setDob(rs.getDate(4));
				h.setRetiredStatus(rs.getString(5));
				h.setSsn(rs.getString(7));
				h.setEmail(rs.getString(8));

				// Add the policy to the list
				homeownerList.add(h);
				// Repeat until rs.next() returns false (i.e., end of ResultSet)
			}
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
			e.printStackTrace();
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
		return homeownerList;
	} // End of getAllHomeowners method

}
