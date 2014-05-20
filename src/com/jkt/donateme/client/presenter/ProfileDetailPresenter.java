package com.jkt.donateme.client.presenter;

import gwtupload.client.MultiUploader;

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
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.jkt.donateme.client.model.ApplicationData;
import com.jkt.donateme.client.model.BeneficiaryDetailsFields;
import com.jkt.donateme.client.model.ProfileDetailsFields;
import com.jkt.donateme.client.model.SessionDataHolder;
import com.jkt.donateme.client.rpc.PatientDetailService;
import com.jkt.donateme.client.rpc.PatientDetailServiceAsync;
import com.jkt.donateme.client.validation.EmailValidator;
import com.jkt.donateme.client.view.BeneficiaryDetailsView;

public class ProfileDetailPresenter extends
		WidgetPresenter<ProfileDetailPresenter.Display> {
	private final PatientDetailServiceAsync patientDetailServiceAsync = GWT
			.create(PatientDetailService.class);
	private String titleOfYourPage;
	private String donationNeeded;
	private String profileSummary;
	private String containerId;
	private String valueHolder;
	private String reasonsforRaisingFunds;
	private boolean isNull = false;
	private boolean isInValid = false;
	private boolean isClicked = false;
	private Date date = new Date();
	
	private Date dateOfBirth;
	private EmailValidator validemail;

	private ProfileDetailsFields profileDetails;

	private BeneficiaryDetailsFields patientDetails;

	private DateTimeFormat dateTimeFormat;
//	private BeneficiaryDetailsFields beneficiaryDetailsFields = ApplicationData.getInstance().getSessionDataHolder("beneficiaryDetailsFields").getBeneficiarysessionDetails();
	//private BeneficiaryDetailsFields bef = ApplicationData.getInstance().getSessionDataHolder("BeneficiaryDetailsFields").getBeneficiarysessionDetails();

	public interface Display extends WidgetDisplay {

		public HasValue<String> getTitleOfYourPageTextBox();

		public HasValue<String> getDonationNeededTextBox();

		public HasValue<String> getReasonForRaisingFundsTextBox();

		public HasValue<String> getProfileSummaryTextArea();

		public HasClickHandlers getnextButton();

		public DateBox getDob();
		
		public MultiUploader getuploadOfSecondScreen();

		public void setStatus(String box, boolean isNull, boolean isInValid);
		
		
	}

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */

	public ProfileDetailPresenter(Display display, EventBus eventBus) {
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

	BlurHandler blurHandlerTextArea = new BlurHandler() {

		public void onBlur(BlurEvent event) {

			TextArea object = (TextArea) event.getSource();
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

	FocusHandler focusHandlerTextArea = new FocusHandler() {

		public void onFocus(FocusEvent event) {

			TextArea object = (TextArea) event.getSource();
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

	/**
	 * Binds data on click.
	 */
	@Override
	protected void onBind() {

		/**
		 * For GetStartedButton .
		 */
		display.getnextButton().addClickHandler(clickHandler);

		display.getDob().addValueChangeHandler(vDhandler);

		((FocusWidget) display.getTitleOfYourPageTextBox())
				.addBlurHandler(blurHandler);
		((FocusWidget) display.getDonationNeededTextBox())
				.addBlurHandler(blurHandler);
		((FocusWidget) display.getDob().getTextBox())
				.addBlurHandler(blurHandler);
		((FocusWidget) display.getReasonForRaisingFundsTextBox())
				.addBlurHandler(blurHandler);
		((FocusWidget) display.getProfileSummaryTextArea())
				.addBlurHandler(blurHandlerTextArea);
		// ----------------------------------------------------------------------------------

		((FocusWidget) display.getTitleOfYourPageTextBox())
				.addFocusHandler(focusHandler);
		((FocusWidget) display.getDonationNeededTextBox())
				.addFocusHandler(focusHandler);
		((FocusWidget) display.getReasonForRaisingFundsTextBox())
				.addFocusHandler(focusHandler);
		((FocusWidget) display.getProfileSummaryTextArea())
				.addFocusHandler(focusHandlerTextArea);

	}

	@SuppressWarnings("deprecation")
	public void getfields(boolean way) {
		
		if (way) {
			String[] id = { "titleOfYourPageTextBox", "donationNeededTextBox",
					"reasonForRaisingFundsTextBox", "profileSummaryTextArea",
					"dateBox" };

			doValidation(id);
		} else {
			String[] id = { containerId };
			doValidation(id);
		}

	}
/**
 * It gets the focus status of the fields
 */
	public void getFieldsOnFocus() {

		String[] id = { containerId };
		getFocusStatus(id);
	}
/**
 * 
 * @param id
 */
	public void getFocusStatus(String[] id) {

		for (int i = 0; i < id.length; i++) {

			valueHolder = id[i];
			

			if (id[i].equalsIgnoreCase("titleOfYourPageTextBox")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);

			} else if (id[i].equalsIgnoreCase("donationNeededTextBox")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);
			}

			else if (id[i].equalsIgnoreCase("reasonForRaisingFundsTextBox")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);

			}

			else if (id[i].equalsIgnoreCase("profileSummaryTextArea")) {

				isInValid = false;
				isNull = false;
				display.setStatus(valueHolder, isNull, isInValid);
			} else if (id[i].equalsIgnoreCase("dateBox")) {

				isNull = false;
				isInValid = false;
				display.setStatus(valueHolder, isNull, isInValid);
			}

		}

	}
/**
 * Validation for patient detail fields
 * @param id
 */
	@SuppressWarnings("deprecation")
	public void doValidation(String[] id) {

		date.setDate(date.getDate() -1);

		profileDetails = new ProfileDetailsFields();

		patientDetails = new BeneficiaryDetailsFields();

		validemail = new EmailValidator();

		for (int i = 0; i < id.length; i++) {

			valueHolder = id[i];

			if (id[i].equalsIgnoreCase("titleOfYourPageTextBox")) {

				titleOfYourPage = display.getTitleOfYourPageTextBox()
						.getValue().trim();
				display.getTitleOfYourPageTextBox().setValue(titleOfYourPage);

				if (titleOfYourPage == null || titleOfYourPage.isEmpty()) {
					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.stringValidate(titleOfYourPage) == false) {
					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					profileDetails.setTitleOfYourPagePanel(titleOfYourPage);

				}
			} else if (id[i].equalsIgnoreCase("donationNeededTextBox")) {

				donationNeeded = display.getDonationNeededTextBox().getValue()
						.trim();
				display.getDonationNeededTextBox().setValue(donationNeeded);

				if (donationNeeded == null || donationNeeded.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.integerValidate(donationNeeded) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					profileDetails.setDonationNeededPanel(donationNeeded);

				}

			} else if (id[i].equalsIgnoreCase("reasonForRaisingFundsTextBox")) {

				reasonsforRaisingFunds = display
						.getReasonForRaisingFundsTextBox().getValue().trim();
				display.getReasonForRaisingFundsTextBox().setValue(
						reasonsforRaisingFunds);

				if (reasonsforRaisingFunds == null
						|| reasonsforRaisingFunds.isEmpty()) {
					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.stringValidate(reasonsforRaisingFunds) == false) {
					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					profileDetails
							.setReasonForRaisingFundsPanel(reasonsforRaisingFunds);

				}

			} else if (id[i].equalsIgnoreCase("profileSummaryTextArea")) {

				profileSummary = display.getProfileSummaryTextArea().getValue()
						.trim();
				display.getProfileSummaryTextArea().setValue(profileSummary);

				if (profileSummary == null || profileSummary.isEmpty()) {
					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} /*else if (validemail.usernameValidate(profileSummary) == false) {
					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				}*/ else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					profileDetails
							.setProfileSummaryPanel(profileSummary);

				}

			} else if (id[i].equalsIgnoreCase("dateBox")) {

				dateOfBirth = display.getDob().getValue();
				if (dateOfBirth == null) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (dateOfBirth.before(date)) {
					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

					//dateTimeFormat = DateTimeFormat.getFormat("dd - MM - yyyy");
					//String dateInString = dateTimeFormat.format(dateOfBirth);
					profileDetails.setEndCollectingMoneyOnPanel(dateOfBirth);
					
				}

			}

		}
		
		
		validateSendToServer();
		
	}
	public void validateSendToServer() {

		if (profileDetails.getTitleOfYourPagePanel() != null && 
				profileDetails.getDonationNeededPanel() != null
				&& profileDetails.getProfileSummaryPanel() != null
				&& profileDetails.getReasonForRaisingFundsPanel() != null
				&& profileDetails.getEndCollectingMoneyOnPanel() != null
				/*&& beneficiaryDetailsFields.gete != null
				&& beneficiaryDetailsFields.getAddressLine2() != null
				&& beneficiaryDetailsFields.getCity() != null
				&& beneficiaryDetailsFields.getState() != null
				&& beneficiaryDetailsFields.getZip() != null
				&& beneficiaryDetailsFields.getPhoneNumber() != null*/) {
			
			onNextPage(profileDetails);

		}

	}
	
	public void onNextPage(ProfileDetailsFields profileDetailsFields){		
//		patientDetailServiceAsync.doLogin(loginModel, new AsyncCallback<ProfileDetailsFields>() {
//			
//			public void onSuccess(ProfileDetailsFields employee) {
		
	//	System.out.println("&&&&&&&&&&&&" + profileDetailsFields.getEndCollectingMoneyOnPanel());
		sessionData(profileDetailsFields);
		
		
		
	}

	private void sessionData(ProfileDetailsFields profileDetailsFields) {
			//	System.out.println(employee.getDonationNeededPanel());
			//	RootPanel.get().remove(0);
				SessionDataHolder sessionDataHolder = new SessionDataHolder();
				sessionDataHolder.setSecondScreendetails(profileDetailsFields);
			//	System.out.println("**** " +sessionDataHolder.getSecondScreendetails().getTitleOfYourPagePanel());

				ApplicationData.getInstance().injectSessionDataHolder("profileDetailsFields", sessionDataHolder);
				
				
				//System.out.println(((ProfileDetailsFields)

				/*System.out
						.println("%%%%%%" +((ProfileDetailsFields) (((SessionDataHolder) ApplicationData
								.getInstance().getSessionDataHolder(
										"profileDetailsFields")).getSecondScreendetails()))
								.getEndCollectingMoneyOnPanel());*/
				
				
					//	.getEndCollectingMoneyOnPanel());

				RootPanel.get("top").clear();
				
				BeneficiaryDetailsView display = new BeneficiaryDetailsView();
				BeneficiaryDetailsPresenter presenter = new BeneficiaryDetailsPresenter(display, eventBus);
				presenter.bind();

				RootPanel.get("top").add(presenter.getDisplay().asWidget());
				
				/*BeneficiaryDetailsView displayBeneficiary = new BeneficiaryDetailsView();
				BeneficiaryDetailsPresenter presenterBeneficiary = new BeneficiaryDetailsPresenter(
						display, eventBus);
				
				populateBeneficiaryFields(presenterBeneficiary);*/
			//	if(ApplicationData.getInstance().getSessionDataHolder("beneficiaryDetailsFields").getBeneficiarysessionDetails(). != null){
			//	populateBeneficiaryFields(presenter);
				//}
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
	
	public void populateBeneficiaryFields(BeneficiaryDetailsPresenter presenterBeneficiary){
		

		//if(beneficiaryDetailsFields != null){
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
		presenterBeneficiary.getDisplay().gethospitalNameTextBox().setValue(beneficiaryDetailsFields.getHospitalName());
		//}
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
	 * @return patientDetails
	 */

	/*public ProfileDetailsFields getProfileDetailFields() {
		return profileDetails;*/

	public BeneficiaryDetailsFields getProfileDetailFields() {
		return patientDetails;
	}
}
