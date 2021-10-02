package com.tobstech.medicaldiagnosisapp.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import com.tobstech.medicaldiagnosisapp.symptoms.SymptomsRequest;
import com.tobstech.medicaldiagnosisapp.symptoms.SymptomsResponse;
import com.tobstech.medicaldiagnosisapp.symptoms.SymptomsService;

@org.springframework.web.bind.annotation.RestController
public class SymptomController {

	@Value("${symptoms.format}")
	private String format;
	
	@Value("${symptoms.language}")
	private String language;
	
	@Value("${symptoms.uri}")
	private String symptomsURI;
	
	SymptomsService symptomsService = new SymptomsService();
	
	//controller to get list of symptoms from apimedic.com 
	@GetMapping("/symptoms")
	@Transactional
	@CrossOrigin
	public SymptomsResponse getSymptoms() throws InvalidKeyException, NoSuchAlgorithmException {
		SymptomsRequest symptomsRequest = new SymptomsRequest();
		symptomsRequest.setEndpoint(symptomsURI);
		symptomsRequest.setFormat(format);
		symptomsRequest.setLanguage(language);
		return symptomsService.getSymptomsList(symptomsRequest);
	}
	
}
