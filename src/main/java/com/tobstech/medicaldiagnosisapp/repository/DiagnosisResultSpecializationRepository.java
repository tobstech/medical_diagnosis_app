package com.tobstech.medicaldiagnosisapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tobstech.medicaldiagnosisapp.diagnosis.result.DiagnosisResultSpecialization;

//diagnosis result specialization repository class
public interface DiagnosisResultSpecializationRepository  extends CrudRepository<DiagnosisResultSpecialization, Integer>{ 

	public List<DiagnosisResultSpecialization> findDiagnosisResultSpecializationByDiagnosisReferenceAndIssueId(String diagnosisReference, int issueId);
	
}
