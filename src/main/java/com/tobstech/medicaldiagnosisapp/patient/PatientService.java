package com.tobstech.medicaldiagnosisapp.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tobstech.medicaldiagnosisapp.repository.PatientRepository;

//patient parameter service class
@Service
public class PatientService {
	
	@Autowired
	private PatientRepository repo;

	public PatientService() {}

	public PatientService(PatientRepository repo) {
		super();
		this.repo = repo;
	}

	//method to save patient
	public void savePatient(Patient patient) {
		repo.save(patient);
	}
	
	//method to get all patients
	public Iterable<Patient> getAllPatients() {
		return repo.findAll();
	}
	
	//method to find patient record based on patient number
	public Patient findPatientByPatientNo(String patientNo) {
		return repo.findPatientByPatientNo(patientNo);
	}
	
	//method to find patient record based on patient number like
	public List<Patient> findByPatientNo(String patientNo) {
		patientNo = "%" + patientNo + "%";
		return repo.findByPatientNo(patientNo);
	}
	
}
