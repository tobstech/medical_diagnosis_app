package com.tobstech.medicaldiagnosisapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tobstech.medicaldiagnosisapp.diagnosis.result.DiagnosisResultIssue;

//diagnosis result issue repository class
public interface DiagnosisResultIssueRepository extends CrudRepository<DiagnosisResultIssue, Integer>{
	
	public List<DiagnosisResultIssue> findDiagnosisResultIssueByDiagnosisReference(String diagnosisReference);
	
}