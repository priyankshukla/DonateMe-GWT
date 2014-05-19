/*package com.jkt.donateme.client;

import junit.framework.TestCase;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jkt.donateme.client.model.BeneficiaryDetailsFields;
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
<<<<<<< HEAD
		ProfileDetailsField createprofileFields = Mockito
				.mock(ProfileDetailsField.class);
		;
=======
		BeneficiaryDetailsFields createprofileFields = Mockito.mock(BeneficiaryDetailsFields.class);;
>>>>>>> upstream/master
		createprofileFields.setTitleOfYourPagePanel("titles");
		createprofileFields.setDonationNeededPanel("10");
		createprofileFields.setReasonForRaisingFundsPanel("cancer");
		createprofileFields.setProfileSummaryPanel("hello");
		createprofileFields.setEndCollectingMoneyOnPanel("01/01/2014");
<<<<<<< HEAD
		ProfileDetailPresenter presenter = Mockito
				.mock(ProfileDetailPresenter.class);

		ProfileDetailsField pdf = createSignUpFields();

		Mockito.when(createprofileFields.getTitleOfYourPagePanel()).thenReturn(
				pdf.getTitleOfYourPagePanel());
		Mockito.when(createprofileFields.getDonationNeededPanel()).thenReturn(
				pdf.getDonationNeededPanel());
		Mockito.when(createprofileFields.getProfileSummaryPanel()).thenReturn(
				pdf.getProfileSummaryPanel());
		Mockito.when(createprofileFields.getReasonForRaisingFundsPanel())
				.thenReturn(pdf.getReasonForRaisingFundsPanel());
		Mockito.when(createprofileFields.getEndCollectingMoneyOnPanel())
				.thenReturn(pdf.getEndCollectingMoneyOnPanel());

	}

	ProfileDetailsField createSignUpFields() {
		ProfileDetailsField patientDetails = new ProfileDetailsField();
=======
		ProfileDetailPresenter presenter = Mockito.mock(ProfileDetailPresenter.class);
		   
		BeneficiaryDetailsFields pdf =createSignUpFields();
		
     Mockito.when(createprofileFields.getTitleOfYourPagePanel()).thenReturn(pdf.getTitleOfYourPagePanel());
     Mockito.when(createprofileFields.getDonationNeededPanel()).thenReturn(pdf.getDonationNeededPanel());
     Mockito.when(createprofileFields.getProfileSummaryPanel()).thenReturn(pdf.getProfileSummaryPanel());
     Mockito.when(createprofileFields.getReasonForRaisingFundsPanel()).thenReturn(pdf.getReasonForRaisingFundsPanel());
     Mockito.when(createprofileFields.getEndCollectingMoneyOnPanel()).thenReturn(pdf.getEndCollectingMoneyOnPanel());


	

	}
	
	BeneficiaryDetailsFields createSignUpFields() {
		BeneficiaryDetailsFields patientDetails = new BeneficiaryDetailsFields();
>>>>>>> upstream/master
		patientDetails.setTitleOfYourPagePanel("titles");
		patientDetails.setDonationNeededPanel("10");
		patientDetails.setProfileSummaryPanel("hello");
		patientDetails.setReasonForRaisingFundsPanel("cancer");
		patientDetails.setEndCollectingMoneyOnPanel("01/01/2014");

		return patientDetails;

	}

	public void testRegisterPatientWithNullvalues() {
<<<<<<< HEAD
		ProfileDetailsField createprofileFields = Mockito
				.mock(ProfileDetailsField.class);
		;
=======
		BeneficiaryDetailsFields createprofileFields = Mockito.mock(BeneficiaryDetailsFields.class);;
>>>>>>> upstream/master
		createprofileFields.setTitleOfYourPagePanel(null);
		createprofileFields.setDonationNeededPanel(null);
		createprofileFields.setReasonForRaisingFundsPanel(null);
		createprofileFields.setProfileSummaryPanel(null);
		createprofileFields.setEndCollectingMoneyOnPanel(null);
<<<<<<< HEAD
		ProfileDetailPresenter presenter = Mockito
				.mock(ProfileDetailPresenter.class);

		ProfileDetailsField pdf = createSignUpFields();

		Mockito.when(createprofileFields.getTitleOfYourPagePanel()).thenReturn(
				pdf.getTitleOfYourPagePanel());
		Mockito.when(createprofileFields.getDonationNeededPanel()).thenReturn(
				pdf.getDonationNeededPanel());
		Mockito.when(createprofileFields.getProfileSummaryPanel()).thenReturn(
				pdf.getProfileSummaryPanel());
		Mockito.when(createprofileFields.getReasonForRaisingFundsPanel())
				.thenReturn(pdf.getReasonForRaisingFundsPanel());
		Mockito.when(createprofileFields.getEndCollectingMoneyOnPanel())
				.thenReturn(pdf.getEndCollectingMoneyOnPanel());
=======
		ProfileDetailPresenter presenter = Mockito.mock(ProfileDetailPresenter.class);
		   
		BeneficiaryDetailsFields pdf =createSignUpFields();
		
     Mockito.when(createprofileFields.getTitleOfYourPagePanel()).thenReturn(pdf.getTitleOfYourPagePanel());
     Mockito.when(createprofileFields.getDonationNeededPanel()).thenReturn(pdf.getDonationNeededPanel());
     Mockito.when(createprofileFields.getProfileSummaryPanel()).thenReturn(pdf.getProfileSummaryPanel());
     Mockito.when(createprofileFields.getReasonForRaisingFundsPanel()).thenReturn(pdf.getReasonForRaisingFundsPanel());
     Mockito.when(createprofileFields.getEndCollectingMoneyOnPanel()).thenReturn(pdf.getEndCollectingMoneyOnPanel());


	
>>>>>>> upstream/master

	}

}*/
