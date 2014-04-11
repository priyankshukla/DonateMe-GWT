package com.jkt.donateme.client.view;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.jkt.donateme.client.calendar.DatePickerWithYearSelectorNew;
import com.jkt.donateme.client.presenter.SignUpPresenter.Display;

public class SignUpView extends Composite implements Display {

	private FormPanel formPanel;

	private VerticalPanel signUpFieldsPanel;

	private HorizontalPanel firstNamePanel;
	private HorizontalPanel lastNamePanel;
	private HorizontalPanel emailPanel;
	private HorizontalPanel passwordPanel;
	private HorizontalPanel confirmPasswordPanel;
	private HorizontalPanel captchaPanel;
	private HorizontalPanel getStartedButtonPanel;
	private HorizontalPanel genderPanel;
	private HorizontalPanel genderRadioPanel;
	private HorizontalPanel dOBPanel;

	private Label firstNameLabel;
	private Label lastNameLabel;
	private Label emailLabel;
	private Label passwordLabel;
	private Label confirmPasswordLabel;
	private Label genderLabel;
	private Label dOBLabel;
	private Label firstNameErrorLabel;
	private Label lastNameErrorLabel;
	private Label emailErrorLabel;
	private Label genderErrorLabel;
	private Label dobErrorLabel;
	private Label passwordErrorLabel;
	private Label confirmPasswordErrorLabel;
	private Label passwordSizeLabel;

	private TextBox lastNameTextBox;
	private TextBox emailTextBox;
	private TextBox firstNameTextBox;
	private PasswordTextBox passwordTextBox;
	private PasswordTextBox confirmPasswordTextBox;
	private DateBox dateBox;
	private RadioButton mRadioButton;
	private RadioButton fmRadioButton;
	private Button getStartedButton;
	DateTimeFormat dateTimeFormat;
	DefaultFormat defaultFormat;
	ClickHandler doBImageClickhandler;
	DatePickerWithYearSelectorNew datePickerWithYearSelectorNew;
	Date date = new Date();

	/**
	 * Constructor for the SignUp View That gets the FormPanel.
	 */
	public SignUpView() {

		getSignUpView();

	}

