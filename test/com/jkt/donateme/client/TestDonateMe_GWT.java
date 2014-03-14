package com.jkt.donateme.client;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;
import com.google.gwt.junit.client.GWTTestCase;
import com.jkt.donateme.client.presenter.SignUpPresenter;
import com.jkt.donateme.client.view.SignUpView;

public class TestDonateMe_GWT extends GWTTestCase {

	private EventBus eventBus;
	private SignUpView display;
	private SignUpPresenter presenter;

	@Override
	public String getModuleName() {
		return "com.jkt.donateme.DonateMe_GWT";
	}

	public void gwtSetUp() {
		eventBus = new DefaultEventBus();
		display = new SignUpView();
		presenter = new SignUpPresenter(display, eventBus);
	}

	public void testPatientSignUpScreenView() {

		assertNotNull("Value at FirstName Textbox is never null", presenter
				.getDisplay().getfirstNameTextBox());
		assertNotNull("Value at lastName Textbox is never null", presenter
				.getDisplay().getlastNameTextBox());
		assertNotNull("Value at DateBox calendar is never null", presenter
				.getDisplay().getDob());
		assertNotNull("Value at Email Textbox is never null", presenter
				.getDisplay().getEmailTextBox());
		assertNotNull("Value at Password Textbox is never null", presenter
				.getDisplay().getPasswordTextBox());
		assertNotNull("Value at ConfirmPassword Textbox is never null",
				presenter.getDisplay().getConfirmPasswordTextBox());
		assertNotNull("GetStarted Button click never returns null", presenter
				.getDisplay().getbtnGetStarted());

	}

	public void testPatientSignUpViewBinding() {
		presenter.bind();
		presenter.doValidate();
		presenter.getSignUpFields();
		assertNotNull("SignUp fields never returns null",
				presenter.getSignUpFields());
	}

	public void testTextBoxesValuesNotEmpty() {
		presenter.bind();
		presenter.getDisplay().getfirstNameTextBox().setValue("PatientFN");
		presenter.getDisplay().getlastNameTextBox().setValue("PatientLN");
		
		presenter.getDisplay().getEmailTextBox().setValue("patient@jktech.com");
		presenter.getDisplay().getPasswordTextBox().setValue("password1");
		presenter.getDisplay().getConfirmPasswordTextBox()
				.setValue("password1");

		presenter.doValidate();

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

		assertEquals(
				"Presenter returning Confirm Password is same as expected",
				presenter.getDisplay().getConfirmPasswordTextBox().getValue(),
				presenter.getSignUpFields().getConfirmPassword());

	}

	public void testWhenUserDoNotEnterValues() {
		presenter.bind();
		presenter.getDisplay().getfirstNameTextBox().setValue(null);
		presenter.getDisplay().getlastNameTextBox().setValue(null);
		presenter.getDisplay().getDob().setValue(null);
		presenter.getDisplay().getEmailTextBox().setValue(null);
		presenter.getDisplay().getPasswordTextBox().setValue(null);
		presenter.getDisplay().getConfirmPasswordTextBox().setValue(null);
		presenter.doValidate();

		assertNull("FirstName should  be null", presenter.getSignUpFields()
				.getFirstName());
		assertNull("LastName should  be null", presenter.getSignUpFields()
				.getLastName());
		assertNull("DateBox calendar should  be null", presenter.getSignUpFields()
				.getDob());
		assertNull("Email should  be null", presenter.getSignUpFields()
				.getEmail());
		assertNull("Password should  be null", presenter.getSignUpFields()
				.getPassword());
		assertNull("ConfirmPassword should  be null", presenter
				.getSignUpFields().getConfirmPassword());
	}

	public void testWhenAllFieldsShouldBeValidate() {

		presenter.bind();
		presenter.getDisplay().getfirstNameTextBox().setValue("abcd");
		presenter.getDisplay().getlastNameTextBox().setValue("xyz");
		presenter.getDisplay().getEmailTextBox()
				.setValue("abcd.xyz@jktech.com");
		presenter.getDisplay().getPasswordTextBox().setValue("01234567");
		presenter.getDisplay().getConfirmPasswordTextBox().setValue("01234567");

		presenter.doValidate();
		assertEquals(presenter.getDisplay().getfirstNameTextBox().getValue(),
				presenter.getSignUpFields().getFirstName());
		assertEquals(presenter.getDisplay().getlastNameTextBox().getValue(),
				presenter.getSignUpFields().getLastName());
		assertEquals(presenter.getDisplay().getEmailTextBox().getValue(),
				presenter.getSignUpFields().getEmail());

		assertEquals(presenter.getDisplay().getPasswordTextBox().getValue(),
				presenter.getSignUpFields().getPassword());
		assertEquals(presenter.getDisplay().getConfirmPasswordTextBox()
				.getValue(), presenter.getSignUpFields().getConfirmPassword());

	}

