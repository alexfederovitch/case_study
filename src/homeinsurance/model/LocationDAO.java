package homeinsurance.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO {
	
	public List<Location> getAllLocatioins() throws SQLException {
		
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Location l = null;
		List<Location> locationList = null;
		// Assign query string to a variable
		String pString = "select * from users";
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

}
