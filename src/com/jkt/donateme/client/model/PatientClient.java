package com.jkt.donateme.client.model;

public interface PatientClient {
	public SignUpFields registerPatient(final SignUpFields signUpFields);
	public boolean validateEmail(final String email) ;
}
