package com.tobstech.medicaldiagnosisapp.diagnosis.result;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//diagnosis result parameter definition
@Entity(name="diagnosisResultTable")
@Table(name="diagnosisResultTable")
public class DiagnosisResult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String diagnosisReference;
	private String patientNo;
	private String patientName;
	private int patientAge;
	private String patientGender;
	
	public DiagnosisResult() {}

	public DiagnosisResult(String diagnosisReference, String patientNo, String patientName, int patientAge,
			String patientGender) {
		super();
		this.diagnosisReference = diagnosisReference;
		this.patientNo = patientNo;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientGender = patientGender;
	}

	public String getDiagnosisReference() {
		return diagnosisReference;
	}

	public void setDiagnosisReference(String diagnosisReference) {
		this.diagnosisReference = diagnosisReference;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
