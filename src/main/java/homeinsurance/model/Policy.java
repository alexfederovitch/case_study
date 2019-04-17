package homeinsurance.model;
import java.util.*;

public class Policy {
	
	private int policyId;
	private int quoteId;
	private int userId;
	private int term;
	private Date effectiveDate;
	private Date endDate;
	private String policyStatus;
	
	public Policy() {};
	
	public Policy(int policyId, int quoteId, int userId, int term, Date effectiveDate, Date endDate,
			String policyStatus) {
		super();
		this.policyId = policyId;
		this.quoteId = quoteId;
		this.userId = userId;
		this.term = term;
		this.effectiveDate = effectiveDate;
		this.endDate = endDate;
		this.policyStatus = policyStatus;
	}
	
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public int getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	
	

}
