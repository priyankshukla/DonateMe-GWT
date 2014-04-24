package com.jkt.donateme.server;

import junit.framework.TestCase;

import org.easymock.EasyMock;

import com.jkt.donateme.client.model.PatientClient;
import com.jkt.donateme.client.model.PatientClientImpl;

public class TestEmailCheckServiceImpl extends TestCase {
	private PatientClient mockPatientClient;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mockPatientClient = EasyMock.createMock(PatientClient.class);

	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testvalidateDuplicateEmailForEmailDuplicate() {
		EasyMock.expect(mockPatientClient.validateEmail("abc@mgil.com"))
				.andReturn(true);
		EasyMock.replay();

		assertFalse(mockPatientClient.validateEmail("abc@mgil.com"));
		EasyMock.verify();

	}

	public void testvalidateDuplicateEmailForEmailNotDuplicate() {
		EasyMock.expect(mockPatientClient.validateEmail("abc@mgil.com"))
				.andReturn(false);
		EasyMock.replay();

		assertFalse(mockPatientClient.validateEmail("abc@mgil.com"));
		EasyMock.verify();

	}
	public void testvalidateDuplicateEmailForEmailNull() {
		EasyMock.expect(mockPatientClient.validateEmail("abc@mgil.com"))
				.andReturn(null);
		EasyMock.replay();

		assertFalse(mockPatientClient.validateEmail("abc@mgil.com"));
		EasyMock.verify();

	}
}
