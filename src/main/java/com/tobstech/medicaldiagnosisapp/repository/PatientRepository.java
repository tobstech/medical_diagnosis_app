package com.tobstech.medicaldiagnosisapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.tobstech.medicaldiagnosisapp.patient.Patient;

//patient repository class
public interface PatientRepository extends CrudRepository<Patient, Integer> {

	public Patient findPatientByPatientNo(String patientNo);
	
	@Query("SELECT p FROM patientTable p WHERE p.patientNo LIKE ?1")
	List<Patient> findByPatientNo(String patientNo);
}
