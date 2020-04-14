package com.cts.command;

public class ApplyLoanCommand {
	
	private Integer loanId;
	private String userName;
	private String applicationNumber;
	private Double loanAmount;
	private String loanApplicationDate;
	private Double acerOfLand;
	private Double landValue;
	private Double revenueGenerated;
	private String propertyCountry;
	private String propertyState;
	private Integer loanStatus;
	
	
	
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	public Integer getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(Integer loanStatus) {
		this.loanStatus = loanStatus;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getApplicationNumber() {
		return applicationNumber;
	}
	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getLoanApplicationDate() {
		return loanApplicationDate;
	}
	public void setLoanApplicationDate(String loanApplicationDate) {
		this.loanApplicationDate = loanApplicationDate;
	}
	public Double getAcerOfLand() {
		return acerOfLand;
	}
	public void setAcerOfLand(Double acerOfLand) {
		this.acerOfLand = acerOfLand;
	}
	public Double getLandValue() {
		return landValue;
	}
	public void setLandValue(Double landValue) {
		this.landValue = landValue;
	}
	public Double getRevenueGenerated() {
		return revenueGenerated;
	}
	public void setRevenueGenerated(Double revenueGenerated) {
		this.revenueGenerated = revenueGenerated;
	}
	public String getPropertyCountry() {
		return propertyCountry;
	}
	public void setPropertyCountry(String propertyCountry) {
		this.propertyCountry = propertyCountry;
	}
	public String getPropertyState() {
		return propertyState;
	}
	public void setPropertyState(String propertyState) {
		this.propertyState = propertyState;
	}
	
	
	
	

}
