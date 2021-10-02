package com.tobstech.medicaldiagnosisapp.symptoms;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.client.RestTemplate;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.tobstech.medicaldiagnosisapp.controller.AuthenticationController;
import com.tobstech.medicaldiagnosisapp.token.TokenResponse;

//get symptoms service
public class SymptomsService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	//get symptoms list method
	public SymptomsResponse getSymptomsList(SymptomsRequest symptomsRequest) throws InvalidKeyException, NoSuchAlgorithmException {
		List<SymptomsResponseDetails> symptomsResponseDetails = new ArrayList<SymptomsResponseDetails>();
		SymptomsResponse symptomsResponse = new SymptomsResponse();
		//get and set token
		TokenResponse tokenResponse = new AuthenticationController().getAuthenticationToken();
		symptomsRequest.setToken(tokenResponse.getToken());
		//get symptoms
		String response = getSymptoms(symptomsRequest);
		//convert response to json array
		JsonArray jsonArray = new JsonParser().parse(response).getAsJsonArray();
		//format response
		if(jsonArray.size() > 0) {
			for(JsonElement jObj : jsonArray) {
				SymptomsResponseDetails symptomsResponseDetail = new SymptomsResponseDetails();
				symptomsResponseDetail.setSymptomId(jObj.getAsJsonObject().get("ID").getAsInt());
				symptomsResponseDetail.setName(jObj.getAsJsonObject().get("Name").getAsString());
				symptomsResponseDetails.add(symptomsResponseDetail);
			}
			symptomsResponse.setSymptomsResponseDetails(symptomsResponseDetails);
			symptomsResponse.setResponseCode(0);
			symptomsResponse.setResponseMessage("Success");
		}else {
			symptomsResponse.setResponseCode(-1);
			symptomsResponse.setResponseMessage("Service Currently not available");
		}
		//return response
		return symptomsResponse;
	}

	//get authorization token
	private String getSymptoms(SymptomsRequest symptomsRequest) {	
		//mashall request
		String mashalledRequest = symptomsRequest.getEndpoint() + "token=" + symptomsRequest.getToken() + "&format=" + symptomsRequest.getFormat() + "&language=" + symptomsRequest.getLanguage();
		//call api
		String result = restTemplate.getForObject(mashalledRequest, String.class);
		return result;
	}

}
