package com.jkt.donateme.client.model;

import junit.framework.TestCase;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestPatientClient extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		MockitoAnnotations.initMocks(this);

	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testRegisterPatient() {
		PatientClientImpl pc = Mockito.mock(PatientClientImpl.class);

		Mockito.when(pc.getClient()).thenReturn(
				PatientClientImpl.getInstance().getClient());
		Mockito.when(pc.getConfig()).thenReturn(
				PatientClientImpl.getInstance().getConfig());
		Mockito.when(pc.getService()).thenReturn(
				PatientClientImpl.getInstance().getService());

		SignUpFields expectedSignUpFields = createSignUpFields();
		Mockito.when(pc.registerPatient(expectedSignUpFields)).thenReturn(
				expectedSignUpFields);
		assertFalse(pc.isClientResponseStatusCode());

	}

	SignUpFields createSignUpFields() {
		SignUpFields signUpFields = new SignUpFields();
		signUpFields.setFirstName("Shruti");
		signUpFields.setLastName("Tripathi");
		signUpFields.setGender("Female");
		signUpFields.setEmail("shruti.tripathi@jktech.com");
		signUpFields.setPassword("123456");
		return signUpFields;

	}

	ClientResponse getDummyResponse() {
		ClientResponse cr = new ClientResponse(0, null, null, null);
		cr.setStatus(200);
		return cr;
	}

	public void testValidateEmail() {
		WebResource service = Client.create().resource(
				"http://localhost:8080/DonatemeWS");
		WebResource mockSercvice = Mockito.mock(WebResource.class);
		PatientClientImpl patientClient = PatientClientImpl.getInstance();
		patientClient.setService(service);

		ClientResponse clientResponse = new ClientResponse(2, null, null, null);

		Mockito.when(mockSercvice.path("donateme")).thenReturn(service);
		Mockito.when(mockSercvice.path("patient")).thenReturn(service);
		Mockito.when(mockSercvice.path("signup")).thenReturn(service);
		Mockito.when(mockSercvice.post(ClientResponse.class, null)).thenReturn(
				clientResponse);

		assertFalse(patientClient.isClientResponseStatusCode());

	}

}