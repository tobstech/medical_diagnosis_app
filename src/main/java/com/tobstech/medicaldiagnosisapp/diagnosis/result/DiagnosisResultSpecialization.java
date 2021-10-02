package com.tobstech.medicaldiagnosisapp.diagnosis.result;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//diagnosis result specialization parameter definition
@Entity(name="diagnosisResultSpecializationTable")
@Table(name="diagnosisResultSpecializationTable")
public class DiagnosisResultSpecialization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String diagnosisReference;
	private int issueId;
	private int specializationId;
	private String specializationName;
	private int specialistId;
	
	public DiagnosisResultSpecialization() {}

	public DiagnosisResultSpecialization(String diagnosisReference, int issueId, int specializationId,
			String specializationName, int specialistId) {
		super();
		this.diagnosisReference = diagnosisReference;
		this.issueId = issueId;
		this.specializationId = specializationId;
		this.specializationName = specializationName;
		this.specialistId = specialistId;
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

	public int getSpecializationId() {
		return specializationId;
	}

	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
	}

	public String getSpecializationName() {
		return specializationName;
	}

	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}

	public int getSpecialistId() {
		return specialistId;
	}

	public void setSpecialistId(int specialistId) {
		this.specialistId = specialistId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
