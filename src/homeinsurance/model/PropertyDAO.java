package homeinsurance.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PropertyDAO {
	
	public List<Property> getAllProperties() throws SQLException {
		
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Property p = null;
		List<Property> propList = null;
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
			propList = new ArrayList<Property>();
			// Read the ResultSet
			while (rs.next()) {
				// Each iteration creates a new user
				p = new Property(0, 0, 0, 0, pString, pString, pString, 0, 0, false);
				// Assign columns/fields to related fields in the User object
                                // 1,2 and 3 represent column numbers/positions
				p.setLocationId(rs.getInt(1));
				p.setMarketValue(rs.getInt(2));
				p.setYearBuilt(rs.getInt(3));
				p.setSquareFootage(rs.getInt(4));
				p.setDwellingType(rs.getString(5));
				p.setRoofMaterial(rs.getString(6));
				p.setGarageType(rs.getString(7));
				p.setFullBaths(rs.getInt(8));
				p.setHalfBaths(rs.getInt(9));
				p.setPool(rs.getBoolean(10));

				propList.add(p);
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
		return propList;
	} // End of getAllProperties method

}
