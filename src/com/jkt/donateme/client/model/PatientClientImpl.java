package com.jkt.donateme.client.model;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class PatientClientImpl {

	private static final PatientClientImpl PATIENT_CLIENT = new PatientClientImpl();
	private boolean clientResponseStatusCode = false;

	

	private PatientClientImpl() {
	}
	ClientConfig config = new DefaultClientConfig();
	 Client client = Client.create(config);
	 WebResource service = client.resource(getBaseURI());
	 
	public static PatientClientImpl getInstance() {

		return PATIENT_CLIENT;

	}

	/**
	 * This method integrate client web resource to the service and returns the
	 * sign up fields for the patient in the form of an object.
	 * 
	 * @param signUpFields
	 * @return signUpFields
	 */
	public SignUpFields registerPatient(final SignUpFields signUpFields) {

		
		final ClientResponse clientResponse = service.path("donateme")
				.path("patient").path("signup").accept(MediaType.TEXT_XML)
				.post(ClientResponse.class, signUpFields);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
				+ clientResponse);
		System.out.println(">>>>>>>>>>>>" + clientResponse.getStatus());
		System.out.println(">>>>>>>>>>>>inputStremfor real service "
				+ clientResponse.getEntityInputStream());
		System.out.println(">>>>>>>>>>>>Tag for real service "
				+ clientResponse.getEntityTag());
		System.out.println(">>>>>>>>>>>>class for real service"
				+ clientResponse.getEntity(String.class));

		return signUpFields;
	}
/**
 * Validating email for client response
 * @param email
 * @return flag
 */
	public boolean validateEmail(final String email) {
		final ClientResponse clientResponse = service.path("donateme")
				.path("patient").path("email").accept(MediaType.TEXT_XML)
				.post(ClientResponse.class, email);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "
				+ clientResponse);
		System.out.println(">>>>>>>>>>>>status for email service  "
				+ clientResponse.getStatus());
		System.out.println(">>>>>>>>>>>>inputStrem for email service "
				+ clientResponse.getEntityInputStream());
		System.out.println(">>>>>>>>>>>>Tag for email service "
				+ clientResponse.getEntityTag());
		System.out.println(">>>>>>>>>>>>class for email service "
				+ clientResponse.getEntity(String.class));
		int stausCode = clientResponse.getStatus();
		if (stausCode == 2) {
			clientResponseStatusCode = true;
		}
		System.out.println("flag " + clientResponseStatusCode);
		return clientResponseStatusCode;
	}

	/**
	 * This method contains the URI for the service.
	 * 
	 * @return URI "http://localhost:8080/DonatemeWS"
	 */
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/DonatemeWS").build();
	}
	/**
	 * 
	 * @return PATIENT_CLIENT
	 */
	public static PatientClientImpl getPatientClient() {
		return PATIENT_CLIENT;
	}
/**
 * 
 * @return config
 */
	public ClientConfig getConfig() {
		return config;
	}
/**
 * 
 * @return client
 */
	public Client getClient() {
		return client;
	}
/**
 * 
 * @return service
 */
	public WebResource getService() {
		return service;
	}
/**
 * 
 * @param config
 */
	public void setConfig(ClientConfig config) {
		this.config = config;
	}
/**
 * 
 * @param client
 */
	public void setClient(Client client) {
		this.client = client;
	}
/**
 * 
 * @param service
 */
	public void setService(WebResource service) {
		this.service = service;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isClientResponseStatusCode() {
		return clientResponseStatusCode;
	}
/**
 * 
 * @param clientResponseStatusCode
 */
	public void setClientResponseStatusCode(boolean clientResponseStatusCode) {
		this.clientResponseStatusCode = clientResponseStatusCode;
	}
}
