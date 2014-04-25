package com.jkt.donateme.client.presenter;

import java.util.Date;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.jkt.donateme.client.model.SignUpFields;
import com.jkt.donateme.client.rpc.EmailCheckService;
import com.jkt.donateme.client.rpc.EmailCheckServiceAsync;
import com.jkt.donateme.client.rpc.SignUpService;
import com.jkt.donateme.client.rpc.SignUpServiceAsync;
import com.jkt.donateme.client.validation.EmailValidator;
import com.jkt.donateme.client.view.ProfileDetailView;


public class SignUpPresenter extends WidgetPresenter<SignUpPresenter.Display> {

	
	private final SignUpServiceAsync signUpService = GWT
			.create(SignUpService.class);
	private final EmailCheckServiceAsync emailCheckServiceAsync = GWT
			.create(EmailCheckService.class);
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	private String containerId ;
	private String gender;
    private String valueHolder ;
	
	private boolean isNull = false;
	private boolean isInValid = false ;
	private boolean isPasswordShort = false ;
	private boolean isPasswordLong = false ;
	private boolean isClicked = false;
	private boolean maleGender = false ;
	private boolean femaleGender = false ;
		
    private Date date = new Date();

    private Date dateOfBirth;
    private EmailValidator validemail;
	private SignUpFields signUpFields;
	private DateTimeFormat dateTimeFormat;
	
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

		public void setStatus(String box ,boolean isNull ,boolean isInValid , boolean isPasswordShort , boolean isPasswordLong);
		public void duplicateEmailError();
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
			
