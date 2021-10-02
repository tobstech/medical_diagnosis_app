package com.tobstech.medicaldiagnosisapp.diagnosis;

import java.util.List;

import com.tobstech.medicaldiagnosisapp.issue.Issue;
import com.tobstech.medicaldiagnosisapp.specialization.Specialization;

public class DiagnosisResponseDetails {

	private Issue issue;
	private List<Specialization> specialization;
	
	public DiagnosisResponseDetails() {}

	public DiagnosisResponseDetails(Issue issue, List<Specialization> specialization) {
		super();
		this.issue = issue;
		this.specialization = specialization;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public List<Specialization> getSpecialization() {
		return specialization;
	}

	public void setSpecialization(List<Specialization> specialization) {
		this.specialization = specialization;
	}
	
}
