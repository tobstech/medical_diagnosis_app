/* Title: Medical Diagnosis App
 * 
 * Author: Abdulfatai Toyeeb Muhammad
 * 
 */

package com.tobstech.medicaldiagnosisapp;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootApplication
public class MedicaldiagnosisappApplication {

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, JsonMappingException, JsonProcessingException {
		SpringApplication.run(MedicaldiagnosisappApplication.class, args);
	}

}
