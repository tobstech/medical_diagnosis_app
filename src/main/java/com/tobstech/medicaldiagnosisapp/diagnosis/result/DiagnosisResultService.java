package com.tobstech.medicaldiagnosisapp.diagnosis.result;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tobstech.medicaldiagnosisapp.repository.DiagnosisResultIssueRepository;
import com.tobstech.medicaldiagnosisapp.repository.DiagnosisResultRepository;
import com.tobstech.medicaldiagnosisapp.repository.DiagnosisResultSpecializationRepository;
import com.tobstech.medicaldiagnosisapp.repository.DiagnosisResultSymptomsRepository;
import com.tobstech.medicaldiagnosisapp.util.JsonConverter;

//diagnosis result parameter definition
@Service
public class DiagnosisResultService {
	
	@Autowired
	private DiagnosisResultRepository repo;
	@Autowired
	private DiagnosisResultSymptomsRepository repoSymptoms;
	@Autowired
	private DiagnosisResultSpecializationRepository repoSpecialization;
	@Autowired
	private DiagnosisResultIssueRepository repoIssue;

	public DiagnosisResultService() {}

	public DiagnosisResultService(DiagnosisResultRepository repo, DiagnosisResultSymptomsRepository repoSymptoms,
			DiagnosisResultSpecializationRepository repoSpecialization, DiagnosisResultIssueRepository repoIssue) {
		super();
		this.repo = repo;
		this.repoSymptoms = repoSymptoms;
		this.repoSpecialization = repoSpecialization;
		this.repoIssue = repoIssue;
	}

	//save diagnosis result response method
	public DiagnosisResultResponse saveDiagnosisResult(DiagnosisResultRequest diagnosisResultRequest) throws JsonMappingException, JsonProcessingException {
		
		//define response object
		DiagnosisResultResponse diagnosisResultResponse = new DiagnosisResultResponse();
		ObjectMapper mapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		Map<String,Object> diagResult = mapper.readValue(diagnosisResultRequest.getRequestPatientReserved(), Map.class);
	
		//set diagnosis result data - patient reserved
		DiagnosisResult diagnosisResult = new DiagnosisResult();
		diagnosisResult.setPatientNo(diagResult.get("patientNo").toString());
		diagnosisResult.setPatientAge((int) diagResult.get("age"));
		diagnosisResult.setPatientGender(diagResult.get("gender").toString());
		diagnosisResult.setPatientName(diagResult.get("firstname").toString().concat(" ").concat(diagResult.get("lastname").toString()));
		diagnosisResult.setDiagnosisReference(getDiagnosisReference(diagnosisResult.getPatientNo()));
		//save to database
		repo.save(diagnosisResult);
		
		//set symptoms data - symptoms list in name and selected checkboxes
		String [] symptomName = diagnosisResultRequest.getRequestSymtomsListInName().split(",");
		String [] symptomId = diagnosisResultRequest.getRequestSelectedCheckboxes().split(",");
		for(int i=0; i<symptomId.length; i++) {
			DiagnosisResultSymptoms diagnosisResultSymptoms = new DiagnosisResultSymptoms();
			diagnosisResultSymptoms.setSymptomsId(Integer.parseInt(symptomId[i]));
			diagnosisResultSymptoms.setSymptomsName(symptomName[i]);
			diagnosisResultSymptoms.setDiagnosisReference(diagnosisResult.getDiagnosisReference());
			//save to database
			repoSymptoms.save(diagnosisResultSymptoms);
			
		}
		
		//set data exchange diagnosis data
		List<DiagnosisResultIssueSpecialization> diagnosisResultIssueSpecializationList = Arrays.asList(JsonConverter.jsonToObject(diagnosisResultRequest.getRequestDataExchangeDiagnosisResult(), DiagnosisResultIssueSpecialization[].class));
		for(DiagnosisResultIssueSpecialization diagnosisResultIssueSpecialization: diagnosisResultIssueSpecializationList) {
			//mashall valid or invalid marking
			@SuppressWarnings("unchecked")
			Map<String,String> validInvalid = new ObjectMapper().readValue(diagnosisResultRequest.getRequestValidInvalidResult(), Map.class);		
			String statusValue []  = validInvalid.get("validinvalidresult[" + diagnosisResultIssueSpecialization.getIssue().getIssueId() + "]").split("-");
			String status = statusValue[0];
			diagnosisResultIssueSpecialization.getIssue().setDiagnosisReference(diagnosisResult.getDiagnosisReference());
			diagnosisResultIssueSpecialization.getIssue().setResultValidInvalid(status);
			for(DiagnosisResultSpecialization  diagnosisResultSpecialization:   diagnosisResultIssueSpecialization.getSpecialization()) {
				diagnosisResultSpecialization.setDiagnosisReference(diagnosisResult.getDiagnosisReference());
				diagnosisResultSpecialization.setIssueId(diagnosisResultIssueSpecialization.getIssue().getIssueId());
				//save specialization
				repoSpecialization.save(diagnosisResultSpecialization);				
			}
			//save issue
			repoIssue.save(diagnosisResultIssueSpecialization.getIssue());			
		}		
		//set response message
		diagnosisResultResponse.setResponseCode(0);
		diagnosisResultResponse.setResponseMessage("Diagnosis Result Successfully Saved");
		return diagnosisResultResponse;
	}
	
	//generate diagnosis reference
	public String getDiagnosisReference(String patientNo) {
		int n = 6;
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);	  
        for (int i = 0; i < n; i++) {
	        // generate a random number between 0 to AlphaNumericString variable length
	        int index = (int)(AlphaNumericString.length() * Math.random());
	        // add Character one by one in end of sb
	        sb.append(AlphaNumericString.charAt(index));
	    }
        return patientNo.concat(sb.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
