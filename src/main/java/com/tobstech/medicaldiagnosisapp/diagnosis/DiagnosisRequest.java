package com.tobstech.medicaldiagnosisapp.diagnosis;

import com.tobstech.medicaldiagnosisapp.symptoms.SymptomsRequest;

//diagnosis api call request parameters definition
public class DiagnosisRequest extends SymptomsRequest {
	
	private String symptoms;
	private String gender;
	private int yearOfBirth;
	
	public String getSymptoms() {
		return symptoms;
	}
	
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

}
