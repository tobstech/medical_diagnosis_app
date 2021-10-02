package com.tobstech.medicaldiagnosisapp.diagnosis.result;

//get diagnosis result response parameter definition
public class DiagnosisResultResponse {
	
	private int responseCode;
	private String responseMessage;
	
	public DiagnosisResultResponse() {}

	public DiagnosisResultResponse(int responseCode, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
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
