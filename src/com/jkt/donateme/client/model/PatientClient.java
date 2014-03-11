package com.jkt.donateme.client.model;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class PatientClient {

	private static final PatientClient PATIENT_CLIENT = new PatientClient();

	private PatientClient() {
	}

	public static PatientClient getInstance() {

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

		final ClientConfig config = new DefaultClientConfig();
		final Client client = Client.create(config);
		final WebResource service = client.resource(getBaseURI());
		final ClientResponse clientResponse = service.path("donateme")
				.path("patient").path("signup").accept(MediaType.TEXT_XML)
				.post(ClientResponse.class, signUpFields);
		System.out.println(clientResponse.getStatus());
		System.out.println(clientResponse.getEntity(SignUpFields.class));
		return signUpFields;
	}

	/**
	 * This method contains the URI for the service.
	 * 
	 * @return URI "http://localhost:8080/DonatemeWS"
	 */
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/DonatemeWS").build();
	}

}
