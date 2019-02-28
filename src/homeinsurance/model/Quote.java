package homeinsurance.model;

public class Quote {
	
	private int quoteId;
	private int locationId;
	private float montlyPremium;
	private float dwellingCoverage;
	private float detatchedStructures;
	private float personalProperty;
	private float addLivingExp;
	private float medicalExpenses;
	private float deductible;
	
	public Quote(int quoteId, int locationId, float montlyPremium, float dwellingCoverage, float detatchedStructures,
			float personalProperty, float addLivingExp, float medicalExpenses, float deductible) {
		super();
		this.quoteId = quoteId;
		this.locationId = locationId;
		this.montlyPremium = montlyPremium;
		this.dwellingCoverage = dwellingCoverage;
		this.detatchedStructures = detatchedStructures;
		this.personalProperty = personalProperty;
		this.addLivingExp = addLivingExp;
		this.medicalExpenses = medicalExpenses;
		this.deductible = deductible;
	}
	
	public int getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public float getMontlyPremium() {
		return montlyPremium;
	}
	public void setMontlyPremium(float montlyPremium) {
		this.montlyPremium = montlyPremium;
	}
	public float getDwellingCoverage() {
		return dwellingCoverage;
	}
	public void setDwellingCoverage(float dwellingCoverage) {
		this.dwellingCoverage = dwellingCoverage;
	}
	public float getDetatchedStructures() {
		return detatchedStructures;
	}
	public void setDetatchedStructures(float detatchedStructures) {
		this.detatchedStructures = detatchedStructures;
	}
	public float getPersonalProperty() {
		return personalProperty;
	}
	public void setPersonalProperty(float personalProperty) {
		this.personalProperty = personalProperty;
	}
	public float getAddLivingExp() {
		return addLivingExp;
	}
	public void setAddLivingExp(float addLivingExp) {
		this.addLivingExp = addLivingExp;
	}
	public float getMedicalExpenses() {
		return medicalExpenses;
	}
	public void setMedicalExpenses(float medicalExpenses) {
		this.medicalExpenses = medicalExpenses;
	}
	public float getDeductible() {
		return deductible;
	}
	public void setDeductible(float deductible) {
		this.deductible = deductible;
	}
	
	

}
