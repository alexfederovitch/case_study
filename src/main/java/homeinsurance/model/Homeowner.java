package homeinsurance.model;
import java.sql.Date; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Homeowner {
	
	private int userId;
	private String firstName;
	private String lastName;
	private Date dob;
	private String retiredStatus;
	private String ssn;
	private String email;
	
	public Homeowner () {
		
	};
	
	public Homeowner(int userId, String firstName, String lastName, Date dob,  String retiredStatus, String ssn,
			String email) throws ParseException {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.retiredStatus = retiredStatus;
		this.ssn = ssn;
		this.email = email;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String isRetiredStatus() {
		return retiredStatus;
	}
	public void setRetiredStatus(String string) {
		this.retiredStatus = string;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
