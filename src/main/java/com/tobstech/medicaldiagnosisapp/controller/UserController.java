package com.tobstech.medicaldiagnosisapp.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tobstech.medicaldiagnosisapp.user.UserLoginRequest;
import com.tobstech.medicaldiagnosisapp.user.UserLoginResponse;
import com.tobstech.medicaldiagnosisapp.user.UserService;

@org.springframework.web.bind.annotation.RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//controller that handles user login
	@PostMapping("/login")
	@Transactional
	@CrossOrigin
	public UserLoginResponse login(@RequestBody UserLoginRequest userLoginRequest) {
		UserLoginResponse loginResponse = userService.login(userLoginRequest);
		return loginResponse;
	}
	
	
	
}
