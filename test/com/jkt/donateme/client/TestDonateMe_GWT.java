package com.jkt.donateme.client;

import java.util.Date;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.junit.client.GWTTestCase;
import com.jkt.donateme.client.presenter.ProfileDetailPresenter;
import com.jkt.donateme.client.presenter.SignUpPresenter;
import com.jkt.donateme.client.view.ProfileDetailView;
import com.jkt.donateme.client.view.SignUpView;

public class TestDonateMe_GWT extends GWTTestCase {

	private EventBus eventBus;
	private SignUpView display;
	private SignUpPresenter presenter;
	
	String[] id = {"firstNameTextBox","lastNameTextBox","dateBox","Gender","emailTextBox","passwordTextBox","confirmPasswordTextBox"};
    Date date;
    
	private EventBus profileeventBus;
    private ProfileDetailView profiledisplay;
	private ProfileDetailPresenter profilepresenter;
	String[] profileid = { "titleOfYourPageTextBox", "donationNeededTextBox",
			"reasonForRaisingFundsTextBox", "profileSummaryTextArea",
			"dateBox" };


	@Override
	public String getModuleName() {
		return "com.jkt.donateme.DonateMe_GWT";
	}

	public void gwtSetUp() {
		eventBus = new DefaultEventBus();
		display = new SignUpView();
		presenter = new SignUpPresenter(display, eventBus);
		
		
		profileeventBus = new DefaultEventBus();
		profiledisplay = new ProfileDetailView();
		profilepresenter = new ProfileDetailPresenter(profiledisplay, profileeventBus);
	}

	

	public void testPatientSignUpViewBinding() {
		presenter.bind();
		presenter.doValidation(id);
		presenter.getSignUpFields();
		
		assertNotNull("SignUp fields never returns null",
				presenter.getSignUpFields());
	}

	public void testTextBoxesValuesNotEmpty() {
		
		date = new Date();
		presenter.bind();
		presenter.getDisplay().getfirstNameTextBox().setValue("ankita");
		presenter.getDisplay().getlastNameTextBox().setValue("nischal");
		presenter.getDisplay().getDob().setValue(date);
		presenter.getDisplay().getfmRadioButton().setEnabled(true);
		presenter.getDisplay().getmRadioButton().setEnabled(false);

		presenter.getDisplay().getEmailTextBox().setValue("ankita.nischal@jktech.com");
		presenter.getDisplay().getPasswordTextBox().setValue("password12");
		
		presenter.getDisplay().getConfirmPasswordTextBox().setValue("password12");
		
		

		presenter.doValidation(id);

		assertEquals("Presenter returning Firstname is same as expected ",
				presenter.getDisplay().getfirstNameTextBox().getValue(),
				presenter.getSignUpFields().getFirstName());
		assertEquals("Presenter returning Lastname is same as expected",
				presenter.getDisplay().getlastNameTextBox().getValue(),
				presenter.getSignUpFields().getLastName());
		assertEquals("presenter returning Email is same as expected", presenter
				.getDisplay().getEmailTextBox().getValue(), presenter
				.getSignUpFields().getEmail());
		assertEquals("Presenter returning Password is same as expected",
				presenter.getDisplay().getPasswordTextBox().getValue(),
				presenter.getSignUpFields().getPassword());


	}

	public void testWhenUserDoNotEnterValues() {
		presenter.bind();
		presenter.getDisplay().getfirstNameTextBox().setValue(null);
		presenter.getDisplay().getlastNameTextBox().setValue(null);
		presenter.getDisplay().getDob().setValue(null);
		
		presenter.getDisplay().getEmailTextBox().setValue(null);
		presenter.getDisplay().getPasswordTextBox().setValue(null);
		presenter.getDisplay().getConfirmPasswordTextBox().setValue(null);
		presenter.doValidation(id);

		assertNull("FirstName should  be null", presenter.getSignUpFields()
				.getFirstName());
		assertNull("LastName should  be null", presenter.getSignUpFields()
				.getLastName());
		assertNull("DateBox calendar should  be null", presenter.getSignUpFields()
				.getDob());
		assertNull(presenter.getSignUpFields().getGender());
		assertNull("Email should  be null", presenter.getSignUpFields()
				.getEmail());
		assertNull("Password should  be null", presenter.getSignUpFields()
				.getPassword());
		
	}

