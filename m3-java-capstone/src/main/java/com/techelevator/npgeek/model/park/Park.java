package com.techelevator.npgeek.model.park;

public class Park {
	
	private String parkCode;
	private String parkName;
	private String state;
	private int acreage;
	private int elevation;
	private float milesOfTrail;
	private int numberOfCampsites;
	private String climate;
	private int yearFounded;
	private int annualVisitorCount;
	private String inspirationalQuote;
	private String quoteSource;
	private String description;
	private int entryFee;
	private int numberAnimalSpecies;
	private int numberSurveys;
	
	
	public int getNumberSurveys() {
		return numberSurveys;
	}
	
	public void setNumberSurveys(int numberSurveys) {
		this.numberSurveys = numberSurveys;
	}
	
	
	public String getParkCode() {
		return parkCode.toLowerCase();
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAcreage() {
		return acreage;
	}
	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}
	public int getElevation() {
		return elevation;
	}
	public void setElevation(int elevation) {
		this.elevation = elevation;
	}
	public float getMilesOfTrail() {
		return milesOfTrail;
	}
	public void setMilesOfTrail(float milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}
	public int getNumberOfCampsites() {
		return numberOfCampsites;
	}
	public void setNumberOfCampsites(int numberOfCampsites) {
		this.numberOfCampsites = numberOfCampsites;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public int getYearFounded() {
		return yearFounded;
	}
	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}
	public int getAnnualVisitorCount() {
		return annualVisitorCount;
	}
	public void setAnnualVisitorCount(int annualVisitorCount) {
		this.annualVisitorCount = annualVisitorCount;
	}
	public String getInspirationalQuote() {
		return inspirationalQuote;
	}
	public void setInspirationalQuote(String inspirationalQuote) {
		this.inspirationalQuote = inspirationalQuote;
	}
	public String getQuoteSource() {
		return quoteSource;
	}
	public void setQuoteSource(String quoteSource) {
		this.quoteSource = quoteSource;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getEntryFee() {
		return entryFee;
	}
	public void setEntryFee(int entryFee) {
		this.entryFee = entryFee;
	}
	public int getNumberAnimalSpecies() {
		return numberAnimalSpecies;
	}
	public void setNumberAnimalSpecies(int numberAnimalSpecies) {
		this.numberAnimalSpecies = numberAnimalSpecies;
	}
	
	
	

}
