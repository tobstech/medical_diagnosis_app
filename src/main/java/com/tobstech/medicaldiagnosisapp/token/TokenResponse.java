package com.tobstech.medicaldiagnosisapp.token;

//token response parameter
public class TokenResponse {

	private String token;
	private int validThrough;
	private int responseCode;
	private String responseMessage;
	
	public TokenResponse() {}
	
	public TokenResponse(String token, int validThrough) {
		super();
		this.token = token;
		this.validThrough = validThrough;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public int getValidThrough() {
		return validThrough;
	}
	
	public void setValidThrough(int validThrough) {
		this.validThrough = validThrough;
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
