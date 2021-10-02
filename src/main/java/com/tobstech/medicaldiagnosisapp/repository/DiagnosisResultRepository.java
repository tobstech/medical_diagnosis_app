package com.tobstech.medicaldiagnosisapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tobstech.medicaldiagnosisapp.diagnosis.result.DiagnosisResult;

//diagnosis result repository class
public interface DiagnosisResultRepository extends CrudRepository<DiagnosisResult, Integer> {

	public List<DiagnosisResult> findDiagnosisResultByPatientNo(String patientNo);
	
}
