package com.tobstech.medicaldiagnosisapp.diagnosis.result;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tobstech.medicaldiagnosisapp.repository.DiagnosisResultIssueRepository;
import com.tobstech.medicaldiagnosisapp.repository.DiagnosisResultRepository;
import com.tobstech.medicaldiagnosisapp.repository.DiagnosisResultSpecializationRepository;
import com.tobstech.medicaldiagnosisapp.repository.DiagnosisResultSymptomsRepository;

//get diagnosis result service  class
@Service
public class DiagnosisResultGetResponseService {
	
	@Autowired
	private DiagnosisResultRepository repo;
	@Autowired
	private DiagnosisResultSymptomsRepository repoSymptoms;
	@Autowired
	private DiagnosisResultSpecializationRepository repoSpecialization;
	@Autowired
	private DiagnosisResultIssueRepository repoIssue;
	
	public DiagnosisResultGetResponseService() {
		super();
	}

	public DiagnosisResultGetResponseService(DiagnosisResultRepository repo,
			DiagnosisResultSymptomsRepository repoSymptoms, DiagnosisResultSpecializationRepository repoSpecialization,
			DiagnosisResultIssueRepository repoIssue) {
		super();
		this.repo = repo;
		this.repoSymptoms = repoSymptoms;
		this.repoSpecialization = repoSpecialization;
		this.repoIssue = repoIssue;
	}
	
	public DiagnosisResultGetResponseFinal findDiagnosisResultByPatientNo(String patientNo) {
		//define response object
		DiagnosisResultGetResponseFinal diagnosisResultGetResponseFinal = new DiagnosisResultGetResponseFinal();		
		List<DiagnosisResultGetResponse> diagnosisResultGetResponseList = new ArrayList<DiagnosisResultGetResponse>();
		
		//get patient - diagnosis result - patient data
		//initialization
		List<DiagnosisResult> diagnosisResultList = repo.findDiagnosisResultByPatientNo(patientNo);
		
		for(DiagnosisResult diagnosisResult : diagnosisResultList) {
			
			DiagnosisResultGetResponse diagnosisResultGetResponse = new DiagnosisResultGetResponse();
			
			//set diagnosis result and symptoms
			diagnosisResultGetResponse.setDiagnosisReference(diagnosisResult.getDiagnosisReference());
			List<DiagnosisResultSymptoms> diagnosisResultSymptomsList = repoSymptoms.getSymptomsByDiagnosisReference(diagnosisResult.getDiagnosisReference());
			String s = ""; int counter = 0;
			for(DiagnosisResultSymptoms drs : diagnosisResultSymptomsList) {
				if(counter < diagnosisResultSymptomsList.size()-1) {
					s = s + drs.getSymptomsName() + ", ";
				}else {
					s = s + drs.getSymptomsName();
				}				
				counter++;
			}
			diagnosisResultGetResponse.setSymptomsName(s);			
			diagnosisResultGetResponse.setDiagnosisResult(diagnosisResult);
			
			List<DiagnosisResultIssueSpecialization> diagnosisResultIssueSpecialization = new ArrayList<DiagnosisResultIssueSpecialization>();
			
			
			//get and set diagnosis result issue
			List<DiagnosisResultIssue> diagnosisResultIssueList = repoIssue.findDiagnosisResultIssueByDiagnosisReference(diagnosisResult.getDiagnosisReference());
			
			for(DiagnosisResultIssue diagnosisResultIssue: diagnosisResultIssueList) {
				
				DiagnosisResultIssueSpecialization diagnosisResultIssueSpecializatn = 
						new DiagnosisResultIssueSpecialization();
			
				//get diagnosis specialization
				List<DiagnosisResultSpecialization> diagnosisResultSpecializationList = repoSpecialization.findDiagnosisResultSpecializationByDiagnosisReferenceAndIssueId(
						diagnosisResult.getDiagnosisReference(), diagnosisResultIssue.getIssueId());

				diagnosisResultIssueSpecializatn.setIssue(diagnosisResultIssue);
				diagnosisResultIssueSpecializatn.setSpecialization(diagnosisResultSpecializationList);
				diagnosisResultIssueSpecialization.add(diagnosisResultIssueSpecializatn);
				
			}
			
			diagnosisResultGetResponse.setDiagnosisResultInfo(diagnosisResultIssueSpecialization);
			
			diagnosisResultGetResponseList.add(diagnosisResultGetResponse);
			
		}
		if(diagnosisResultGetResponseList.size() > 0) {
			diagnosisResultGetResponseFinal.setResponseCode(0);
			diagnosisResultGetResponseFinal.setResponseMessage("Success");
		}else {
			diagnosisResultGetResponseFinal.setResponseCode(-1);
			diagnosisResultGetResponseFinal.setResponseMessage("No diagnosis result available for this patient.");
		}
		diagnosisResultGetResponseFinal.setDiagnosisResultGetResponseList(diagnosisResultGetResponseList);
		
		return diagnosisResultGetResponseFinal;
	}
	
	

}
