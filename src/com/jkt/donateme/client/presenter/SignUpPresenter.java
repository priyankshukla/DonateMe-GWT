package com.jkt.donateme.client.presenter;

import java.util.Date;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.datepicker.client.DateBox;
import com.jkt.donateme.client.model.SignUpFields;
import com.jkt.donateme.client.rpc.SignUpService;
import com.jkt.donateme.client.rpc.SignUpServiceAsync;
import com.jkt.donateme.client.validation.EmailValidator;

public class SignUpPresenter extends WidgetPresenter<SignUpPresenter.Display> {

	private SignUpFields signUpFields;
	private final SignUpServiceAsync signUpService = GWT
			.create(SignUpService.class);
	private EmailValidator validemail;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword ;
	private Date dateOfBirth;
	private boolean maleGender;
	private boolean femaleGender;
	public boolean isFirstname = true;
	public boolean isLastname = true;
	public boolean isEmail = true;
	public boolean ispassword = true;
	public boolean isConfirmpassword = true;
	public boolean isFirstValidate = true;
	public boolean isLastValidate = true;
	public boolean isEmailValidate = true;
	public boolean isShortPasswordValidate = true;
	public boolean isConfirmpasswordValidate = true;
	public boolean isLongPassdValidate = true;
	public boolean isGender = false;
	public boolean isDob = true;
	private boolean isFirstTime = true;
	public String gender;

	public interface Display extends WidgetDisplay {

		public HasValue<String> getfirstNameTextBox();

		public HasValue<String> getlastNameTextBox();

		public HasValue<String> getEmailTextBox();

		public HasValue<String> getPasswordTextBox();

		public HasValue<String> getConfirmPasswordTextBox();

		public HasClickHandlers getbtnGetStarted();

		public RadioButton getmRadioButton();

		public RadioButton getfmRadioButton();

		public DateBox getDob();

		public void setRedColor(boolean isFirstname, boolean isLastname,
				boolean isEmail, boolean ispassword, boolean isConfirmpassword,
				boolean isGender, boolean isDob);

		public void setValidateFormat(boolean isFirstValidate,
				boolean isLastValidate, boolean isEmailValidate,
				boolean isShortPasswordValidate, boolean isConfirmpasswordValidate,
				boolean isLongPassdValidate);

		public void removeError();

	}

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */

