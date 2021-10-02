package com.tobstech.medicaldiagnosisapp.controller;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tobstech.medicaldiagnosisapp.patient.Patient;
import com.tobstech.medicaldiagnosisapp.patient.PatientService;

@org.springframework.web.bind.annotation.RestController
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	//controller to save patient details to database
	@PostMapping("/save-patient")
	@Transactional
	@CrossOrigin
	public String registerPatient(@RequestBody Patient patient) {
		patientService.savePatient(patient);
		return "Patient Registration Successful.";
	}
	
	//controller to fetch all patients record from database
	@GetMapping("/all-patients")
	@CrossOrigin
	public Iterable<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}
	
	//controller to search for patient details based on patient number
	@GetMapping("/patient-search/{patientNo}")
	@Transactional
	@CrossOrigin
	public Patient searchPatientByPatientNo(@PathVariable String patientNo) {
		return patientService.findPatientByPatientNo(patientNo);
	} 
	
	//controller to search for patient related to the supplied patient number
	@GetMapping("/patient-like-search/{patientNo}")
	@Transactional
	@CrossOrigin
	public List<Patient> findByPatientNo(@PathVariable String patientNo) {
		return patientService.findByPatientNo(patientNo);
	} 
	
	
}
