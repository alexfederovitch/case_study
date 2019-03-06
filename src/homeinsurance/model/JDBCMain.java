package homeinsurance.model;

import java.sql.SQLException;
import java.util.List;

import homeinsurance.DAO.HomeownerDAO;

public class JDBCMain {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
//		UserDAO u_dao = new UserDAO();
//		List<User> userList = u_dao.getAllUsers();
//		for (User u : userList) {
//			System.out.printf("User ID %d: %s\n", u.getUserId(),u.getUserName());
//		}
		
		
		HomeownerDAO h_dao = new HomeownerDAO();
		List<Homeowner> homeownerList = h_dao.getAllHomeowners();
		for (Homeowner h : homeownerList) {
			String bool1 = h.isRetiredStatus();
			String data = bool1.contains("0") ? "No" : "Yes";
			System.out.printf("User ID: %d Name: %s %s DOB: %s Retired Status: %s SSN: %s email: %s\n", h.getUserId(), h.getFirstName(), h.getLastName(), h.getDob(), data, h.getSsn(), h.getEmail());
		}

	}

}
