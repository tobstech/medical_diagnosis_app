package com.tobstech.medicaldiagnosisapp.diagnosis.result;

import java.util.List;

//diagnosis result response parameter definition
public class DiagnosisResultGetResponse {
	
	private String diagnosisReference;
	private String symptomsName;
	private DiagnosisResult diagnosisResult;
	private List<DiagnosisResultIssueSpecialization> diagnosisResultInfo;
	
	public DiagnosisResultGetResponse() {}

	public DiagnosisResultGetResponse(String diagnosisReference, String symptomsName, DiagnosisResult diagnosisResult,
			List<DiagnosisResultIssueSpecialization> diagnosisResultInfo) {
		super();
		this.diagnosisReference = diagnosisReference;
		this.symptomsName = symptomsName;
		this.diagnosisResult = diagnosisResult;
		this.diagnosisResultInfo = diagnosisResultInfo;
	}

	public String getDiagnosisReference() {
		return diagnosisReference;
	}

	public void setDiagnosisReference(String diagnosisReference) {
		this.diagnosisReference = diagnosisReference;
	}

	public String getSymptomsName() {
		return symptomsName;
	}

	public void setSymptomsName(String symptomsName) {
		this.symptomsName = symptomsName;
	}

	public DiagnosisResult getDiagnosisResult() {
		return diagnosisResult;
	}

	public void setDiagnosisResult(DiagnosisResult diagnosisResult) {
		this.diagnosisResult = diagnosisResult;
	}

	public List<DiagnosisResultIssueSpecialization> getDiagnosisResultInfo() {
		return diagnosisResultInfo;
	}

	public void setDiagnosisResultInfo(List<DiagnosisResultIssueSpecialization> diagnosisResultInfo) {
		this.diagnosisResultInfo = diagnosisResultInfo;
	}


}
