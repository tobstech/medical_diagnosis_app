package com.tobstech.medicaldiagnosisapp.specialization;

//specialization parameter class
public class Specialization {
	
	private int specializationId;
	private String specializationName;
	private int specialistId;
	
	public Specialization() {}

	public Specialization(int specializationId, String specializationName, int specialistId) {
		super();
		this.specializationId = specializationId;
		this.specializationName = specializationName;
		this.specialistId = specialistId;
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

}
