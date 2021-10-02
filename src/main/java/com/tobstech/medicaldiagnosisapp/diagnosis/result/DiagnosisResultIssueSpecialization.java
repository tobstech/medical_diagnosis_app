package com.tobstech.medicaldiagnosisapp.diagnosis.result;

import java.util.List;

//diagnosis result issue specialization parameter definition
public class DiagnosisResultIssueSpecialization {

	private DiagnosisResultIssue issue;
	private List<DiagnosisResultSpecialization> specialization;
	
	public DiagnosisResultIssue getIssue() {
		return issue;
	}
	public void setIssue(DiagnosisResultIssue issue) {
		this.issue = issue;
	}
	public List<DiagnosisResultSpecialization> getSpecialization() {
		return specialization;
	}
	public void setSpecialization(List<DiagnosisResultSpecialization> specialization) {
		this.specialization = specialization;
	}
	
	
	
	
}