	public void testWhenAllFieldsShouldBeValidate() {

		presenter.bind();
		presenter.getDisplay().getfirstNameTextBox().setValue("abcd");
		presenter.getDisplay().getlastNameTextBox().setValue("xyz");
		presenter.getDisplay().getEmailTextBox()
				.setValue("abcd.xyz@jktech.com");
		presenter.getDisplay().getPasswordTextBox().setValue("01234567");
		presenter.getDisplay().getConfirmPasswordTextBox().setValue("01234567");

		presenter.doValidation(id);

		assertEquals(presenter.getDisplay().getfirstNameTextBox().getValue(),
				presenter.getSignUpFields().getFirstName());
		assertEquals(presenter.getDisplay().getlastNameTextBox().getValue(),
				presenter.getSignUpFields().getLastName());
		assertEquals(presenter.getDisplay().getEmailTextBox().getValue(),
				presenter.getSignUpFields().getEmail());

		assertEquals(presenter.getDisplay().getPasswordTextBox().getValue(),
				presenter.getSignUpFields().getPassword());
	
	}

	public void testWhenValuesAreInvalid() {
		Date dateobj = new Date();
		dateobj.setDate(dateobj.getDate()+1);
		presenter.bind();
		presenter.getDisplay().getfirstNameTextBox().setValue("abcd1234");
		presenter.getDisplay().getlastNameTextBox().setValue("xyz1234");
		presenter.getDisplay().getEmailTextBox().setValue("abcd@xyz@jkt.@com");
		presenter.getDisplay().getDob().setValue(dateobj);
		presenter.getDisplay().getPasswordTextBox().setValue("01234567");
		presenter.getDisplay().getConfirmPasswordTextBox().setValue("01234567");

		presenter.doValidation(id);

		assertNotSame(presenter.getDisplay().getfirstNameTextBox().getValue(),
				presenter.getSignUpFields().getFirstName());

		assertNotSame(presenter.getDisplay().getlastNameTextBox().getValue(),
				presenter.getSignUpFields().getLastName());

		assertNotSame(presenter.getDisplay().getEmailTextBox().getValue(),
				presenter.getSignUpFields().getEmail());
      assertNotSame("dfdss" , presenter.getDisplay().getDob().getValue(), presenter.getSignUpFields().getDob());

		
		assertEquals(presenter.getDisplay().getPasswordTextBox().getValue(),
				presenter.getSignUpFields().getPassword());

		
	}

	public void testWhenPasswordDoNotMatch() {

		presenter.getDisplay().getPasswordTextBox().setValue("4343424");
		presenter.getDisplay().getConfirmPasswordTextBox().setValue("01234567");

		presenter.doValidation(id);

		assertNotSame(presenter.getDisplay().getPasswordTextBox().getValue(),
				presenter.getSignUpFields().getPassword());

	}

	public void testWhenPasswordIsLessThanSix() {

		presenter.getDisplay().getPasswordTextBox().setValue("012");
		presenter.getDisplay().getConfirmPasswordTextBox().setValue("012");

		presenter.doValidation(id);

		assertNotSame(presenter.getDisplay().getPasswordTextBox().getValue(),
				presenter.getSignUpFields().getPassword());

	

	}

	public void testWhenPasswordIsMoreThanTwelve() {

		presenter.getDisplay().getPasswordTextBox()
				.setValue("0123456789987654321");
		presenter.getDisplay().getConfirmPasswordTextBox()
				.setValue("0123456789987654321");

		presenter.doValidation(id);

		assertNotSame(presenter.getDisplay().getPasswordTextBox().getValue(),
				presenter.getSignUpFields().getPassword());
		

	}

	public void testwhenClickOnMaleRadioButton() {
		presenter.getDisplay().getmRadioButton().setValue(true);
		presenter.getDisplay().getfmRadioButton().setValue(false);
		presenter.doValidation(id);
		assertEquals("Male", presenter.getSignUpFields().getGender());
	}

	public void testwhenClickOnFemaleRadioButton() {
		presenter.getDisplay().getmRadioButton().setValue(false);
		presenter.getDisplay().getfmRadioButton().setValue(true);
		presenter.doValidation(id);
		assertEquals("female", presenter.getSignUpFields().getGender());

	}

	public void testwhenNoRadioButtonSelect() {
		presenter.getDisplay().getmRadioButton().setValue(false);
		presenter.getDisplay().getfmRadioButton().setValue(false);
		presenter.doValidation(id);
		assertNull("Gender should be null", presenter.getSignUpFields()
				.getGender());

	}


	
}
