package homeinsurance.model;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.homeinsurance.DAO.HomeownerDAO;
import com.homeinsurance.DAO.LocationDAO;
import com.homeinsurance.DAO.PropertyDAO;
import com.homeinsurance.DAO.UserDAO;

public class JDBCMain {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		
//		UserDAO insert_u_dao = new UserDAO();
//		User u = new User("storm12","Pass47439",null);
//        insert_u_dao.insertUser(u);
		
//		UserDAO u_dao = new UserDAO();
//		List<User> userList = u_dao.getAllUsers();
//		for (User u : userList) {
//			System.out.printf("User ID %d: %s\n", u.getUserId(),u.getUserName());
//		}

		HomeownerDAO h_dao = new HomeownerDAO();
		List<Homeowner> homeownerList = h_dao.getAllHomeowners();
//		for (Homeowner h : homeownerList) {
//			String bool1 = h.isRetiredStatus();
//			String data = bool1.contains("0") ? "No" : "Yes";
//			System.out.printf("User ID: %d Name: %s %s DOB: %s Retired Status: %s SSN: %s email: %s\n", h.getUserId(), h.getFirstName(), h.getLastName(), h.getDob(), h.getSsn(), h.getEmail());
//		}
		
//		HomeownerDAO insert_h_dao = new HomeownerDAO();
//		int year = 1975;
//		int month = 7;
//		int day = 17;
//		Date date = new Date(year, month, day);
//		Homeowner h = new Homeowner();
//		h.setUserId(2);
//		h.setFirstName("Tom");
//		h.setLastName("Jones");
//		h.setDob(date);
//		h.setRetiredStatus("0");
//		h.setSsn("572947335");
//		h.setEmail("alex@pere.com");
//		insert_h_dao.insertHomeowner(h);
		
//		PropertyDAO i_p_dao = new PropertyDAO();
//		Property property = new Property();
//		property.setLocationId(85);
//		property.setMarketValue(50000);
//		property.setYearBuilt(1980);
//		property.setSquareFootage(1200);
//		property.setDwellingType("2");
//		property.setRoofMaterial("wood");
//		property.setGarageType("attached");
//		property.setFullBaths(2);
//		property.setHalfBaths(2);
//		property.setPool(0);
//		i_p_dao.registerProperty(property);
		
//		LocationDAO l_dao = new LocationDAO();
//		List<Location> LocationList = l_dao.getAllLocations();
//		for (Location l : LocationList) {
//			System.out.printf("Location ID: %d User ID: %d Residence Type: %s", l.getLocationId(), l.getUserId(), l.getResidenceType());
//		}
		
//		LocationDAO insert_l_dao = new LocationDAO();
//		Location l = new Location(0, 2, "House", "1418 Kenforest Drive", null, "Missouri City", "Texas", "77489", "Yes");
//		insert_l_dao.insertLocation(l);

	}

}
