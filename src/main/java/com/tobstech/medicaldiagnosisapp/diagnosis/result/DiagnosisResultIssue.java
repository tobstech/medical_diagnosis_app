package com.tobstech.medicaldiagnosisapp.diagnosis.result;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;

//diagnosis result issue parameter definition
@Entity(name="diagnosisResultIssueTable")
@Table(name="diagnosisResultIssueTable")
public class DiagnosisResultIssue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String diagnosisReference;
	private int issueId;
	private String issueName;
	private Double accuracy;
	private String icd;
	private String icdName;
	@JsonAlias("profName")
	private String professionName;
	private int ranking;
	private String resultValidInvalid;
	
	public DiagnosisResultIssue() {
		super();
	}

	public DiagnosisResultIssue(String diagnosisReference, int issueId, String issueName, Double accuracy, String icd,
			String icdName, String professionName, int ranking, String resultValidInvalid) {
		super();
		this.diagnosisReference = diagnosisReference;
		this.issueId = issueId;
		this.issueName = issueName;
		this.accuracy = accuracy;
		this.icd = icd;
		this.icdName = icdName;
		this.professionName = professionName;
		this.ranking = ranking;
		this.resultValidInvalid = resultValidInvalid;
	}

	public String getDiagnosisReference() {
		return diagnosisReference;
	}

	public void setDiagnosisReference(String diagnosisReference) {
		this.diagnosisReference = diagnosisReference;
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

	public String getProfessionName() {
		return professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getResultValidInvalid() {
		return resultValidInvalid;
	}

	public void setResultValidInvalid(String resultValidInvalid) {
		this.resultValidInvalid = resultValidInvalid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