	/**
	 * This method creates the patient Registration Form panel.
	 * 
	 * @return formPanel
	 */
	public FormPanel getSignUpView() {

		/**
		 * Adds a click Handler to the calendar image .
		 */
		doBImageClickhandler = new ClickHandler() {
			public void onClick(ClickEvent event) {
				dateBox.showDatePicker();
			}
		};

		HTML html = new HTML("*");
		html.setStyleName("htmlstyle");

		formPanel = new FormPanel();

		formPanel.addStyleName("form");

		signUpFieldsPanel = new VerticalPanel();
		signUpFieldsPanel.addStyleName("signUpPanel");
		formPanel.add(signUpFieldsPanel);
		initWidget(formPanel);

		firstNamePanel = new HorizontalPanel();
		firstNamePanel.addStyleName("stylehorizontalpanel");
		signUpFieldsPanel.add(firstNamePanel);
		firstNameLabel = new Label("First Name");
		firstNameLabel.addStyleName("fieldlabel");
		HTML firstNameHtml = new HTML(firstNameLabel + "" + html);
		firstNameHtml.setStyleName("mandatoryhtmlpanel");
		firstNamePanel.add(firstNameHtml);
		firstNameTextBox = new TextBox();

		firstNameTextBox.setName("firstNameTextBox");

		firstNameTextBox.addStyleName("styletextbox");
		firstNameTextBox.setMaxLength(20);
		firstNamePanel.add(firstNameTextBox);
		firstNameErrorLabel = new Label();
		firstNameErrorLabel.setVisible(false);
		signUpFieldsPanel.add(firstNameErrorLabel);

		lastNamePanel = new HorizontalPanel();
		lastNamePanel.addStyleName("stylehorizontalpanel");
		signUpFieldsPanel.add(lastNamePanel);
		lastNameLabel = new Label("Last Name");
		lastNameLabel.addStyleName("fieldlabel");
		HTML lastNameHtml = new HTML(lastNameLabel + "" + html);
		lastNameHtml.setStyleName("mandatoryhtmlpanel");
		lastNamePanel.add(lastNameHtml);
		lastNameTextBox = new TextBox();
		lastNameTextBox.setName("lastNameTextBox");
		lastNameTextBox.addStyleName("styletextbox");
		lastNameTextBox.setMaxLength(20);
		lastNamePanel.add(lastNameTextBox);
		lastNameErrorLabel = new Label();
		lastNameErrorLabel.setVisible(false);
		signUpFieldsPanel.add(lastNameErrorLabel);

		dOBPanel = new HorizontalPanel();
		dOBPanel.addStyleName("stylehorizontalpanel");
		dOBLabel = new Label("Date of Birth");
		dOBLabel.addStyleName("fieldlabel");
		HTML dobHtml = new HTML(dOBLabel + "" + html);
		dobHtml.setStyleName("mandatoryhtmlpanel");
		dOBPanel.add(dobHtml);
		signUpFieldsPanel.add(dOBPanel);
		dateTimeFormat = DateTimeFormat.getFormat("dd - MM - yyyy");
		defaultFormat = new DefaultFormat(dateTimeFormat);
		datePickerWithYearSelectorNew = new DatePickerWithYearSelectorNew();
		dateBox = new DateBox(datePickerWithYearSelectorNew, null,
				defaultFormat);

		dateBox.getTextBox().setName("dateBox");
		dateBox.getTextBox().setReadOnly(true);
		dateBox.addStyleName("styletextbox");
		dOBPanel.add(dateBox);
		Image img = new Image("./images/calendar.png");
		img.addClickHandler(doBImageClickhandler);
		img.addStyleName("dobcalenderimage");
		dOBPanel.add(img);
		dobErrorLabel = new Label();
		dobErrorLabel.setVisible(false);
		signUpFieldsPanel.add(dobErrorLabel);

		genderPanel = new HorizontalPanel();
		genderPanel.addStyleName("stylehorizontalpanel");
		signUpFieldsPanel.add(genderPanel);
		genderLabel = new Label("Gender");
		genderLabel.addStyleName("fieldlabel");
		HTML genderHtml = new HTML(genderLabel + "" + html);
		genderHtml.setStyleName("mandatoryhtmlpanel");
		genderPanel.add(genderHtml);
		genderRadioPanel = new HorizontalPanel();
		genderRadioPanel.addStyleName("styleradiopanel");
		mRadioButton = new RadioButton("Gender", "  Male");
		genderRadioPanel.add(mRadioButton);
		fmRadioButton = new RadioButton("Gender", "  Female");
		genderRadioPanel.add(fmRadioButton);
		genderPanel.add(genderRadioPanel);
		signUpFieldsPanel.add(genderPanel);
		genderErrorLabel = new Label();
		genderErrorLabel.setVisible(false);
		signUpFieldsPanel.add(genderErrorLabel);

		emailPanel = new HorizontalPanel();
		emailPanel.addStyleName("stylehorizontalpanel");
		signUpFieldsPanel.add(emailPanel);
		emailLabel = new Label("Email");
		emailLabel.addStyleName("fieldlabel");
		HTML emailHtml = new HTML(emailLabel + "" + html);
		emailHtml.setStyleName("mandatoryhtmlpanel");
		emailPanel.add(emailHtml);
		emailTextBox = new TextBox();
		emailTextBox.setName("emailTextBox");
		emailTextBox.addStyleName("styletextbox");
		emailTextBox.setMaxLength(50);
		emailPanel.add(emailTextBox);
		emailErrorLabel = new Label();
		emailErrorLabel.setVisible(false);
		signUpFieldsPanel.add(emailErrorLabel);

		passwordPanel = new HorizontalPanel();
		passwordPanel.addStyleName("stylehorizontalpanel");
		signUpFieldsPanel.add(passwordPanel);
		passwordLabel = new Label("Password");
		passwordLabel.addStyleName("fieldlabel");
		HTML passwordHtml = new HTML(passwordLabel + "" + html);
		passwordHtml.setStyleName("mandatoryhtmlpanel");
		passwordPanel.add(passwordHtml);
		passwordTextBox = new PasswordTextBox();
		passwordTextBox.setName("passwordTextBox");
		passwordTextBox.addStyleName("passwordtextbox");
		passwordPanel.add(passwordTextBox);
		passwordSizeLabel = new Label();
		passwordSizeLabel.setText("Should be 6 to 12 character");
		passwordSizeLabel.addStyleName("passwordlabel");
		passwordPanel.add(passwordSizeLabel);
		passwordErrorLabel = new Label();
		passwordErrorLabel.setVisible(false);
		signUpFieldsPanel.add(passwordErrorLabel);

		confirmPasswordPanel = new HorizontalPanel();
		confirmPasswordPanel.addStyleName("stylehorizontalpanel");
		signUpFieldsPanel.add(confirmPasswordPanel);
		confirmPasswordLabel = new Label("Confirm Password");
		confirmPasswordLabel.addStyleName("fieldlabel");
		HTML confirmPasswordHtml = new HTML(confirmPasswordLabel + "" + html);
		confirmPasswordHtml.setStyleName("mandatoryhtmlpanel");
		confirmPasswordPanel.add(confirmPasswordHtml);
		confirmPasswordTextBox = new PasswordTextBox();

		confirmPasswordTextBox.setName("confirmPasswordTextBox");
		confirmPasswordTextBox.addStyleName("styletextbox");
		confirmPasswordTextBox.setMaxLength(50);
		confirmPasswordPanel.add(confirmPasswordTextBox);
		confirmPasswordErrorLabel = new Label();
		confirmPasswordErrorLabel.setVisible(false);
		signUpFieldsPanel.add(confirmPasswordErrorLabel);

		captchaPanel = new HorizontalPanel();
		signUpFieldsPanel.add(captchaPanel);

		getStartedButtonPanel = new HorizontalPanel();
		getStartedButtonPanel.addStyleName("stylehorizontalpanel");
		getStartedButton = new Button("Get Started");

		getStartedButton.addStyleName("getStartedButton");
		getStartedButtonPanel.add(getStartedButton);
		signUpFieldsPanel.add(getStartedButtonPanel);

		return formPanel;

	}

