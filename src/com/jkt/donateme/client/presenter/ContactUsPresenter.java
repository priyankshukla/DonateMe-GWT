package com.jkt.donateme.client.presenter;

import java.util.Date;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.jkt.donateme.client.model.BeneficiaryDetailsFields;
import com.jkt.donateme.client.model.ContactusFeilds;
import com.jkt.donateme.client.model.SignUpFields;
import com.jkt.donateme.client.validation.EmailValidator;

public class ContactUsPresenter extends WidgetPresenter<ContactUsPresenter.Display>{
	
	
	

	private String firstName;
	private String subject;
	private String message;
	private String email;
	private String phoneNumber;
	private String containerId;
	private String valueHolder;

	private boolean isNull = false;
	private boolean isInValid = false;
	private boolean isPasswordShort = false;
	private boolean isPasswordLong = false;
	private boolean isClicked = false;
	

	private EmailValidator validemail;
	private ContactusFeilds contactusfields;
	public interface Display extends WidgetDisplay {

		public HasValue<String> getfirstNameTextBox();

		public HasValue<String> getsubjectTextBox();

		public HasValue<String> getEmailTextBox();
		
		
		public HasValue<String> getProfileSummaryTextArea();
		public HasValue<String> getPhoneNumberTextBox();


		

		public HasClickHandlers getbtnGetStarted();

		

		public void setStatus(String box, boolean isNull, boolean isInValid,
				boolean isPasswordShort, boolean isPasswordLong);

		
	}

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */

	public ContactUsPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
		
	}

	/*
	 * Adds Click Handler To GetStarted Button .
	 */

	ClickHandler clickHandler = new ClickHandler() {

		public void onClick(ClickEvent arg0) {

			isClicked = true;
			getfields(isClicked);

		}
	};

	BlurHandler blurHandler = new BlurHandler() {

		public void onBlur(BlurEvent event) {

			TextBox object = (TextBox) event.getSource();
			containerId = object.getName();
			isClicked = false;
			getfields(isClicked);

		}
	};

	FocusHandler focusHandler = new FocusHandler() {

		public void onFocus(FocusEvent event) {

			TextBox object = (TextBox) event.getSource();
			containerId = object.getName();
			getFieldsOnFocus();
		}
	};

	ValueChangeHandler<Date> vDhandler = new ValueChangeHandler<Date>() {

		public void onValueChange(ValueChangeEvent<Date> event) {

			DateBox object = (DateBox) event.getSource();
			containerId = object.getTextBox().getName();
			isClicked = false;
			getfields(isClicked);
		}
	};

	BlurHandler blurHandlerTextArea = new BlurHandler() {

		public void onBlur(BlurEvent event) {

			TextArea object = (TextArea) event.getSource();
			containerId = object.getName();
			isClicked = false;
			getfields(isClicked);

		}
	};
	
	
	FocusHandler focusHandlerTextArea = new FocusHandler() {

		public void onFocus(FocusEvent event) {

			TextArea object = (TextArea) event.getSource();
			containerId = object.getName();
			getFieldsOnFocus();
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

		

		((FocusWidget) display.getfirstNameTextBox())
				.addBlurHandler(blurHandler);
		((FocusWidget) display.getsubjectTextBox())
				.addBlurHandler(blurHandler);
		
		((FocusWidget) display.getEmailTextBox()).addBlurHandler(blurHandler);
		
		
		((FocusWidget) display.getProfileSummaryTextArea())
		.addBlurHandler(blurHandlerTextArea);
		((FocusWidget) display.getPhoneNumberTextBox())
		.addBlurHandler(blurHandler);

		
		// ----------------------------------------------------------------------------------

		((FocusWidget) display.getfirstNameTextBox())
				.addFocusHandler(focusHandler);
		((FocusWidget) display.getsubjectTextBox())
				.addFocusHandler(focusHandler);
		((FocusWidget) display.getEmailTextBox()).addFocusHandler(focusHandler);
		
		((FocusWidget) display.getProfileSummaryTextArea())
		.addFocusHandler(focusHandlerTextArea);
		
		((FocusWidget) display.getPhoneNumberTextBox())
		.addFocusHandler(focusHandler);
		

	}

	public void getfields(boolean way) {

		if (way) {
			String[] id = { "firstNameTextBox", "subjectTextBox", "emailTextBox", "profileSummaryTextArea","phoneNumberTextBox"};

			doValidation(id);
		} else {
			String[] id = { containerId };
			doValidation(id);
		}

	}

	public void getFieldsOnFocus() {

		String[] id = { containerId };
		getFocusStatus(id);
	}

	public void getFocusStatus(String[] id) {

		for (int i = 0; i < id.length; i++) {

			valueHolder = id[i];

			if (id[i].equalsIgnoreCase("firstNameTextBox")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid,
						isPasswordShort, isPasswordLong);

			} else if (id[i].equalsIgnoreCase("subjectTextBox")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid,
						isPasswordShort, isPasswordLong);
			}

			else if (id[i].equalsIgnoreCase("phoneNumberTextBox")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid,
						isPasswordShort, isPasswordLong);
			}

			else if (id[i].equalsIgnoreCase("emailTextBox")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid,
						isPasswordShort, isPasswordLong);
				
			} else if (id[i].equalsIgnoreCase("profileSummaryTextArea")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid,
						isPasswordShort, isPasswordLong);
			}

			

		}

	}

	public void doValidation(String[] id) {
		contactusfields = new ContactusFeilds();
		validemail = new EmailValidator();

		for (int i = 0; i < id.length; i++) {

			valueHolder = id[i];

			if (id[i].equalsIgnoreCase("firstNameTextBox")) {

				firstName = display.getfirstNameTextBox().getValue().trim();
				display.getfirstNameTextBox().setValue(firstName);

				if (firstName == null || firstName.isEmpty()) {
					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);

				} else if (validemail.stringValidate(firstName) == false) {
					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					contactusfields.setFirstName(firstName);
					

				}
			} else if (id[i].equalsIgnoreCase("subjectTextBox")) {

				subject = display.getsubjectTextBox().getValue().trim();
				display.getsubjectTextBox().setValue(subject);

				if (subject == null || subject.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);

				} else if (validemail.stringValidate(subject) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					contactusfields.setLastName(subject);

				}

			}
			//message
			else if (id[i].equalsIgnoreCase("profileSummaryTextArea")) {

				message = display.getProfileSummaryTextArea().getValue().trim();
				display.getProfileSummaryTextArea().setValue(message);

				if (message == null || message.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);

				} else if (validemail.stringValidate(message) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					contactusfields.setMessage(message);

				}

			}
			
	
			
			//phoneNumber
			
			
			else if (id[i].equalsIgnoreCase("phoneNumberTextBox")) {

				phoneNumber = display.getPhoneNumberTextBox().getValue().trim();
				display.getPhoneNumberTextBox().setValue(phoneNumber);

				if (phoneNumber == null || phoneNumber.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);

				} else if (validemail.integerValidate(phoneNumber) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					contactusfields.setPhoneNumber(phoneNumber);

				}
			}
			
			else if (id[i].equalsIgnoreCase("emailTextBox")) {

				email = display.getEmailTextBox().getValue().trim();
				display.getEmailTextBox().setValue(email);

				if (email == null || email.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);

				} else if (validemail.validate(email) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					contactusfields.setEmail(email);

				}
			}
		}
	}

	/**
	 * on the click of getStart button the field values are send to server.
	 */
	

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
	
	public ContactusFeilds getContactUsFeilds() {
		return contactusfields;
	}


}
