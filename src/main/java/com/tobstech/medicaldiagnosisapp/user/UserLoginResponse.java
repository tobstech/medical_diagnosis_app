package com.tobstech.medicaldiagnosisapp.user;

//user login response parameters
public class UserLoginResponse {

	private int id;
	private String username;
	private String firstname;
	private String lastname;
	private int responseCode;
	private String responseMessage;
	
	public UserLoginResponse() {}

	public UserLoginResponse(int id, String username, String firstname, String lastname, int responseCode,
			String responseMessage) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