	/**
	 * @return firstNameTextBox Getter HasValue for firstName
	 */
	public HasValue<String> getfirstNameTextBox() {
		return firstNameTextBox;
	}

	/**
	 * @return emailTextBox Getter HasValue for
	 */
	public HasValue<String> getlastNameTextBox() {
		return lastNameTextBox;
	}

	/**
	 * @return emailTextBox Getter HasValue for
	 */
	public HasValue<String> getEmailTextBox() {
		return emailTextBox;
	}

	/**
	 * @return passwordTextBox Getter HasValue for
	 */
	public HasValue<String> getPasswordTextBox() {
		return passwordTextBox;
	}

	/**
	 * @return confirmPasswordTextBox Getter HasValue for
	 */

	public HasValue<String> getConfirmPasswordTextBox() {
		return confirmPasswordTextBox;
	}

	/**
	 * @return getStartedButton Getter HasValue for
	 */
	public HasClickHandlers getbtnGetStarted() {
		return getStartedButton;
	}

	public RadioButton getmRadioButton() {
		return mRadioButton;
	}

	public RadioButton getfmRadioButton() {
		return fmRadioButton;
	}

	public DateBox getDob() {
		return dateBox;
	}

	public void setStatus(String id, boolean isNull, boolean isInValid,
			boolean isPasswordShort, boolean isPasswordLong) {

		if (id.equals("firstNameTextBox")) {

			if (isNull) {
				firstNameTextBox.addStyleName("invalid");
				firstNameErrorLabel.setVisible(true);
				firstNameErrorLabel.setText("You can't leave this empty ");
				firstNameErrorLabel.addStyleName("responselabelerror");

			} else if (isInValid) {
				firstNameTextBox.addStyleName("invalid");
				firstNameErrorLabel.setVisible(true);
				firstNameErrorLabel
						.setText(" Please enter the first name in correct format ");
				firstNameErrorLabel.addStyleName("responselabelerror");
			} else {

				firstNameTextBox.removeStyleName("invalid");
				firstNameErrorLabel.setVisible(false);
			}

		} else if (id.equalsIgnoreCase("lastNameTextBox")) {

			if (isNull) {

				lastNameTextBox.addStyleName("invalid");
				lastNameErrorLabel.setVisible(true);
				lastNameErrorLabel.setText("You can't leave this empty ");
				lastNameErrorLabel.addStyleName("responselabelerror");

			} else if (isInValid) {

				lastNameTextBox.addStyleName("invalid");
				lastNameErrorLabel.setVisible(true);
				lastNameErrorLabel
						.setText(" Please enter the Last name in correct format ");
				lastNameErrorLabel.addStyleName("responselabelerror");

			} else {
				lastNameTextBox.removeStyleName("invalid");
				lastNameErrorLabel.setVisible(false);

			}

		} else if (id.equalsIgnoreCase("dateBox")) {

			if (isNull) {
				dateBox.addStyleName("invalid");
				dobErrorLabel.setVisible(true);
				dobErrorLabel.setText("Date should be selected");
				dobErrorLabel.addStyleName("responselabelerror");

			} else if (isInValid) {

				dateBox.addStyleName("invalid");
				dobErrorLabel.setVisible(true);
				dobErrorLabel.setText("Future date cannot be selected");
				dobErrorLabel.addStyleName("responselabelerror");

			} else {

				dateBox.removeStyleName("invalid");
				dobErrorLabel.setVisible(false);
			}

		} else if (id.equalsIgnoreCase("emailTextBox")) {

			if (isNull) {

				emailTextBox.addStyleName("invalid");
				emailErrorLabel.setVisible(true);
				emailErrorLabel.setText("You can't leave this empty ");
				emailErrorLabel.addStyleName("responselabelerror");
			} else if (isInValid) {
				emailTextBox.addStyleName("invalid");
				emailErrorLabel.setVisible(true);
				emailErrorLabel
						.setText(" Please enter a valid e-mail address ");
				emailErrorLabel.addStyleName("responselabelerror");

			} else {

				emailTextBox.removeStyleName("invalid");
				emailErrorLabel.setVisible(false);
			}
		} else if (id.equalsIgnoreCase("passwordTextBox")) {

			if (isNull) {
				passwordTextBox.addStyleName("invalid");
				passwordErrorLabel.setVisible(true);
				passwordErrorLabel.setText("You can't leave this empty ");
				passwordErrorLabel.addStyleName("responselabelerror");
			} else if (isPasswordShort) {

				passwordTextBox.addStyleName("invalid");
				confirmPasswordTextBox.addStyleName("invalid");
				passwordErrorLabel.setVisible(true);
				passwordErrorLabel.setText("Password is too short");
				passwordErrorLabel.addStyleName("responselabelerror");

			} else if (isPasswordLong) {

				passwordTextBox.addStyleName("invalid");
				confirmPasswordTextBox.addStyleName("invalid");
				passwordErrorLabel.setVisible(true);
				passwordErrorLabel.setText("Password is too Long");
				passwordErrorLabel.addStyleName("responselabelerror");

			} else {
				passwordTextBox.removeStyleName("invalid");
				passwordErrorLabel.setVisible(false);

			}

		} else if (id.equalsIgnoreCase("confirmPasswordTextBox")) {

			if (isNull) {

				confirmPasswordTextBox.addStyleName("invalid");
				confirmPasswordErrorLabel.setVisible(true);
				confirmPasswordErrorLabel
						.setText("You can't leave this empty ");
				confirmPasswordErrorLabel.addStyleName("responselabelerror");

			} else if (isInValid) {

				passwordTextBox.addStyleName("invalid");
				confirmPasswordTextBox.addStyleName("invalid");
				confirmPasswordErrorLabel.setVisible(true);
				confirmPasswordErrorLabel.setText(" Password does not match ");
				confirmPasswordErrorLabel.addStyleName("responselabelerror");

			} else {
				confirmPasswordTextBox.removeStyleName("invalid");
				confirmPasswordErrorLabel.setVisible(false);

			}

		} else {

			if (isNull) {

				genderErrorLabel.setVisible(true);
				genderErrorLabel.setText("Please select the gender");
				genderErrorLabel.addStyleName("responselabelerror");

			} else {

				genderErrorLabel.setVisible(false);
			}
		}
	}

	/**
	 * Error validation for not entering duplicate email id
	 * 
	 */
	public void duplicateEmailError() {
		emailTextBox.addStyleName("invalid");
		emailErrorLabel.setVisible(true);
		emailErrorLabel
				.setText(" Email already exists. Please choose another email id ");
		emailErrorLabel.addStyleName("responselabelerror");

	}

}