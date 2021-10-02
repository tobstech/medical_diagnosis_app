package com.tobstech.medicaldiagnosisapp.token;

//request parameter to generate token
public class TokenModel {
	
	private String clientSecret;	
	private String apiKey;
	private String requestedURI;
	private String hashedString;
	
	public String getClientSecret() {
		return clientSecret;
	}
	
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	
	public String getApiKey() {
		return apiKey;
	}
	
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public String getRequestedURI() {
		return requestedURI;
	}
	
	public void setRequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}
	
	public String getHashedString() {
		return hashedString;
	}
	
	public void setHashedString(String hashedString) {
		this.hashedString = hashedString;
	}
	
}
