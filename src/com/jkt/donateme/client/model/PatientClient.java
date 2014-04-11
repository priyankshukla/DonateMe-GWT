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
		boolean clientResponseStatusCode = false;
		final ClientConfig config = new DefaultClientConfig();
		final Client client = Client.create(config);
		final WebResource service = client.resource(getBaseURI());
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

}
