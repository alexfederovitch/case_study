package homeinsurance.model;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import homeinsurance.DAO.HomeownerDAO;
import homeinsurance.DAO.LocationDAO;
import homeinsurance.DAO.UserDAO;

public class JDBCMain {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
//		UserDAO insert_u_dao = new UserDAO();
//		User u = new User(0, "storm3","Pass@123","Yes");
//        insert_u_dao.insertUser(u);
		
//		UserDAO u_dao = new UserDAO();
//		List<User> userList = u_dao.getAllUsers();
//		for (User u : userList) {
//			System.out.printf("User ID %d: %s\n", u.getUserId(),u.getUserName());
//		}
//		
//		HomeownerDAO h_dao = new HomeownerDAO();
//		List<Homeowner> homeownerList = h_dao.getAllHomeowners();
//		for (Homeowner h : homeownerList) {
//			String bool1 = h.isRetiredStatus();
//			String data = bool1.contains("0") ? "No" : "Yes";
//			System.out.printf("User ID: %d Name: %s %s DOB: %s Retired Status: %s SSN: %s email: %s\n", h.getUserId(), h.getFirstName(), h.getLastName(), h.getDob(), data, h.getSsn(), h.getEmail());
//		}
		
//		HomeownerDAO insert_h_dao = new HomeownerDAO();
//		Date dt = new Date(0);
//		Homeowner h = new Homeowner(2, "Alex", "Federovitch", dt, "1", "334852929", "alexf@pretendmail.com");
//		insert_h_dao.insertHomeowner(h);
		
		LocationDAO l_dao = new LocationDAO();
		List<Location> LocationList = l_dao.getAllLocations();
		for (Location l : LocationList) {
			System.out.printf("Location ID: %d User ID: %d Residence Type: %s", l.getLocationId(), l.getUserId(), l.getResidenceType());
		}
		
		LocationDAO insert_l_dao = new LocationDAO();
		Location l = new Location(0, 2, "House", "1418 Kenforest Drive", null, "Missouri City", "Texas", "77489", "Yes");
		insert_l_dao.insertLocation(l);

	}

}
