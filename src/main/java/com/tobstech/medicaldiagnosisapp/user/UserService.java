package com.tobstech.medicaldiagnosisapp.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobstech.medicaldiagnosisapp.repository.UserRepository;

//user service class
@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public UserService() {}

	public UserService(UserRepository repo) {
		super();
		this.repo = repo;
	}

	//method to login handle user login
	public UserLoginResponse login(UserLoginRequest userLoginRequest) {
		List<User> userDetail = repo.findByUsernameAndPassword(userLoginRequest.getUsername(), userLoginRequest.getPassword());
		UserLoginResponse userLoginResponse = new UserLoginResponse();
		if(userDetail.size() == 1) {			
			userLoginResponse.setFirstname(userDetail.get(0).getFirstname());
			userLoginResponse.setId(userDetail.get(0).getId());
			userLoginResponse.setLastname(userDetail.get(0).getLastname());
			userLoginResponse.setUsername(userDetail.get(0).getUsername());
			userLoginResponse.setResponseCode(0);
			userLoginResponse.setResponseMessage("Login Successful.");
		}else {
			userLoginResponse.setResponseCode(-1);
			userLoginResponse.setResponseMessage("Invalid Login Details.");
		}
		return userLoginResponse;
	}
	
}
