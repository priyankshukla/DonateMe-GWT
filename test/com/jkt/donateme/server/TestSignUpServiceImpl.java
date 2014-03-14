/*package com.jkt.donateme.server;

import junit.framework.TestCase;

import org.easymock.EasyMock;

import com.jkt.donateme.client.model.SignUpFields;
import com.sun.jersey.api.client.RequestBuilder;

public class TestSignUpServiceImpl extends TestCase {

	private SignUpServiceImpl signUpServiceImpl;
	private RequestBuilder requestBuilder;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		requestBuilder = EasyMock.createMock(RequestBuilder.class);

		signUpServiceImpl = new SignUpServiceImpl();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testRegisterPatient() {
		EasyMock.expect(requestBuilder.type("donateme")).andReturn(
				requestBuilder);
		EasyMock.expect(requestBuilder.type("signup"))
				.andReturn(requestBuilder);
		EasyMock.expect(requestBuilder.type("patient")).andReturn(
				requestBuilder);
		EasyMock.expect(requestBuilder.accept("text/xml")).andReturn(null);
		SignUpFields expectedSignUpFields = createSignUpFields();
		EasyMock.replay();
		SignUpFields actualSignUpFields = signUpServiceImpl
				.signUpServer(expectedSignUpFields);
		assertEquals("Shruti", actualSignUpFields.getFirstName());
		assertEquals("Tripathi", actualSignUpFields.getLastName());
		assertEquals("shruti.tripathi@jktech.com",
				actualSignUpFields.getEmail());
		assertEquals("Female", actualSignUpFields.getGender());
		assertEquals("123456", actualSignUpFields.getPassword());
		assertEquals("123456", actualSignUpFields.getConfirmPassword());

		EasyMock.verify();

	}

	SignUpFields createSignUpFields() {
		SignUpFields signUpFields = new SignUpFields();
		signUpFields.setFirstName("Shruti");
		signUpFields.setLastName("Tripathi");
		signUpFields.setGender("Female");
		signUpFields.setEmail("shruti.tripathi@jktech.com");
		signUpFields.setPassword("123456");
		signUpFields.setConfirmPassword("123456");
		return signUpFields;

	}

}
*/