	public SignUpPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
	}

	/*
	 * Adds Click Handler To GetStarted Button .
	 */
	ClickHandler clickHandler = new ClickHandler() {

		public void onClick(ClickEvent arg0) {
			isFirstTime = false;
			clearAllError();
			doValidate();
		}
	};

	/**
	 * Adds ValueChangeHandler To All Text Boxes .
	 */
	ValueChangeHandler<String> valueChangeHandler = new ValueChangeHandler<String>() {

		public void onValueChange(ValueChangeEvent<String> arg0) {
			clearAllError();
			if (!isFirstTime)
				doValidate();

		}

	};

	/**
	 * Adds ValueChangeHandler To Date Box .
	 */
	ValueChangeHandler<Date> dateboxhandler = new ValueChangeHandler<Date>() {

		public void onValueChange(ValueChangeEvent<Date> arg0) {
			clearAllError();
			if (!isFirstTime)
				doValidate();
		}

	};

	/**
	 * Binds data on click.
	 */
	@Override
	protected void onBind() {

		/**
		 * For GetStartedButton .
		 */
		display.getbtnGetStarted().addClickHandler(clickHandler);

		/**
		 * For Text Boxes .
		 */
		display.getfirstNameTextBox().addValueChangeHandler(valueChangeHandler);
		display.getlastNameTextBox().addValueChangeHandler(valueChangeHandler);
		display.getEmailTextBox().addValueChangeHandler(valueChangeHandler);
		display.getDob().addValueChangeHandler(dateboxhandler);
		display.getPasswordTextBox().addValueChangeHandler(valueChangeHandler);
		display.getConfirmPasswordTextBox().addValueChangeHandler(valueChangeHandler);

	}
	
	public void getfields(){
		firstName = display.getfirstNameTextBox().getValue();
		lastName = display.getlastNameTextBox().getValue();
		email = display.getEmailTextBox().getValue();
		maleGender = display.getmRadioButton().getValue();
		femaleGender = display.getfmRadioButton().getValue();
		dateOfBirth= display.getDob().getValue();
		password = display.getPasswordTextBox().getValue();
		confirmPassword = display.getConfirmPasswordTextBox().getValue();

	}

	/**
	 * It retrieves all the data from the textbox fields.
	 */
	public void doValidate() {

		signUpFields = new SignUpFields();
		validemail = new EmailValidator();
		getfields();
		
		/*
		 * validate first name using pattern matches
		 */
		if (firstName == null || firstName.isEmpty()) {
			isFirstname = false;
		} else if (validemail.usernameValidate(firstName) == false) {
			isFirstValidate = false;
		} else {
			signUpFields.setFirstName(firstName);

		}

		/*
		 * validate lastname using pattern matches
		 */
		if (lastName == null || lastName.isEmpty()) {
			isLastname = false;
		} else if (validemail.usernameValidate(lastName) == false) {
			isLastValidate = false;
		} else {
			signUpFields.setLastName(lastName);
		}

		/*
		 * validate email-id using pattern matches
		 */
		if (email == null || email.isEmpty()) {
			isEmail = false;
		} else if (validemail.validate(email) == false) {
			isEmailValidate = false;
		} else {
			signUpFields.setEmail(email);
		}

		/*
		 * validate gender radio button for male or female
		 */
		if ((maleGender == false) && (femaleGender == false)) {
			isGender = false;
		} else if (maleGender == true) {
			isGender = true;
			gender = "Male";
			signUpFields.setGender(gender);
		} else if (femaleGender == true) {
			isGender = true;
			gender = "female";
			signUpFields.setGender(gender);
		}

		/*
		 * validate date of birth 
		 */
		if (dateOfBirth == null) {
			isDob = false;
		} else {
			isDob = true;
			// signUpFields.setDob(dob);
		}

		/*
		 * validate password i.e between 6 to 12 characters
		 */
		
		if (password == null || password.isEmpty()) {
			ispassword = false;
		} else if (password.length() < 6) {
			isShortPasswordValidate = false;
		} else if (password.length() > 12) {
			isLongPassdValidate = false;
		} else {
			signUpFields.setPassword(password);
		}

		/*
		 * validate confirm password 
		 */
		
		if (confirmPassword == null || confirmPassword.isEmpty()) {
			isConfirmpassword = false;
		} else if ((!password.equals(confirmPassword))) {
			isConfirmpasswordValidate = false;
		} else {
			signUpFields.setConfirmPassword(confirmPassword);
		}

		
		display.setRedColor(isFirstname, isLastname, isEmail, ispassword,
				isConfirmpassword, isGender, isDob);
		display.setValidateFormat(isFirstValidate, isLastValidate,
				isEmailValidate, isShortPasswordValidate, isConfirmpasswordValidate,
				isLongPassdValidate);

		validateSendToServer();

	}

	public void validateSendToServer() {

		if (signUpFields.getFirstName() != null
				&& signUpFields.getLastName() != null
				&& signUpFields.getEmail() != null
				&& signUpFields.getGender() != null
				&& signUpFields.getPassword() != null
				&& signUpFields.getConfirmPassword() != null) {
			sendToServer();

		}

	}

	/**
	 * on the click of getstart button the field values are send to server.
	 */
	public void sendToServer() {

		signUpService.signUpServer(signUpFields,
				new AsyncCallback<SignUpFields>() {
					public void onFailure(Throwable caught) {

					}

					public void onSuccess(SignUpFields signUpFields) {

					}
				});

	}

	/**
	 * Need to be implemented
	 */
	public void refreshDisplay() {
		// This is called when the presenter should pull the latest data
		// from the server, etc. In this case, there is nothing to do.
	}

	/**
	 * Need to be implemented
	 */
	public void revealDisplay() {
		// Nothing to do. This is more useful in UI which may be buried
		// in a tab bar, tree, etc.
	}

	/**
	 * Need to be implemented
	 */
	protected void onPlaceRequest(PlaceRequest request) {
		// Grab the 'name' from the request and put it into the 'name' field.
		// This allows a tag of '#HelloWorld;name=Foo' to populate the name
		// field.

	}

	/**
	 * Need to be implemented
	 */
	@Override
	protected void onRevealDisplay() {
		// TODO Auto-generated method stub

	}

	/**
	 * Need to be implemented
	 */
	@Override
	protected void onUnbind() {
		// TODO Auto-generated method stub

	}

	/**
	 * This method directs the click on the get started button to fetch all the
	 * values of the textbox.
	 */
	/*
	 * public void onClick(ClickEvent arg0) { clearAllError(); getData();
	 * 
	 * }
	 */

	public void clearAllError() {
		isFirstname = true;
		isLastname = true;
		isEmail = true;
		ispassword = true;
		isConfirmpassword = true;
		isFirstValidate = true;
		isLastValidate = true;
		isEmailValidate = true;
		isShortPasswordValidate = true;
		isLongPassdValidate = true;
		isConfirmpasswordValidate = true;
		display.removeError();
	}

	/**
	 * getter for signUp fields
	 * 
	 * @return
	 */
	public SignUpFields getSignUpFields() {
		return signUpFields;
	}

}