			isClicked = true ;
			getfields(isClicked);
			
		}
	};
	
	
	
	
	
	
	BlurHandler blurHandler = new BlurHandler(){

		public void onBlur(BlurEvent event) {
					
  			TextBox object = (TextBox) event.getSource();
  			containerId = object.getName();
  			isClicked = false ;
			getfields(isClicked);
  						
		}
	};
	
	
	FocusHandler focusHandler = new FocusHandler(){

		public void onFocus(FocusEvent event) {
			
			TextBox object = (TextBox) event.getSource();
  			containerId = object.getName();
  			getFieldsOnFocus();
		}
	};
	
	
	
	
	ValueChangeHandler<Date> vDhandler = new ValueChangeHandler<Date>(){

		public void onValueChange(ValueChangeEvent<Date> event) {
			
			     DateBox object = (DateBox) event.getSource();
			     containerId = object.getTextBox().getName();
			  	 isClicked = false ;
			     getfields(isClicked);
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
		
		display.getDob().addValueChangeHandler(vDhandler);
		
		
		((FocusWidget) display.getfirstNameTextBox()).addBlurHandler(blurHandler);
		((FocusWidget)display.getlastNameTextBox()).addBlurHandler(blurHandler);
		((FocusWidget) display.getDob().getTextBox()).addBlurHandler(blurHandler);
		((FocusWidget)display.getEmailTextBox()).addBlurHandler(blurHandler);
		((FocusWidget)display.getPasswordTextBox()).addBlurHandler(blurHandler);
		((FocusWidget)display.getConfirmPasswordTextBox()).addBlurHandler(blurHandler);
		//----------------------------------------------------------------------------------
		
		((FocusWidget) display.getfirstNameTextBox()).addFocusHandler(focusHandler);
		((FocusWidget)display.getlastNameTextBox()).addFocusHandler(focusHandler);
		((FocusWidget)display.getEmailTextBox()).addFocusHandler(focusHandler);
		((FocusWidget)display.getPasswordTextBox()).addFocusHandler(focusHandler);
		((FocusWidget)display.getConfirmPasswordTextBox()).addFocusHandler(focusHandler);
		
		}
	
	

	public void getfields(boolean way) {
		
		if(way){
		String[] id = {"firstNameTextBox","lastNameTextBox","dateBox","Gender","emailTextBox","passwordTextBox","confirmPasswordTextBox"};
		
		doValidation(id);
		}else{
			String[] id = {containerId} ;
			doValidation(id);
		}
		

	}
	
	
	public void getFieldsOnFocus(){
		
		String[] id = {containerId} ;
		getFocusStatus(id);
	}
	
	public void getFocusStatus(String[] id){
		
		
		for (int i = 0; i < id.length; i++) {

			valueHolder = id[i];

			if (id[i].equalsIgnoreCase("firstNameTextBox")) {

				    isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					
					
				}
			 else if (id[i].equalsIgnoreCase("lastNameTextBox")) {

				

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
				}

			else if(id[i].equalsIgnoreCase("dateBox")){

								
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
				}
			else if (id[i].equalsIgnoreCase("passwordTextBox")) {

					isNull = false;
					isPasswordShort = false;
					isPasswordLong = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
				}

			 else if (id[i].equalsIgnoreCase("confirmPasswordTextBox")) {

					isNull = false;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					
				}

			
		}
		
	}
	
	public void doValidation(String[] id){
		signUpFields = new SignUpFields();
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
					
				} else if (validemail.usernameValidate(firstName) == false) {
					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					
				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					signUpFields.setFirstName(firstName);
					
				}
			} else if (id[i].equalsIgnoreCase("lastNameTextBox")) {

				lastName = display.getlastNameTextBox().getValue().trim();
				display.getlastNameTextBox().setValue(lastName);
				
				if (lastName == null || lastName.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					

				} else if (validemail.usernameValidate(lastName) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					signUpFields.setLastName(lastName);
					
				}

			}else if(id[i].equalsIgnoreCase("dateBox")){


				dateOfBirth = display.getDob().getValue();
				if (dateOfBirth == null) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);

				} else if (dateOfBirth.after(date)) {
					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);

					dateTimeFormat = DateTimeFormat.getFormat("dd - MM - yyyy");
					String dateInString = dateTimeFormat.format(dateOfBirth);
					 signUpFields.setDob(dateInString);
				}

				
			
			}else if (id[i].equalsIgnoreCase("emailTextBox")) {
			

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
					
 				}else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					signUpFields.setEmail(email);
					
				}
			} else if (id[i].equalsIgnoreCase("passwordTextBox")) {

				password = display.getPasswordTextBox().getValue();
				
				if (password == null || password.isEmpty()) {
					isNull = true;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					
				} else if (password.length() < 6) {
					isNull = false;
					isPasswordShort = true;
					isPasswordLong = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					
				} else if (password.length() > 12) {
					isNull = false;
					isPasswordShort = false;
					isPasswordLong = true;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					
				} else {
					isNull = false;
					isPasswordShort = false;
					isPasswordLong = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					

					signUpFields.setPassword(password);

				}

			} else if (id[i].equalsIgnoreCase("confirmPasswordTextBox")) {

				confirmPassword = display.getConfirmPasswordTextBox()
						.getValue();
				if (confirmPassword == null || confirmPassword.isEmpty()) {
					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					
				} else if ((!password.equals(confirmPassword))) {
					isNull = false;
					isInValid = true;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					
				} else {
					isNull = false;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					
				}

			}else{
				
				maleGender = display.getmRadioButton().getValue();
				femaleGender = display.getfmRadioButton().getValue();
				
				if ((maleGender == false) && (femaleGender == false)) {
					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					
				} else if ((maleGender == true) && (femaleGender == false)) {
					isNull = false;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					gender = "Male";
					signUpFields.setGender(gender);
				} else if ((femaleGender == true) && (maleGender == false)) {
					isNull = false;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid,
							isPasswordShort, isPasswordLong);
					gender = "female";
					signUpFields.setGender(gender);
				}
				
				
			}
					 		
		}
		
		
		emailCheckServiceAsync.validateDuplicateEmail(email,
				new AsyncCallback<Boolean>() {
					public void onFailure(Throwable arg0) {

					}

					public void onSuccess(Boolean arg0) {
						if (arg0) {
							
							
							display.duplicateEmailError();
						} else {
							
							validateSendToServer();
						}
					}
				});
		
				
		validateSendToServer();
	}
		
	public void validateSendToServer() {

		if (signUpFields.getFirstName() != null
				&& signUpFields.getLastName() != null
				&& signUpFields.getEmail() != null
				&& signUpFields.getGender() != null
				&& signUpFields.getDob() != null
				&& signUpFields.getPassword() != null) {
			sendToServer();
			
		}

	}
	
	
public void onNextPage(){
		
		
		RootPanel.get("top").clear();
		
		ProfileDetailView display = new ProfileDetailView();
		ProfileDetailPresenter presenter = new ProfileDetailPresenter(display, eventBus);
		presenter.bind();

		RootPanel.get("top").add(presenter.getDisplay().asWidget());
		
	}
	
	
	
	/**
	 * on the click of getStart button the field values are send to server.
	 */
	public void sendToServer() {

		signUpService.signUpServer(signUpFields,
				new AsyncCallback<SignUpFields>() {
			public void onFailure(Throwable caught) {

			}

			public void onSuccess(SignUpFields signUpFields) {
				
				
				
				

			}
		});
		onNextPage();

		
		
		
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
	 * values of the textBox.
	 */
	/*
	 * public void onClick(ClickEvent arg0) { clearAllError(); getData();
	 * 
	 * }
	 */

	

	/**
	 * getter for signUp fields
	 * 
	 * @return
	 */
	public SignUpFields getSignUpFields() {
		return signUpFields;
	}

}