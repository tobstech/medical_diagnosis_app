package com.tobstech.medicaldiagnosisapp.symptoms;

import java.util.List;

//get symptoms response
public class SymptomsResponse {
	
	private List<SymptomsResponseDetails> SymptomsResponseDetails;
	private int responseCode;
	private String responseMessage;
	
	public SymptomsResponse() {}
	
	public SymptomsResponse(
			List<com.tobstech.medicaldiagnosisapp.symptoms.SymptomsResponseDetails> symptomsResponseDetails,
			int responseCode, String responseMessage) {
		super();
		SymptomsResponseDetails = symptomsResponseDetails;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	
	public List<SymptomsResponseDetails> getSymptomsResponseDetails() {
		return SymptomsResponseDetails;
	}
	
	public void setSymptomsResponseDetails(List<SymptomsResponseDetails> symptomsResponseDetails) {
		SymptomsResponseDetails = symptomsResponseDetails;
	}
	
	public int getResponseCode() {
		return responseCode;
	}
	
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	
	public String getResponseMessage() {
		return responseMessage;
	}
	
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
}
