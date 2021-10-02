// apidemic.com User authentication controller

package com.tobstech.medicaldiagnosisapp.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import com.tobstech.medicaldiagnosisapp.token.AuthenticationService;
import com.tobstech.medicaldiagnosisapp.token.TokenModel;
import com.tobstech.medicaldiagnosisapp.token.TokenResponse;
import com.tobstech.medicaldiagnosisapp.util.Utils;

@org.springframework.web.bind.annotation.RestController
public class AuthenticationController {
	
	@Value("${client.secret}")
	private String clientSecret;
	
	@Value("${api.key}")
	private String apiKey;
	
	@Value("${requested.uri}")
	private String requestedURI;
	
	@Value("${hashed.string}")
	private String hashedString;
	
	AuthenticationService authenticationService = new AuthenticationService();
	
	//method to get authentication token
	@PostMapping("/auth-token")
	@Transactional
	@CrossOrigin
	public TokenResponse getAuthenticationToken() throws InvalidKeyException, NoSuchAlgorithmException {
		TokenModel tokenModel = new TokenModel();
		if(apiKey == null) apiKey = Utils.API_KEY;
		if(clientSecret == null) clientSecret = Utils.CLIENT_SECRET;
		if(requestedURI == null) requestedURI = Utils.REQUESTED_URI;
		if(hashedString == null) hashedString = Utils.HASHED_STRING;
		tokenModel.setApiKey(apiKey);
		tokenModel.setClientSecret(clientSecret);
		tokenModel.setRequestedURI(requestedURI);
		tokenModel.setHashedString(hashedString);
		return authenticationService.getToken(tokenModel);
	}
	
}
