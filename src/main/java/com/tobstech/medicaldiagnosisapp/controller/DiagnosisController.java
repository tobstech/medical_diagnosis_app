package com.tobstech.medicaldiagnosisapp.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.tobstech.medicaldiagnosisapp.diagnosis.DiagnosisRequest;
import com.tobstech.medicaldiagnosisapp.diagnosis.DiagnosisResponse;
import com.tobstech.medicaldiagnosisapp.diagnosis.DiagnosisService;

@org.springframework.web.bind.annotation.RestController
public class DiagnosisController {
	
	@Autowired
	private DiagnosisService serv;
	
	//controller to get diagnosis from apimedic based on selected symptoms
	@PostMapping("/diagnosis")
	@Transactional
	@CrossOrigin
	public DiagnosisResponse getDiagnosis(@RequestBody DiagnosisRequest diagnosisRequest) throws InvalidKeyException, NoSuchAlgorithmException {
		return serv.getDiagnosis(diagnosisRequest);
	}	
	
	
}
