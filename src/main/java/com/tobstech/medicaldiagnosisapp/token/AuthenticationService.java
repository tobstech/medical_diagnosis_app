package com.tobstech.medicaldiagnosisapp.token;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

//authorization service class
public class AuthenticationService {
	
	RestTemplate restTemplate = new RestTemplate();
	String hashedString; 
	
	//get token method
	public TokenResponse getToken(TokenModel tokenModel) throws InvalidKeyException, NoSuchAlgorithmException {
		TokenResponse tokenResponse = new TokenResponse();
		hashedString = getHashedCredentials(tokenModel);
		String response = getAuthorizationToken(tokenModel);
		//convert response to json object
		JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
		//format response
		if(!jsonObject.get("Token").getAsString().isEmpty()) {
			tokenResponse.setToken(jsonObject.get("Token").getAsString());	
			tokenResponse.setValidThrough(jsonObject.get("ValidThrough").getAsInt());
			tokenResponse.setResponseCode(0);
			tokenResponse.setResponseMessage("Success");
		}else {
			tokenResponse.setResponseCode(-1);
			tokenResponse.setResponseMessage("Service Currently not available");
		}
		//return response
		return tokenResponse;
	}
	
	// Method to get Hashed Credentials
	private String getHashedCredentials(TokenModel tokenModel) throws NoSuchAlgorithmException, InvalidKeyException {
		// create an instance of Mac
		Mac sha256 = Mac.getInstance("HmacSHA256");
		// get the byte
		SecretKeySpec secret_key = new SecretKeySpec(tokenModel.getClientSecret().getBytes(), "HmacSHA256");
		// initialize the secret key
		sha256.init(secret_key);
		// convert into base64 string
		return Base64.encodeBase64String(sha256.doFinal(tokenModel.getRequestedURI().getBytes()));
	}
	
	//get authorization token
	private String getAuthorizationToken(TokenModel tokenModel) {	
		//mashall header
		String mashalledHeader = "Bearer " + tokenModel.getApiKey() + ":" + tokenModel.getHashedString();
		//set header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", mashalledHeader);
		//call api
		HttpEntity<String> entity = new HttpEntity<>(headers);
		String result = restTemplate.exchange(tokenModel.getRequestedURI(), HttpMethod.POST, entity, String.class).getBody();
		
		return result;
	}
	
}
