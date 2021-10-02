package com.tobstech.medicaldiagnosisapp.diagnosis;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.tobstech.medicaldiagnosisapp.controller.AuthenticationController;
import com.tobstech.medicaldiagnosisapp.issue.Issue;
import com.tobstech.medicaldiagnosisapp.specialization.Specialization;
import com.tobstech.medicaldiagnosisapp.token.TokenResponse;
import com.tobstech.medicaldiagnosisapp.util.Utils;

//get diagnosis service class
@Service
public class DiagnosisService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	//get diagnosis list method
	public DiagnosisResponse getDiagnosis(DiagnosisRequest diagnosisRequest) throws InvalidKeyException, NoSuchAlgorithmException {
		DiagnosisResponse diagnosisResponse = new DiagnosisResponse();
		List<DiagnosisResponseDetails> diagnosisResponseDetailsList = new ArrayList<DiagnosisResponseDetails>();
		
		//get and set request objects
		TokenResponse tokenResponse = new AuthenticationController().getAuthenticationToken();
		diagnosisRequest.setToken(tokenResponse.getToken());
		diagnosisRequest.setEndpoint(Utils.DIAGNOSIS_URI);
		diagnosisRequest.setFormat(Utils.FORMAT);
		diagnosisRequest.setLanguage(Utils.LANGUAGE);
		//get symptoms
		String response = diagnosisRequest(diagnosisRequest);
		//convert response to json array
		JsonArray jsonArray = new JsonParser().parse(response).getAsJsonArray();	
		
		//format response
		if(jsonArray.size() > 0) {
			for(JsonElement jObj : jsonArray) {
				DiagnosisResponseDetails diagnosisResponseDetails = new DiagnosisResponseDetails();
				List<Specialization> specializationList = new ArrayList<Specialization>();
				Issue issue = new Issue();
		
				//get issue objects in the array				
				issue.setAccuracy(jObj.getAsJsonObject().get("Issue").getAsJsonObject().get("Accuracy").getAsDouble());
				issue.setIcd(jObj.getAsJsonObject().get("Issue").getAsJsonObject().get("Icd").getAsString());
				issue.setIcdName(jObj.getAsJsonObject().get("Issue").getAsJsonObject().get("IcdName").getAsString());
				issue.setIssueId(jObj.getAsJsonObject().get("Issue").getAsJsonObject().get("ID").getAsInt());
				issue.setIssueName(jObj.getAsJsonObject().get("Issue").getAsJsonObject().get("Name").getAsString());
				issue.setProfName(jObj.getAsJsonObject().get("Issue").getAsJsonObject().get("ProfName").getAsString());
				issue.setRanking(jObj.getAsJsonObject().get("Issue").getAsJsonObject().get("Ranking").getAsInt());
				
				JsonArray jsonArraySpecialization = new JsonParser().parse(jObj.getAsJsonObject().get("Specialisation").toString()).getAsJsonArray();				
				for(JsonElement jObSpec : jsonArraySpecialization) {
					//get specialization objects in the array			
					Specialization specialization = new Specialization();
					specialization.setSpecialistId(jObSpec.getAsJsonObject().get("SpecialistID").getAsInt());
					specialization.setSpecializationId(jObSpec.getAsJsonObject().get("ID").getAsInt());
					specialization.setSpecializationName(jObSpec.getAsJsonObject().get("Name").getAsString());
					specializationList.add(specialization);
				}
				diagnosisResponseDetails.setIssue(issue);
				diagnosisResponseDetails.setSpecialization(specializationList);
				diagnosisResponseDetailsList.add(diagnosisResponseDetails);
			}
			diagnosisResponse.setDiagnosisResult(diagnosisResponseDetailsList);
			diagnosisResponse.setResponseCode(0);
			diagnosisResponse.setResponseMessage("Success");
		}else {
			diagnosisResponse.setResponseCode(-1);
			diagnosisResponse.setResponseMessage("No diagnosis result available for the selected symptoms.");
		}
		//return response
		return diagnosisResponse;
	}

	//get diagnosisRequest
	private String diagnosisRequest(DiagnosisRequest diagnosisRequest) {	
		//mashall request
		String mashalledRequest = diagnosisRequest.getEndpoint() + "symptoms=" + diagnosisRequest.getSymptoms() + "&gender=" + diagnosisRequest.getGender() + "&year_of_birth=" + diagnosisRequest.getYearOfBirth() + "&token=" + diagnosisRequest.getToken() + "&format=" + diagnosisRequest.getFormat() + "&language=" + diagnosisRequest.getLanguage();
		//call api
		String result = restTemplate.getForObject(mashalledRequest, String.class);
		return result;
	}


}
