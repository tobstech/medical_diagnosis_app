package com.tobstech.medicaldiagnosisapp.patient;

//patient parameter definition
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="patientTable")
@Table(name="patientTable")
public class Patient {
	
	@Id
	private int id;
	private String patientNo;
	private String firstname;
	private String lastname;
	private int age;
	private String phoneNumber;
	private String email;
	private String address;
	private String nextOfKinName;
	private String nextOfKinPhoneNumber;
	private String nextOfKinAddress;
	private String nextOfKinRelationship;
	private String gender;
	
	
	public Patient() {}

	public Patient(String patientNo, String firstname, String lastname, int age, String phoneNumber,
			String email, String address, String nextOfKinName, String nextOfKinPhoneNumber, String nextOfKinAddress,
			String nextOfKinRelationship, String gender) {
		super();
		this.patientNo = patientNo;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.nextOfKinName = nextOfKinName;
		this.nextOfKinPhoneNumber = nextOfKinPhoneNumber;
		this.nextOfKinAddress = nextOfKinAddress;
		this.nextOfKinRelationship = nextOfKinRelationship;
		this.gender = gender;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNextOfKinName() {
		return nextOfKinName;
	}

	public void setNextOfKinName(String nextOfKinName) {
		this.nextOfKinName = nextOfKinName;
	}

	public String getNextOfKinPhoneNumber() {
		return nextOfKinPhoneNumber;
	}

	public void setNextOfKinPhoneNumber(String nextOfKinPhoneNumber) {
		this.nextOfKinPhoneNumber = nextOfKinPhoneNumber;
	}

	public String getNextOfKinAddress() {
		return nextOfKinAddress;
	}

	public void setNextOfKinAddress(String nextOfKinAddress) {
		this.nextOfKinAddress = nextOfKinAddress;
	}

	public String getNextOfKinRelationship() {
		return nextOfKinRelationship;
	}

	public void setNextOfKinRelationship(String nextOfKinRelationship) {
		this.nextOfKinRelationship = nextOfKinRelationship;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
