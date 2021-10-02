package com.tobstech.medicaldiagnosisapp.diagnosis.result;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//diagnosis result symptoms parameter definition
@Entity(name="diagnosisResultSymptomsTable")
@Table(name="diagnosisResultSymptomsTable")
public class DiagnosisResultSymptoms {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String diagnosisReference;
	private int symptomsId;
	private String symptomsName;
	
	public DiagnosisResultSymptoms() {}

	public DiagnosisResultSymptoms(String diagnosisReference, int symptomsId, String symptomsName) {
		super();
		this.diagnosisReference = diagnosisReference;
		this.symptomsId = symptomsId;
		this.symptomsName = symptomsName;
	}

	public String getDiagnosisReference() {
		return diagnosisReference;
	}

	public void setDiagnosisReference(String diagnosisReference) {
		this.diagnosisReference = diagnosisReference;
	}

	public int getSymptomsId() {
		return symptomsId;
	}

	public void setSymptomsId(int symptomsId) {
		this.symptomsId = symptomsId;
	}

	public String getSymptomsName() {
		return symptomsName;
	}

	public void setSymptomsName(String symptomsName) {
		this.symptomsName = symptomsName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
