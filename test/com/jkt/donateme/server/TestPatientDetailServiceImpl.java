package com.jkt.donateme.server;

import junit.framework.TestCase;

import org.easymock.EasyMock;

import com.jkt.donateme.client.model.PatientClient;
import com.jkt.donateme.client.model.PatientClientImpl;
import com.jkt.donateme.client.model.SignUpFields;

public class TestPatientDetailServiceImpl extends TestCase {
	private PatientClient mockPatientClient;
	PatientDetailServiceImpl mockDetailServiceImpl;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mockPatientClient = EasyMock.createMock(PatientClient.class);

	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testsignUpserverForRegisterPatient() {
		SignUpFields actualSignUpFields = createSignUpFields();
		EasyMock.expect(mockPatientClient.registerPatient(actualSignUpFields))
				.andReturn(actualSignUpFields);

		EasyMock.replay();
		assertEquals("Adam", actualSignUpFields.getFirstName());
		assertEquals("Eve", actualSignUpFields.getLastName());
		assertEquals("Adam.eve@jktech.com", actualSignUpFields.getEmail());
		assertEquals("Female", actualSignUpFields.getGender());
		assertEquals("123456", actualSignUpFields.getPassword());
		EasyMock.verify();
	}

	public void testsignUpserverForRegisterPatientForNull() {
		SignUpFields expectedSignUpFields = createSignUpFields();
		EasyMock.expect(mockPatientClient.registerPatient(expectedSignUpFields))
				.andReturn(null);

		EasyMock.replay();
		assertEquals("Adam", expectedSignUpFields.getFirstName());
		assertEquals("Eve", expectedSignUpFields.getLastName());
		assertEquals("Adam.eve@jktech.com", expectedSignUpFields.getEmail());
		assertEquals("Female", expectedSignUpFields.getGender());
		assertEquals("123456", expectedSignUpFields.getPassword());
		EasyMock.verify();
	}

	SignUpFields createSignUpFields() {
		SignUpFields signUpFields = new SignUpFields();
		signUpFields.setFirstName("Adam");
		signUpFields.setLastName("Eve");
		signUpFields.setGender("Female");
		signUpFields.setEmail("Adam.eve@jktech.com");
		signUpFields.setPassword("123456");
		return signUpFields;

	}

}