	public void testWhenValuesAreInvalid() {

		presenter.bind();
		presenter.getDisplay().getfirstNameTextBox().setValue("abcd1234");
		presenter.getDisplay().getlastNameTextBox().setValue("xyz1234");
		presenter.getDisplay().getEmailTextBox().setValue("abcd@xyz@jkt.@com");
		presenter.getDisplay().getPasswordTextBox().setValue("01234567");
		presenter.getDisplay().getConfirmPasswordTextBox().setValue("01234567");

		presenter.doValidate();

		assertNotSame(presenter.getDisplay().getfirstNameTextBox().getValue(),
				presenter.getSignUpFields().getFirstName());

		assertNotSame(presenter.getDisplay().getlastNameTextBox().getValue(),
				presenter.getSignUpFields().getLastName());

		assertNotSame(presenter.getDisplay().getEmailTextBox().getValue(),
				presenter.getSignUpFields().getEmail());

		assertEquals(presenter.getDisplay().getPasswordTextBox().getValue(),
				presenter.getSignUpFields().getPassword());

		assertEquals(presenter.getDisplay().getConfirmPasswordTextBox()
				.getValue(), presenter.getSignUpFields().getConfirmPassword());
	}

	public void testWhenPasswordDoNotMatch() {

		presenter.getDisplay().getPasswordTextBox().setValue("01234");
		presenter.getDisplay().getConfirmPasswordTextBox().setValue("01234567");

		presenter.doValidate();

		assertNotSame(presenter.getDisplay().getPasswordTextBox().getValue(),
				presenter.getSignUpFields().getPassword());

		assertNotSame(presenter.getDisplay().getConfirmPasswordTextBox()
				.getValue(), presenter.getSignUpFields().getConfirmPassword());

	}

	public void testWhenPasswordIsLessThanSix() {

		presenter.getDisplay().getPasswordTextBox().setValue("012");
		presenter.getDisplay().getConfirmPasswordTextBox().setValue("012");

		presenter.doValidate();

		assertNotSame(presenter.getDisplay().getPasswordTextBox().getValue(),
				presenter.getSignUpFields().getPassword());

		assertNotSame(presenter.getDisplay().getConfirmPasswordTextBox()
				.getValue(), presenter.getSignUpFields().getConfirmPassword());

	}

	public void testWhenPasswordIsMoreThanTwelve() {

		presenter.getDisplay().getPasswordTextBox()
				.setValue("0123456789987654321");
		presenter.getDisplay().getConfirmPasswordTextBox()
				.setValue("0123456789987654321");

		presenter.doValidate();

		assertNotSame(presenter.getDisplay().getPasswordTextBox().getValue(),
				presenter.getSignUpFields().getPassword());
		assertNotSame(presenter.getDisplay().getConfirmPasswordTextBox()
				.getValue(), presenter.getSignUpFields().getConfirmPassword());

	}

	public void testwhenClickOnMaleRadioButton() {
		presenter.getDisplay().getmRadioButton().setValue(true);
		presenter.getDisplay().getfmRadioButton().setValue(false);
		presenter.doValidate();
		assertEquals("Male", presenter.getSignUpFields().getGender());
	}

	public void testwhenClickOnFemaleRadioButton() {
		presenter.getDisplay().getmRadioButton().setValue(false);
		presenter.getDisplay().getfmRadioButton().setValue(true);
		presenter.doValidate();
		assertEquals("female", presenter.getSignUpFields().getGender());

	}

	public void testwhenNoRadioButtonSelect() {
		presenter.getDisplay().getmRadioButton().setValue(false);
		presenter.getDisplay().getfmRadioButton().setValue(false);
		presenter.doValidate();
		assertNull("Gender should be null", presenter.getSignUpFields()
				.getGender());

	}

}
