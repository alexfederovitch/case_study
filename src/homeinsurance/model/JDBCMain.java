package homeinsurance.model;

import java.sql.SQLException;
import java.util.List;

public class JDBCMain {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		UserDAO u_dao = new UserDAO();
		List<User> userList = u_dao.getAllUsers();
		for (User u : userList) {
			System.out.printf("User ID %d: %s\n", u.getUserId(),u.getUserName());
		}
		
		HomeownerDAO h_dao = new HomeownerDAO();
		List<Homeowner> homeownerList = h_dao.getAllHomeowners();
		for (Homeowner h : homeownerList) {
//			System.out.printf("User ID %d: %s %s %s\n", h.getUserId(), h.getFirstName(), h.getLastName());
		}

	}

}
