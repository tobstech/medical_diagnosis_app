package com.tobstech.medicaldiagnosisapp.diagnosis;

import java.util.List;

//diagnosis api call response parameters definition
public class DiagnosisResponse {
	
	private List<DiagnosisResponseDetails> diagnosisResult;
	private int responseCode;
	private String responseMessage;

	public List<DiagnosisResponseDetails> getDiagnosisResult() {
		return diagnosisResult;
	}

	public void setDiagnosisResult(List<DiagnosisResponseDetails> diagnosisResult) {
		this.diagnosisResult = diagnosisResult;
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
