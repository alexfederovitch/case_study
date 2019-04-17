//package com.homeinsurance.BO;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//import com.perscholas.crud.dao.UserDAO;
//import com.perscholas.crud.models.User;
//
//public class UserBO {
//	UserDAO u_dao;
//	
//	public UserBO() {
//		u_dao = new UserDAO();
//	}
//	
//	public Integer registerUser(User user) 
//			throws ClassNotFoundException, SQLException, IOException {
//		Integer ID = u_dao.registerUser(user);
//		return ID;
//	}
//	
//	public User getUserByName(String userName) 
//			throws ClassNotFoundException, IOException, SQLException {
//		User user = u_dao.getUserByName(userName);
//		return user;
//	}
//	
//	public User getUserById(int userId) 
//			throws ClassNotFoundException, IOException, SQLException {
//		User user = u_dao.getUserById(userId);
//		return user;
//	}
//	
//	public List<User> getAllUsers() 
//			throws SQLException {
//		List<User> allUsers = u_dao.getAllUsers();
//		return allUsers;
//	}
//	
//	public Boolean removeUser(int userId) 
//			throws IOException, SQLException {
//		Boolean confirmRemove = u_dao.removeUser(userId);
//		return confirmRemove;
//	}
//	
//	public Boolean updateUser(User user) 
//			throws IOException, SQLException, ClassNotFoundException {
//		Boolean confirmUpdate = u_dao.updateUser(user);
//		return confirmUpdate;
//	}
//}
