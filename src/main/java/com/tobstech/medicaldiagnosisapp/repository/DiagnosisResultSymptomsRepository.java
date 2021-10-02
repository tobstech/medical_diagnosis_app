package com.tobstech.medicaldiagnosisapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tobstech.medicaldiagnosisapp.diagnosis.result.DiagnosisResultSymptoms;

//diagnosis result symptoms repository class
public interface DiagnosisResultSymptomsRepository extends CrudRepository<DiagnosisResultSymptoms, Integer> {

	List<DiagnosisResultSymptoms> getSymptomsByDiagnosisReference(String diagnosisReference);
}
