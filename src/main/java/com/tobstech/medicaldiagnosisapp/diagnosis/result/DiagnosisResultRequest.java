package com.tobstech.medicaldiagnosisapp.diagnosis.result;

//get diagnosis result parameter definition
public class DiagnosisResultRequest {
	
	private String requestPatientReserved;
	private String requestSelectedCheckboxes;
	private String requestSymtomsListInName;
	private String requestDataExchangeDiagnosisResult;
	private String requestValidInvalidResult;
	
	public DiagnosisResultRequest() {}

	public DiagnosisResultRequest(String requestPatientReserved, String requestSelectedCheckboxes,
			String requestSymtomsListInName, String requestDataExchangeDiagnosisResult,
			String requestValidInvalidResult) {
		super();
		this.requestPatientReserved = requestPatientReserved;
		this.requestSelectedCheckboxes = requestSelectedCheckboxes;
		this.requestSymtomsListInName = requestSymtomsListInName;
		this.requestDataExchangeDiagnosisResult = requestDataExchangeDiagnosisResult;
		this.requestValidInvalidResult = requestValidInvalidResult;
	}

	public String getRequestPatientReserved() {
		return requestPatientReserved;
	}

	public void setRequestPatientReserved(String requestPatientReserved) {
		this.requestPatientReserved = requestPatientReserved;
	}

	public String getRequestSelectedCheckboxes() {
		return requestSelectedCheckboxes;
	}

	public void setRequestSelectedCheckboxes(String requestSelectedCheckboxes) {
		this.requestSelectedCheckboxes = requestSelectedCheckboxes;
	}

	public String getRequestSymtomsListInName() {
		return requestSymtomsListInName;
	}

	public void setRequestSymtomsListInName(String requestSymtomsListInName) {
		this.requestSymtomsListInName = requestSymtomsListInName;
	}

	public String getRequestDataExchangeDiagnosisResult() {
		return requestDataExchangeDiagnosisResult;
	}

	public void setRequestDataExchangeDiagnosisResult(String requestDataExchangeDiagnosisResult) {
		this.requestDataExchangeDiagnosisResult = requestDataExchangeDiagnosisResult;
	}

	public String getRequestValidInvalidResult() {
		return requestValidInvalidResult;
	}

	public void setRequestValidInvalidResult(String requestValidInvalidResult) {
		this.requestValidInvalidResult = requestValidInvalidResult;
	}	
	
}
