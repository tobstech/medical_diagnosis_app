package com.tobstech.medicaldiagnosisapp.symptoms;

//symptoms response details
public class SymptomsResponseDetails {

	private int symptomId;
	private String name;
	
	public SymptomsResponseDetails() {}
	
	public SymptomsResponseDetails(int symptomId, String name) {
		super();
		this.symptomId = symptomId;
		this.name = name;
	}

	public int getSymptomId() {
		return symptomId;
	}

	public void setSymptomId(int symptomId) {
		this.symptomId = symptomId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
