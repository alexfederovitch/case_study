package homeinsurance.model;
import java.util.*;

public class Homeowner {
	
	private int userId;
	private String firstName;
	private String lastName;
	private Date dob;
	private boolean retiredStatus;
	private String ssn;
	private String email;
	
	public Homeowner(int userId, String firstName, String lastName, Date dob, boolean retiredStatus, String ssn,
			String email) {
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
	public boolean isRetiredStatus() {
		return retiredStatus;
	}
	public void setRetiredStatus(boolean retiredStatus) {
		this.retiredStatus = retiredStatus;
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
