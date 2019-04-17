package homeinsurance.model;

public class User {
	
	private Integer userId;
	private String userName;
	private String password;
	private String adminRole;
	
	//Default constructor
	public User() {
		
	}
	
	//Parameterized constructors
	public User(String userName, String password, String adminRole) {
		this.userName = userName;
		this.password = password;
		this.adminRole = adminRole;
	}
	
	public User(Integer userId, String userName, String password, String adminRole) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.adminRole = adminRole;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}

}
