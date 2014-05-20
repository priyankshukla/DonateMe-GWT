package com.jkt.donateme.client.presenter;

import gwtupload.client.IUploader.UploadedInfo;
import gwtupload.client.MultiUploader;

import java.util.Date;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.jkt.donateme.client.model.ApplicationData;
import com.jkt.donateme.client.model.BeneficiaryDetailsFields;
import com.jkt.donateme.client.model.ProfileDetailsFields;
import com.jkt.donateme.client.model.SessionDataHolder;
import com.jkt.donateme.client.rpc.SignUpService;
import com.jkt.donateme.client.rpc.SignUpServiceAsync;
import com.jkt.donateme.client.validation.EmailValidator;
import com.jkt.donateme.client.view.ProfileDetailView;

public class BeneficiaryDetailsPresenter extends
		WidgetPresenter<BeneficiaryDetailsPresenter.Display> {
	private final SignUpServiceAsync patientDetailServiceAsync = (SignUpServiceAsync) GWT
			.create(SignUpService.class);
	private String containerId;
	private String valueHolder;
	private boolean isNull = false;
	private boolean isInValid = false;
	private boolean isClicked = false;
	private EmailValidator validemail;
	private BeneficiaryDetailsFields beneficiaryDetailsFields;

	// beneficiary details
	private String relationToBeneficiary;
	private String firstName;
	private String lastName;
	private String email;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	// payment mode

	private boolean isCheque;
	private boolean isWireTransfer;
	private String cheque;
	private String accNumber;
	private String bankName;
	private String holderName;
	private String ifscCode;
	private String cityName;
	private String stateName;
	// medical details

	private String doctorName;
	private String hospitalName;
	private String diseaseName;
	
	private ProfileDetailsFields profileDetails = ApplicationData.getInstance()
			.getSessionDataHolder("profileDetailsFields")
			.getSecondScreendetails();
	private Date date;
	private BeneficiaryDetailsPresenter beneficiaryDetailsPresenter;
	
	public interface Display extends WidgetDisplay {

		public ListBox getRelationToBeneficiaryListBox();

		public HasValue<String> getfirstNameTextBox();

		public HasValue<String> getlastNameTextBox();

		public HasValue<String> getAddressLine1TextBox();

		public HasValue<String> getAddressLine2TextBox();

		public HasValue<String> getCityTextBox();

		public ListBox getStateTextBox();

		public HasValue<String> getZipTextBox();

		public HasValue<String> getEmailTextBox();

		public HasValue<String> getPhoneNumberTextBox();

		// payment mode
		public RadioButton getChequeButton();

		public RadioButton getwireTransferButton();

		public void setMode(boolean cheque, boolean wireTransfer);

		public void reInitialisePayment(boolean cheque);

		public HasValue<String> getChequeTextBox();

		public HasValue<String> getAccNoTextBox();

		public HasValue<String> getBankNameTextBox();

		public HasValue<String> getHolderNameTextBox();

		public HasValue<String> getIfscTextBox();

		public HasValue<String> getCityTextBoxForPayment();

		public HasValue<String> getStateTextBoxForPayment();

		// medical details

		public HasValue<String> getdoctorNameTextBox();

		public HasValue<String> getdiseaseNameTextBox();

		public HasValue<String> gethospitalNameTextBox();

		public HasClickHandlers getnextButton();

		public HasClickHandlers getbackButton();

		public MultiUploader getcheckuploadValidate();

		public UploadedInfo getUploadInfo();

		public void setStatus(String box, boolean isNull, boolean isInValid);

		public void setRelationToBeneficiaryListBox(boolean value);

		public void resetItems();
		public void setNextButtonDisable();
	}

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */

	public BeneficiaryDetailsPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
	}

	ValueChangeHandler<Boolean> handler = new ValueChangeHandler<Boolean>() {

		public void onValueChange(ValueChangeEvent<Boolean> event) {
			// getChecked();
			RadioButton buttonObject = (RadioButton) event.getSource();
			containerId = buttonObject.getName();
			isClicked = false;
			getFieldsOnFocus(true);
			isCheque = display.getChequeButton().getValue();
			display.reInitialisePayment(isCheque);
			getfields(isClicked);

		}

	};

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
	// ankita

	FocusHandler focusHandler = new FocusHandler() {

		public void onFocus(FocusEvent event) {
			TextBox object = (TextBox) event.getSource();
			containerId = object.getName();
			getFieldsOnFocus(false);
		}
	};

	// medical details
	/**
	 * It gets the focus status of the fields
	 */
	public void getFieldsOnFocus() {

		String[] id = { containerId };
		getFocusStatus(id);
	}

	ChangeHandler onChangeHandler = new ChangeHandler() {

		public void onChange(ChangeEvent event) {
			display.resetItems();
			ListBox object = (ListBox) event.getSource();
			containerId = object.getName();
			isClicked = false;
			getfields(isClicked);
		}
	};

	ClickHandler backButtonHandler = new ClickHandler() {

		public void onClick(ClickEvent arg0) {
			RootPanel.get("top").clear();
			

			ProfileDetailView display = new ProfileDetailView();
			ProfileDetailPresenter presenter = new ProfileDetailPresenter(
					display, eventBus);
			
		
			
			presenter.bind();

			RootPanel.get("top").add(presenter.getDisplay().asWidget());
			populateValue(presenter);
			//setSessionBeneficiaryPage(beneficiaryDetailsFields);
			getSetterMethod();
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

		(display.getRelationToBeneficiaryListBox())
				.addChangeHandler(onChangeHandler);
		((FocusWidget) display.getfirstNameTextBox())
				.addBlurHandler(blurHandler);
		((FocusWidget) display.getlastNameTextBox())
				.addBlurHandler(blurHandler);
		((FocusWidget) display.getAddressLine1TextBox())
				.addBlurHandler(blurHandler);
		((FocusWidget) display.getAddressLine2TextBox())
				.addBlurHandler(blurHandler);
		((FocusWidget) display.getCityTextBox()).addBlurHandler(blurHandler);
		/*
		 * ((FocusWidget)
		 * display.getStateTextBox()).addBlurHandler(blurHandler);
		 */
		((FocusWidget) display.getZipTextBox()).addBlurHandler(blurHandler);
		((FocusWidget) display.getEmailTextBox()).addBlurHandler(blurHandler);
		((FocusWidget) display.getPhoneNumberTextBox())
				.addBlurHandler(blurHandler);
		// payment mode
		// display.getTestButton().addClickHandler(clickHandler);

		display.getChequeButton().addValueChangeHandler(handler);
		display.getwireTransferButton().addValueChangeHandler(handler);

		((FocusWidget) display.getChequeTextBox()).addBlurHandler(blurHandler);
		((FocusWidget) display.getAccNoTextBox()).addBlurHandler(blurHandler);
		((FocusWidget) display.getBankNameTextBox())
				.addBlurHandler(blurHandler);
		((FocusWidget) display.getHolderNameTextBox())
				.addBlurHandler(blurHandler);
		((FocusWidget) display.getIfscTextBox()).addBlurHandler(blurHandler);
		((FocusWidget) display.getCityTextBoxForPayment())
				.addBlurHandler(blurHandler);
		((FocusWidget) display.getStateTextBoxForPayment())
				.addBlurHandler(blurHandler);
		// medical details
		/**
		 * For GetStartedButton .
		 */
		display.getnextButton().addClickHandler(clickHandler);

		display.getbackButton().addClickHandler(backButtonHandler);

		((FocusWidget) display.getdoctorNameTextBox())
				.addBlurHandler(blurHandler);

		((FocusWidget) display.getdiseaseNameTextBox())
				.addBlurHandler(blurHandler);

		((FocusWidget) display.gethospitalNameTextBox())
				.addBlurHandler(blurHandler);

		// ______________________________________________________________________________________

		// ----------------------------------------------------------------------------------
		/*
		 * ((FocusWidget) display.getRelationToBeneficiaryListBox())
		 * .addFocusHandler(focusHandler);
		 */

		((FocusWidget) display.getfirstNameTextBox())
				.addFocusHandler(focusHandler);
		((FocusWidget) display.getlastNameTextBox())
				.addFocusHandler(focusHandler);
		((FocusWidget) display.getAddressLine1TextBox())
				.addFocusHandler(focusHandler);
		((FocusWidget) display.getAddressLine2TextBox())
				.addFocusHandler(focusHandler);
		((FocusWidget) display.getCityTextBox()).addFocusHandler(focusHandler);
		// ((FocusWidget)
		// display.getStateTextBox()).addFocusHandler(focusHandler);
		((FocusWidget) display.getZipTextBox()).addFocusHandler(focusHandler);
		((FocusWidget) display.getEmailTextBox()).addFocusHandler(focusHandler);
		((FocusWidget) display.getPhoneNumberTextBox())
				.addFocusHandler(focusHandler);
		// payment mode
		((FocusWidget) display.getChequeTextBox())
				.addFocusHandler(focusHandler);
		((FocusWidget) display.getAccNoTextBox()).addFocusHandler(focusHandler);
		((FocusWidget) display.getBankNameTextBox())
				.addFocusHandler(focusHandler);
		((FocusWidget) display.getHolderNameTextBox())
				.addFocusHandler(focusHandler);
		((FocusWidget) display.getIfscTextBox()).addFocusHandler(focusHandler);
		((FocusWidget) display.getCityTextBoxForPayment())
				.addFocusHandler(focusHandler);
		((FocusWidget) display.getStateTextBoxForPayment())
				.addFocusHandler(focusHandler);
		// ankita

		((FocusWidget) display.getdoctorNameTextBox())
				.addFocusHandler(focusHandler);

		((FocusWidget) display.getdiseaseNameTextBox())
				.addFocusHandler(focusHandler);

		((FocusWidget) display.gethospitalNameTextBox())
				.addFocusHandler(focusHandler);
	}

	public void getfields(boolean way) {

		if (way) {
			String[] id = { "relationToBeneficiary", "firstNameTextBox",
					"lastNameTextBox", "addressLine1", "addressLine2", "city",
					"state", "zip", "emailId", "phoneNumber", "chequeTextBox",
					"accNoTextBox", "bankNameTextBox", "holderNameTextBox",
					"ifscTextBox", "cityTextBox", "stateTextBox",
					"paymentMode", "doctorNameTextBox", "hospitalNameTextBox",
					"diseaseNameTextBox", "checkuploadFile" };

			doValidation(id);
		} else {
			String[] id = { containerId };
			doValidation(id);
		}

	}

	public void getFieldsOnFocus(boolean way) {
		if (way) {
			String[] id = { "chequeTextBox", "accNoTextBox", "bankNameTextBox",
					"holderNameTextBox", "ifscTextBox", "cityTextBox",
					"stateTextBox" };
			getFocusStatus(id);

		} else {

			String[] id = { containerId };
			getFocusStatus(id);
		}
	}

	public void getFocusStatus(String[] id) {

		for (int i = 0; i < id.length; i++) {

			valueHolder = id[i];
			if (id[i].equalsIgnoreCase("relationToBeneficiary")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);

			}
			if (id[i].equalsIgnoreCase("firstNameTextBox")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);

			} else if (id[i].equalsIgnoreCase("lastNameTextBox")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);
			}

			else if (id[i].equalsIgnoreCase("addressLine1")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);

			}

			else if (id[i].equalsIgnoreCase("addressLine2")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);

			}

			else if (id[i].equalsIgnoreCase("emailID")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);
			} else if (id[i].equalsIgnoreCase("city")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);

			} else if (id[i].equalsIgnoreCase("state")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);

			} else if (id[i].equalsIgnoreCase("zip")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);

			} else if (id[i].equalsIgnoreCase("phoneNumber")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);

			} else if (id[i].equalsIgnoreCase("chequeTextBox")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);

			} else if (id[i].equalsIgnoreCase("accNoTextBox")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);
			}

			else if (id[i].equalsIgnoreCase("bankNameTextBox")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);

			}

			else if (id[i].equalsIgnoreCase("holderNameTextBox")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);
			} else if (id[i].equalsIgnoreCase("ifscTextBox")) {

				isNull = false;
				isInValid = false;
				display.setStatus(valueHolder, isNull, isInValid);
			}

			else if (id[i].equalsIgnoreCase("cityTextBox")) {

				isNull = false;
				isInValid = false;
				display.setStatus(valueHolder, isNull, isInValid);

			} else if (id[i].equalsIgnoreCase("stateTextBox")) {

				isNull = false;
				isInValid = false;
				display.setStatus(valueHolder, isNull, isInValid);

			} else if (id[i].equalsIgnoreCase("doctorNameTextBox")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);

			} else if (id[i].equalsIgnoreCase("diseaseNameTextBox")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);
			}

			else if (id[i].equalsIgnoreCase("hospitalNameTextBox")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);

			}

		}

	}

	public void doValidation(String[] id) {
		beneficiaryDetailsFields = new BeneficiaryDetailsFields();
		validemail = new EmailValidator();

		for (int i = 0; i < id.length; i++) {

			valueHolder = id[i];
			if (id[i].equalsIgnoreCase("relationToBeneficiary")) {
				int list = display.getRelationToBeneficiaryListBox()
						.getSelectedIndex();
				if (list == 0) {
					boolean value = true;
					display.setRelationToBeneficiaryListBox(value);

				}

				if (relationToBeneficiary == null
						|| relationToBeneficiary.isEmpty()) {
					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.stringValidate(relationToBeneficiary) == false) {
					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields
							.setRelationToBeneficiary(relationToBeneficiary);

				}
			}

			if (id[i].equalsIgnoreCase("firstNameTextBox")) {

				firstName = display.getfirstNameTextBox().getValue().trim();
				display.getfirstNameTextBox().setValue(firstName);

				if (firstName == null || firstName.isEmpty()) {
					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.stringValidate(firstName) == false) {
					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setFirstName(firstName);

				}
			} else if (id[i].equalsIgnoreCase("lastNameTextBox")) {

				lastName = display.getlastNameTextBox().getValue().trim();
				display.getlastNameTextBox().setValue(lastName);

				if (lastName == null || lastName.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.stringValidate(lastName) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setLastName(lastName);

				}

			} else if (id[i].equalsIgnoreCase("emailID")) {

				email = display.getEmailTextBox().getValue().trim();
				display.getEmailTextBox().setValue(email);

				if (email == null || email.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.validate(email) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setEmail(email);

				}
			} else if (id[i].equalsIgnoreCase("addressLine1")) {

				addressLine1 = display.getAddressLine1TextBox().getValue()
						.trim();
				display.getAddressLine1TextBox().setValue(addressLine1);

				if (addressLine1 == null || addressLine1.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.alphaNumericCharacters(addressLine1) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setAddressLine1(addressLine1);

				}

			} else if (id[i].equalsIgnoreCase("addressLine2")) {

				addressLine2 = display.getAddressLine2TextBox().getValue()
						.trim();
				display.getAddressLine2TextBox().setValue(addressLine2);

				if (addressLine2 == null || addressLine2.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.alphaNumericCharacters(addressLine2) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setAddressLine2(addressLine2);

				}

			} else if (id[i].equalsIgnoreCase("city")) {

				city = display.getCityTextBox().getValue().trim();
				display.getCityTextBox().setValue(city);

				if (city == null || city.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.stringValidate(city) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setCity(city);

				}

			} else if (id[i].equalsIgnoreCase("state")) {

				state = display.getStateTextBox().getItemText(i);
				display.getStateTextBox().setValue(i, state);

				if (state == null || state.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.stringValidate(state) == false) {

					isInValid = true;
					isNull = false; 
					display.setStatus(valueHolder, isNull, isInValid);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setState(state);

				}

			} 
			
		/*	else if (id[i].equalsIgnoreCase("stateTextBox")) {

				stateName = display.getStateTextBoxForPayment().getValue()
						.trim();
				display.getStateTextBoxForPayment().setValue(stateName);

				if (stateName == null || stateName.isEmpty()) {
					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.stringValidate(stateName) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setStateName(stateName);
				}

			}*/
			
			
			
			
			
			
			else if (id[i].equalsIgnoreCase("zip")) {

				zip = display.getZipTextBox().getValue().trim();
				display.getZipTextBox().setValue(zip);

				if (zip == null || zip.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.integerValidate(zip) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setZip(zip);

				}

			} else if (id[i].equalsIgnoreCase("phoneNumber")) {

				phoneNumber = display.getPhoneNumberTextBox().getValue().trim();
				display.getPhoneNumberTextBox().setValue(phoneNumber);

				if (phoneNumber == null || phoneNumber.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.integerValidate(phoneNumber) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setPhoneNumber(phoneNumber);

				}
			} else if (id[i].equalsIgnoreCase("chequeTextBox")) {

				cheque = display.getChequeTextBox().getValue().trim();
				display.getChequeTextBox().setValue(cheque);

				if (cheque == null || cheque.isEmpty()) {
					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.stringValidate(cheque) == false) {
					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setCheque(cheque);

				}
			} else if (id[i].equalsIgnoreCase("accNoTextBox")) {

				accNumber = display.getAccNoTextBox().getValue().trim();
				display.getAccNoTextBox().setValue(accNumber);

				if (accNumber == null || accNumber.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.integerValidate(accNumber) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setAccNumber(accNumber);

				}

			} else if (id[i].equalsIgnoreCase("bankNameTextBox")) {

				bankName = display.getBankNameTextBox().getValue().trim();
				display.getBankNameTextBox().setValue(bankName);
				if (bankName == null || bankName.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.stringValidate(bankName) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

					beneficiaryDetailsFields.setBankName(bankName);
				}

			} else if (id[i].equalsIgnoreCase("holderNameTextBox")) {

				holderName = display.getHolderNameTextBox().getValue().trim();
				display.getHolderNameTextBox().setValue(holderName);

				if (holderName == null || holderName.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.stringValidate(holderName) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setHolderName(holderName);

				}
			} else if (id[i].equalsIgnoreCase("ifscTextBox")) {

				ifscCode = display.getIfscTextBox().getValue().trim();
				display.getIfscTextBox().setValue(ifscCode);

				if (ifscCode == null || ifscCode.isEmpty()) {
					isNull = true;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.ifscValidate(ifscCode) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setIfscCode(ifscCode);

				}

			} else if (id[i].equalsIgnoreCase("cityTextBox")) {

				cityName = display.getCityTextBoxForPayment().getValue().trim();
				display.getCityTextBoxForPayment().setValue(cityName);

				if (cityName == null || cityName.isEmpty()) {
					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.stringValidate(cityName) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setCityName(cityName);

				}

			} else if (id[i].equalsIgnoreCase("stateTextBox")) {

				stateName = display.getStateTextBoxForPayment().getValue()
						.trim();
				display.getStateTextBoxForPayment().setValue(stateName);

				if (stateName == null || stateName.isEmpty()) {
					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.stringValidate(stateName) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setStateName(stateName);

				}

			} else if (id[i].equalsIgnoreCase("paymentMode")) {

				isCheque = display.getChequeButton().getValue();
				isWireTransfer = display.getwireTransferButton().getValue();

				if (isCheque == false && isWireTransfer == false) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {

					isNull = false;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);
					// getFieldsOnFocus(true);
					display.setMode(isCheque, isWireTransfer);
				}

			} else if (id[i].equalsIgnoreCase("diseaseNameTextBox")) {

				diseaseName = display.getdiseaseNameTextBox().getValue().trim();
				display.getdiseaseNameTextBox().setValue(diseaseName);

				if (diseaseName == null || diseaseName.isEmpty()) {
					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.stringValidate(diseaseName) == false) {
					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setDiseaseName(diseaseName);

				}

			} else if (id[i].equalsIgnoreCase("doctorNameTextBox")) {
				// doctor name
				doctorName = display.getdoctorNameTextBox().getValue().trim();
				display.getdoctorNameTextBox().setValue(doctorName);

				if (doctorName == null || doctorName.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.stringValidate(doctorName) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setDoctorName(doctorName);

				}

			} else if (id[i].equalsIgnoreCase("hospitalNameTextBox")) {
				// hospital name
				hospitalName = display.gethospitalNameTextBox().getValue()
						.trim();
				display.gethospitalNameTextBox().setValue(hospitalName);

				if (hospitalName == null || hospitalName.isEmpty()) {
					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.stringValidate(hospitalName) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					beneficiaryDetailsFields.setHospitalName(hospitalName);

				}

			} else if (id[i].equalsIgnoreCase("checkuploadFile")) {
				// upload file
				if (display.getUploadInfo() == null) {
					
					isNull = true;
					isInValid = false;
					display.setStatus("checkuploadFile", isNull, isInValid);
					System.out.println("filename of the upload " +display.getUploadInfo().getFileName());

				} else {
					isNull = false;
					isInValid = true;
					display.setStatus("checkuploadFile", isNull, isInValid);
					System.out.println("filename of the upload " +display.getUploadInfo().getFileName());

				}

			}
		}

		validateSendToServer();
		
	}

	public void validateSendToServer() {
		if (display.getRelationToBeneficiaryListBox().getSelectedIndex() == 0
				&& display.getChequeButton().getValue() == true) {

			if (
					profileDetails.getTitleOfYourPagePanel() != null && 
							profileDetails.getDonationNeededPanel() != null
							&& profileDetails.getEndCollectingMoneyOnPanel() != null
							&& profileDetails.getProfileSummaryPanel() != null
							&& profileDetails.getReasonForRaisingFundsPanel() != null
							&& beneficiaryDetailsFields.getAddressLine1() != null
							&& beneficiaryDetailsFields.getAddressLine2() != null
							&& beneficiaryDetailsFields.getCity() != null
							 && beneficiaryDetailsFields.getState() != null 
							&& beneficiaryDetailsFields.getZip() != null
							&& beneficiaryDetailsFields.getPhoneNumber() != null
							&& beneficiaryDetailsFields.getDiseaseName() != null
							&& beneficiaryDetailsFields.getDoctorName() != null
							&& beneficiaryDetailsFields.getHospitalName() != null
							&& beneficiaryDetailsFields.getCheque() != null){
				
				setSecondScreenValues();
				sendToServer();}


			else if(
				 beneficiaryDetailsFields.getAddressLine1() != null
					&& beneficiaryDetailsFields.getAddressLine2() != null
					&& beneficiaryDetailsFields.getCity() != null
					 && beneficiaryDetailsFields.getState() != null 
					&& beneficiaryDetailsFields.getZip() != null
					&& beneficiaryDetailsFields.getPhoneNumber() != null
					&& beneficiaryDetailsFields.getDiseaseName() != null
					&& beneficiaryDetailsFields.getDoctorName() != null
					&& beneficiaryDetailsFields.getHospitalName() != null
					&& beneficiaryDetailsFields.getCheque() != null
			
			) {
				setSecondScreenValues();
				sendToServer();
			}
			} else if(display.getRelationToBeneficiaryListBox().getSelectedIndex() != 0) {
				if (beneficiaryDetailsFields.getFirstName() != null
						&& beneficiaryDetailsFields.getLastName() != null
						&& beneficiaryDetailsFields.getEmail() != null
						) {
					setSecondScreenValues();

					sendToServer();

				}
				
			
		}else if(display.getChequeButton().getValue() == false)
			
				if(beneficiaryDetailsFields.getAccNumber() != null
					&& beneficiaryDetailsFields.getBankName() != null
					&& beneficiaryDetailsFields.getHolderName() != null
					&& beneficiaryDetailsFields.getIfscCode() != null
					&& beneficiaryDetailsFields.getCityName() != null
					&& beneficiaryDetailsFields.getStateName() != null){
					setSecondScreenValues();

				sendToServer();
			}
		}	

	

	public BeneficiaryDetailsFields setSelfFields() {
		BeneficiaryDetailsFields beneficiaryDetailsFields = new BeneficiaryDetailsFields();
		beneficiaryDetailsFields.setFirstName(firstName);
		beneficiaryDetailsFields.setLastName(lastName);
		beneficiaryDetailsFields.setEmail(email);

		return beneficiaryDetailsFields;

	}
	BeneficiaryDetailsFields setSecondScreenValues(){
		beneficiaryDetailsFields.setTitleOfYourPage(profileDetails.getTitleOfYourPagePanel());
		beneficiaryDetailsFields.setDonationNeeded(profileDetails.getDonationNeededPanel());
		beneficiaryDetailsFields.setProfileSummary(profileDetails.getProfileSummaryPanel());
		beneficiaryDetailsFields.setReasonForRaisingFundsPanel(profileDetails.getReasonForRaisingFundsPanel());
		beneficiaryDetailsFields.setEndCollectingMoneyOnPanel(profileDetails.getEndCollectingMoneyOnPanel().toString());
		return beneficiaryDetailsFields;
	}
	public void sendToServer() {

		patientDetailServiceAsync.profileDetailsServer(
				beneficiaryDetailsFields,
				new AsyncCallback<BeneficiaryDetailsFields>() {

					public void onFailure(Throwable arg0) {
						System.out.println("ON Failure...................");

					}

					public void onSuccess(
							BeneficiaryDetailsFields beneficiaryDetailsFields) {
						System.out.println("ON Sucesss...................");
						display.setNextButtonDisable();
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
	public BeneficiaryDetailsFields getBenefiaryDetails() {
		return beneficiaryDetailsFields;
	}
	
	public void populateValue(ProfileDetailPresenter presenter){
		
		
		presenter.getDisplay().getTitleOfYourPageTextBox().setValue(profileDetails.getTitleOfYourPagePanel());
		presenter.getDisplay().getDonationNeededTextBox().setValue(profileDetails.getDonationNeededPanel());
		presenter.getDisplay().getReasonForRaisingFundsTextBox().setValue(profileDetails.getReasonForRaisingFundsPanel());
		presenter.getDisplay().getProfileSummaryTextArea().setValue(profileDetails.getProfileSummaryPanel());
		presenter.getDisplay().getDob().setValue(profileDetails.getEndCollectingMoneyOnPanel());
	//	presenter.getDisplay().getuploadOfSecondScreen().
		
		
		
	}
	
	public void getSetterMethod(){
		setSessionBeneficiaryPage(beneficiaryDetailsFields);
	}
	
	
	public void setSessionBeneficiaryPage(BeneficiaryDetailsFields beneficiaryDetailsFields){
		
		SessionDataHolder sessionDataHolder1 = new SessionDataHolder();
		
		sessionDataHolder1.setBeneficiarysessionDetails(beneficiaryDetailsFields);
		
		//System.out.println(sessionDataHolder1.getBeneficiarysessionDetails().getAddressLine1());
		
		ApplicationData.getInstance().injectSessionDataHolder("beneficiaryDetailsFields", sessionDataHolder1);
		//System.out.println(ApplicationData.getInstance().injectSessionDataHolder("BeneficiaryDetailsFields", sessionDataHolder1));
		System.out
		.println("??????? " +((BeneficiaryDetailsFields) (((SessionDataHolder) ApplicationData
				.getInstance().getSessionDataHolder(
						"beneficiaryDetailsFields")).getBeneficiarysessionDetails()))
				.getAddressLine1());
		
		//populateBeneficiaryFields(beneficiaryDetailsPresenter);
		/*if (display.getRelationToBeneficiaryListBox().getSelectedIndex() == 0
				&& display.getChequeButton().getValue() == true) {

			if (
					profileDetails.getTitleOfYourPagePanel() != null && 
							profileDetails.getDonationNeededPanel() != null
							&& profileDetails.getEndCollectingMoneyOnPanel() != null
							&& profileDetails.getProfileSummaryPanel() != null
							&& profileDetails.getReasonForRaisingFundsPanel() != null
						
				
				&& beneficiaryDetailsFields.getAddressLine1() != null
					&& beneficiaryDetailsFields.getAddressLine2() != null
					&& beneficiaryDetailsFields.getCity() != null
					 && beneficiaryDetailsFields.getState() != null 
					&& beneficiaryDetailsFields.getZip() != null
					&& beneficiaryDetailsFields.getPhoneNumber() != null
					&& beneficiaryDetailsFields.getDiseaseName() != null
					&& beneficiaryDetailsFields.getDoctorName() != null
					&& beneficiaryDetailsFields.getHospitalName() != null
					&& beneficiaryDetailsFields.getZip() != null
					&& beneficiaryDetailsFields.getCheque() != null
			
			) {
				//setSecondScreenValues();
				populateBeneficiaryFields(beneficiaryDetailsPresenter);			}
			} else if(display.getRelationToBeneficiaryListBox().getSelectedIndex() != 0) {
				if (beneficiaryDetailsFields.getFirstName() != null
						&& beneficiaryDetailsFields.getLastName() != null
						&& beneficiaryDetailsFields.getEmail() != null
						) {
				//	setSecondScreenValues();

					populateBeneficiaryFields(beneficiaryDetailsPresenter);
				}
				
			
		}else if(display.getChequeButton().getValue() == false)
			
				if(beneficiaryDetailsFields.getAccNumber() != null
					&& beneficiaryDetailsFields.getBankName() != null
					&& beneficiaryDetailsFields.getHolderName() != null
					&& beneficiaryDetailsFields.getIfscCode() != null
					&& beneficiaryDetailsFields.getCityName() != null
					&& beneficiaryDetailsFields.getStateName() != null){
					//setSecondScreenValues();

					populateBeneficiaryFields(beneficiaryDetailsPresenter);		
		
				}*/

	}
public void populateBeneficiaryFields(BeneficiaryDetailsPresenter presenterBeneficiary){
		/*if (beneficiaryDetailsFields.getAddressLine1() != null
				|| beneficiaryDetailsFields.getAddressLine2() != null
				|| beneficiaryDetailsFields.getCity() != null
				|| beneficiaryDetailsFields.getZip() != null
				|| beneficiaryDetailsFields.getCheque() != null
				|| beneficiaryDetailsFields.getAccNumber() != null
				|| beneficiaryDetailsFields.getBankName() != null
				|| beneficiaryDetailsFields.getHolderName() != null
				|| beneficiaryDetailsFields.getIfscCode() != null
				|| beneficiaryDetailsFields.getCityName() != null
				|| beneficiaryDetailsFields.getStateName() != null
				|| beneficiaryDetailsFields.getHospitalName() != null
				|| beneficiaryDetailsFields.getDoctorName() != null
				|| beneficiaryDetailsFields.getDiseaseName() != null
				){
			*/
		 BeneficiaryDetailsFields beneficiaryDetailsFields = ApplicationData.getInstance().getSessionDataHolder("beneficiaryDetailsFields").getBeneficiarysessionDetails();
		System.out.println("()()() "+ApplicationData.getInstance().getSessionDataHolder("beneficiaryDetailsFields").getBeneficiarysessionDetails());
		presenterBeneficiary.getDisplay().getAddressLine1TextBox().setValue(beneficiaryDetailsFields.getAddressLine1());
		presenterBeneficiary.getDisplay().getAddressLine2TextBox().setValue(beneficiaryDetailsFields.getAddressLine2());
		presenterBeneficiary.getDisplay().getCityTextBox().setValue(beneficiaryDetailsFields.getCity());
		//presenterBeneficiary.getDisplay().getStateTextBox().setValue(beneficiaryDetailsFields.getState());
		presenterBeneficiary.getDisplay().getZipTextBox().setValue(beneficiaryDetailsFields.getZip());
		presenterBeneficiary.getDisplay().getChequeTextBox().setValue(beneficiaryDetailsFields.getCheque());
		presenterBeneficiary.getDisplay().getAccNoTextBox().setValue(beneficiaryDetailsFields.getAccNumber());
		presenterBeneficiary.getDisplay().getBankNameTextBox().setValue(beneficiaryDetailsFields.getBankName());
		presenterBeneficiary.getDisplay().getHolderNameTextBox().setValue(beneficiaryDetailsFields.getHolderName());
		presenterBeneficiary.getDisplay().getIfscTextBox().setValue(beneficiaryDetailsFields.getIfscCode());
		presenterBeneficiary.getDisplay().getCityTextBoxForPayment().setValue(beneficiaryDetailsFields.getCityName());
		presenterBeneficiary.getDisplay().getStateTextBoxForPayment().setValue(beneficiaryDetailsFields.getStateName());
		presenterBeneficiary.getDisplay().gethospitalNameTextBox().setValue(beneficiaryDetailsFields.getHospitalName());
		presenterBeneficiary.getDisplay().getdoctorNameTextBox().setValue(beneficiaryDetailsFields.getDoctorName());
		presenterBeneficiary.getDisplay().getdiseaseNameTextBox().setValue(beneficiaryDetailsFields.getDiseaseName());
		//}
	}

/*	private ProfileDetailsFields profileDetails = ApplicationData.getInstance()
			.getSessionDataHolder("profileDetailsFields")
	
			.getSecondScreendetails();*/
}
