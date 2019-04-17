package com.perscholas.homeinsurance.homeinsurance_case_study;

import homeinsurance.model.User;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.homeinsurance.DAO.UserDAO;



public class UserDAOTest {
	
	private static User user;
	private static UserDAO ud;
	private static List<User> actual, expected;
	
	@BeforeClass
	public static void setUp() {
		ud = new UserDAO();
	}
	
//	@Test
//	public void testgetAllUsers() throws SQLException {
//		UserDAO testcases = new UserDAO();
//		List<User> userList = testcases.getAllUsers();
//		assertNotNull("List shouldn't be null.",userList);
//		System.out.println(userList);
//	}
	
	@Test
	public void testRegister() throws ClassNotFoundException, SQLException, IOException
	{
		User user = new User();
		user.setUserName("TestAlex");
		user.setPassword("TestPass");
		user.setAdminRole("admin");
		
		assertEquals("TestAlex", user.getUserName());
		assertEquals("TestPass", user.getPassword());
		assertEquals("admin", user.getAdminRole());
		
		int id = ud.insertUser(user);
		user.setUserId(id);
		assertEquals(id, user.getUserId());
	}
	
	
}//end bracket
