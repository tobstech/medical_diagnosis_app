package com.tobstech.medicaldiagnosisapp.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tobstech.medicaldiagnosisapp.diagnosis.result.DiagnosisResultGetResponseFinal;
import com.tobstech.medicaldiagnosisapp.diagnosis.result.DiagnosisResultGetResponseService;
import com.tobstech.medicaldiagnosisapp.diagnosis.result.DiagnosisResultRequest;
import com.tobstech.medicaldiagnosisapp.diagnosis.result.DiagnosisResultResponse;
import com.tobstech.medicaldiagnosisapp.diagnosis.result.DiagnosisResultService;

@org.springframework.web.bind.annotation.RestController
public class DiagnosisResultController {
	
	@Autowired
	private DiagnosisResultService diagnosisResultService;

	@Autowired
	private DiagnosisResultGetResponseService diagnosisResultGetResponseService;
	
	//controller to save diagnosis result to database
	@PostMapping("/save-diagnosis-result")
	@Transactional
	@CrossOrigin
	public DiagnosisResultResponse saveDiagnosisResult(@RequestBody DiagnosisResultRequest diagnosisResultRequest) throws InvalidKeyException, NoSuchAlgorithmException, JsonMappingException, JsonProcessingException {
		return diagnosisResultService.saveDiagnosisResult(diagnosisResultRequest);
	}
	
	//controller to retrieve diagnosis result from database using patient no
	@GetMapping("/retrieve-diagnosis-result/{patientNo}")
	@Transactional
	@CrossOrigin
	public DiagnosisResultGetResponseFinal findDiagnosisResultByPatientNo(@PathVariable String patientNo) {
		return diagnosisResultGetResponseService.findDiagnosisResultByPatientNo(patientNo);
	} 
	
}
