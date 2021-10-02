package com.tobstech.medicaldiagnosisapp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//json converter class
public class JsonConverter {
	
	private  JsonConverter() {}
    
	@SuppressWarnings("unchecked")
	public static <T> T jsonToObject(String jsonStr, Class<?> responseClassObject) {
		ObjectMapper objMapper = new ObjectMapper();
		T javaObject = null;
		try {
			javaObject = (T) objMapper.readValue(jsonStr, responseClassObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return javaObject;
	}
	
	public static String objectToJson(Object object) {
		ObjectMapper objMapper = new ObjectMapper();		
		String json = "";
		try {
			json = objMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
		}
		return json;
	}
	
	

}
