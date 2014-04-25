package com.jkt.donateme.client;

import junit.framework.TestCase;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jkt.donateme.client.model.ProfileDetailsField;
import com.jkt.donateme.client.presenter.ProfileDetailPresenter;

public class TestProfileDetails extends TestCase {

	
	String[] profileid = { "titleOfYourPageTextBox", "donationNeededTextBox",
			"reasonForRaisingFundsTextBox", "profileSummaryTextArea", "dateBox" };


	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		MockitoAnnotations.initMocks(this);

	}
	

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public void testPatientProfile() {
		ProfileDetailsField createprofileFields = Mockito.mock(ProfileDetailsField.class);;
		createprofileFields.setTitleOfYourPagePanel("titles");
		createprofileFields.setDonationNeededPanel("10");
		createprofileFields.setReasonForRaisingFundsPanel("cancer");
		createprofileFields.setProfileSummaryPanel("hello");
		createprofileFields.setEndCollectingMoneyOnPanel("01/01/2014");
		ProfileDetailPresenter presenter = Mockito.mock(ProfileDetailPresenter.class);
		   
		ProfileDetailsField pdf =createSignUpFields();
		
     Mockito.when(createprofileFields.getTitleOfYourPagePanel()).thenReturn(pdf.getTitleOfYourPagePanel());
     Mockito.when(createprofileFields.getDonationNeededPanel()).thenReturn(pdf.getDonationNeededPanel());
     Mockito.when(createprofileFields.getProfileSummaryPanel()).thenReturn(pdf.getProfileSummaryPanel());
     Mockito.when(createprofileFields.getReasonForRaisingFundsPanel()).thenReturn(pdf.getReasonForRaisingFundsPanel());
     Mockito.when(createprofileFields.getEndCollectingMoneyOnPanel()).thenReturn(pdf.getEndCollectingMoneyOnPanel());


	

	}
	
	ProfileDetailsField createSignUpFields() {
		ProfileDetailsField patientDetails = new ProfileDetailsField();
		patientDetails.setTitleOfYourPagePanel("titles");
		patientDetails.setDonationNeededPanel("10");
		patientDetails.setProfileSummaryPanel("hello");
		patientDetails.setReasonForRaisingFundsPanel("cancer");
		patientDetails.setEndCollectingMoneyOnPanel("01/01/2014");
		
		return patientDetails;

	}
	
	
	public void testRegisterPatientWithNullvalues() {
		ProfileDetailsField createprofileFields = Mockito.mock(ProfileDetailsField.class);;
		createprofileFields.setTitleOfYourPagePanel(null);
		createprofileFields.setDonationNeededPanel(null);
		createprofileFields.setReasonForRaisingFundsPanel(null);
		createprofileFields.setProfileSummaryPanel(null);
		createprofileFields.setEndCollectingMoneyOnPanel(null);
		ProfileDetailPresenter presenter = Mockito.mock(ProfileDetailPresenter.class);
		   
		ProfileDetailsField pdf =createSignUpFields();
		
     Mockito.when(createprofileFields.getTitleOfYourPagePanel()).thenReturn(pdf.getTitleOfYourPagePanel());
     Mockito.when(createprofileFields.getDonationNeededPanel()).thenReturn(pdf.getDonationNeededPanel());
     Mockito.when(createprofileFields.getProfileSummaryPanel()).thenReturn(pdf.getProfileSummaryPanel());
     Mockito.when(createprofileFields.getReasonForRaisingFundsPanel()).thenReturn(pdf.getReasonForRaisingFundsPanel());
     Mockito.when(createprofileFields.getEndCollectingMoneyOnPanel()).thenReturn(pdf.getEndCollectingMoneyOnPanel());


	

	}

	

	
	

}