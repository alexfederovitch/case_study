package homeinsurance.model;

import java.sql.SQLException;
import java.util.List;

public class JDBCMain {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		UserDAO u_dao = new UserDAO();
		List<User> userList = u_dao.getAllUsers();
//		for (User u : userList) {
//			System.out.printf("User ID %d: %s\n", u.getUserId(),u.getUserName());
//		}

	}

}
