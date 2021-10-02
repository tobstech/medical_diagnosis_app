package com.tobstech.medicaldiagnosisapp.diagnosis.result;

import java.util.List;

//diagnosis result response parameter definition
public class DiagnosisResultGetResponseFinal {
	
	private List<DiagnosisResultGetResponse> results;
	private int responseCode;
	private String responseMessage;

	public DiagnosisResultGetResponseFinal() {
		super();
	}

	public DiagnosisResultGetResponseFinal(List<DiagnosisResultGetResponse> results, 
			int responseCode, String responseMessage) {
		super();
		this.results = results;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	public List<DiagnosisResultGetResponse> getDiagnosisResultGetResponseList() {
		return results;
	}

	public void setDiagnosisResultGetResponseList(List<DiagnosisResultGetResponse> results) {
		this.results = results;
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
