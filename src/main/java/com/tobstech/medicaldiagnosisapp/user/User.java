package com.tobstech.medicaldiagnosisapp.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//user request parameters
@Entity(name="userTable")
@Table(name="userTable")
public class User {

	@Id
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	
	public User() {}

	public User(int id, String username, String password, String firstname, String lastname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
}
