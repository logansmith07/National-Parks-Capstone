package com.techelevator.npgeek.model.survey;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
	
	private Long surveyId;
	
	@NotBlank(message="Park name is required")
	private String parkCode;
	
	@NotBlank(message="Email is required")
	@Email(message="Email must be a valid email address")
	private String email;
	
	@NotBlank(message="Verify email address is required")
	private String verifyEmail;
	
	@NotBlank(message="State of residence is required")
	private String residenceState;
	
	@NotBlank(message="Activity level is required")
	private String activityLevel;
	
	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVerifyEmail() {
		return verifyEmail;
	}

	public void setVerifyEmail(String verifyEmail) {
		this.verifyEmail = verifyEmail;
	}

	public String getResidenceState() {
		return residenceState;
	}

	public void setResidenceState(String residenceState) {
		this.residenceState = residenceState;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
}
