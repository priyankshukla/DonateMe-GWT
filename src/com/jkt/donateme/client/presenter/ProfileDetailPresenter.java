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
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.jkt.donateme.client.model.ProfileDetailsField;
import com.jkt.donateme.client.validation.EmailValidator;

public class ProfileDetailPresenter extends
		WidgetPresenter<ProfileDetailPresenter.Display> {

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
	private ProfileDetailsField patientDetails;
	private DateTimeFormat dateTimeFormat;

	public interface Display extends WidgetDisplay {

		public HasValue<String> getTitleOfYourPageTextBox();

		public HasValue<String> getDonationNeededTextBox();

		public HasValue<String> getReasonForRaisingFundsTextBox();

		public HasValue<String> getProfileSummaryTextArea();

		public HasClickHandlers getnextButton();

		public DateBox getDob();

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
		patientDetails = new ProfileDetailsField();
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

				} else if (validemail.usernameValidate(titleOfYourPage) == false) {
					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {
					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					patientDetails.setTitleOfYourPagePanel(titleOfYourPage);

				}
			} else if (id[i].equalsIgnoreCase("donationNeededTextBox")) {

				donationNeeded = display.getDonationNeededTextBox().getValue()
						.trim();
				display.getDonationNeededTextBox().setValue(donationNeeded);

				if (donationNeeded == null || donationNeeded.isEmpty()) {

					isNull = true;
					isInValid = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else if (validemail.donationAmountValidate(donationNeeded) == false) {

					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					patientDetails.setDonationNeededPanel(donationNeeded);

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

				} else if (validemail.usernameValidate(reasonsforRaisingFunds) == false) {
					isInValid = true;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);

				} else {

					isInValid = false;
					isNull = false;
					display.setStatus(valueHolder, isNull, isInValid);
					patientDetails
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
					patientDetails
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

					dateTimeFormat = DateTimeFormat.getFormat("dd - MM - yyyy");
					String dateInString = dateTimeFormat.format(dateOfBirth);
					patientDetails.setEndCollectingMoneyOnPanel(dateInString);
				}

			}

		}

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
	 * @return patientDetails
	 */
	public ProfileDetailsField getProfileDetailFields() {
		return patientDetails;
	}
}
