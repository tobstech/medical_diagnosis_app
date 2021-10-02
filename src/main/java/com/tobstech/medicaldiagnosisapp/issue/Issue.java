package com.tobstech.medicaldiagnosisapp.issue;

//issue parameter definition
public class Issue {

	private int issueId;
	private String issueName;
	private Double accuracy;
	private String icd;
	private String icdName;
	private String profName;
	private int ranking;
	
	public Issue() {}

	public Issue(int issueId, String issueName, Double accuracy, String icd, String icdName, String profName,
			int ranking) {
		super();
		this.issueId = issueId;
		this.issueName = issueName;
		this.accuracy = accuracy;
		this.icd = icd;
		this.icdName = icdName;
		this.profName = profName;
		this.ranking = ranking;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public Double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(Double accuracy) {
		this.accuracy = accuracy;
	}

	public String getIcd() {
		return icd;
	}

	public void setIcd(String icd) {
		this.icd = icd;
	}

	public String getIcdName() {
		return icdName;
	}

	public void setIcdName(String icdName) {
		this.icdName = icdName;
	}

	public String getProfName() {
		return profName;
	}

	public void setProfName(String profName) {
		this.profName = profName;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
}
