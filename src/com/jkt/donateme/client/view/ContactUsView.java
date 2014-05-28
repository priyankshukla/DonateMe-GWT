package com.jkt.donateme.client.view;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.jkt.donateme.client.presenter.ContactUsPresenter.Display;

public class ContactUsView extends Composite implements Display {

	
	private FormPanel formPanel;

	private VerticalPanel signUpFieldsPanel;
	private HorizontalPanel contactUsPanel;
	private HorizontalPanel feedbackTextPanel;

	private HorizontalPanel firstNamePanel;
	
	
	
	private HorizontalPanel subjectPanel;
	private HorizontalPanel messagePanel;
	private HorizontalPanel emailPanel;
	private HorizontalPanel phoneNumberPanel;
	private HorizontalPanel getStartedButtonPanel;
	private HorizontalPanel signCaptionPanel;
	private HorizontalPanel profileDetailCaptionPanel;
	private HorizontalPanel beneficiaryDetailCaptionPanel;
	private Label contactUsLabel;
	private Label feedbackTextlabel;
	private Label firstNameLabel;
	private Label subjectLabel;
	private Label messageLabel;
	private Label emailLabel;
	private Label phoneNumberLabel;
	private Label firstNameErrorLabel;
	private Label lastNameErrorLabel;
	private Label messageerrorlabel;
	private Label emailErrorLabel;
	private Label phoneNumberErrorLabel;
	private Label signupCaptionLabel;
	private Label profileDetailCaptionLabel;
	private Label beneficiaryDetailCaptionLabel;
	private TextBox subjectTextBox;
	private TextArea profileSummaryTextArea;
	private TextBox emailTextBox;
	private TextBox firstNameTextBox;
	private TextBox phoneNumberTextBox;
	private Button getStartedButton;
	DateTimeFormat dateTimeFormat;
	DefaultFormat defaultFormat;
	ClickHandler doBImageClickhandler;
	private HorizontalPanel mainPanel;
	private VerticalPanel sideimagePanel;
	
	

	/**
	 * Constructor for the SignUp View That gets the FormPanel.
	 */
	public ContactUsView() {

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
		

		HTML html = new HTML("*");
		html.setStyleName("htmlstyle");

		formPanel = new FormPanel();

	

		signUpFieldsPanel = new VerticalPanel();
		signUpFieldsPanel.addStyleName("signUpPanel");
		 mainPanel = new HorizontalPanel();
        sideimagePanel = new VerticalPanel();
        sideimagePanel.addStyleName("sideimage");
       
		mainPanel.add(signUpFieldsPanel);
		mainPanel.add(sideimagePanel);
		formPanel.add(mainPanel);
		initWidget(formPanel);
		
		
		
	    signCaptionPanel = new HorizontalPanel();
		signCaptionPanel.addStyleName("innercaptionpanel");
		signupCaptionLabel = new Label("Call us 8582007436");
		signupCaptionLabel.addStyleName("calluscaptionLabel");
		Image signUpImg = new Image("./images/callus.png");
		signUpImg.addStyleName("calluscaptionimage");
		signCaptionPanel.add(signUpImg);
		signCaptionPanel.add(signupCaptionLabel);
		sideimagePanel.add(signCaptionPanel);
		
		
		
		profileDetailCaptionPanel = new HorizontalPanel();
		
		profileDetailCaptionLabel = new Label("Email us info@donateme.com");
		profileDetailCaptionLabel.addStyleName("emailcaptionLabel");
		Image profileCaptionImg = new Image("./images/email.png");
		profileCaptionImg.addStyleName("emailcaptionimage");
		profileDetailCaptionPanel.add(profileCaptionImg);
		profileDetailCaptionPanel.add(profileDetailCaptionLabel);
		sideimagePanel.add(profileDetailCaptionPanel);
		
		
		beneficiaryDetailCaptionPanel = new HorizontalPanel();
		beneficiaryDetailCaptionPanel.addStyleName("innercaptionpanel");
		beneficiaryDetailCaptionLabel = new Label("  Fax 8582007436");
		beneficiaryDetailCaptionLabel.addStyleName("faxcaptionLabel");
		Image beneficiaryDetailImg = new Image("./images/fax.png");
		beneficiaryDetailImg.addStyleName("faxcaptionimage");
		beneficiaryDetailCaptionPanel.add(beneficiaryDetailImg);
		beneficiaryDetailCaptionPanel.add(beneficiaryDetailCaptionLabel);
		sideimagePanel.add(beneficiaryDetailCaptionPanel);
		
		
	
		
		contactUsPanel = new HorizontalPanel();
		contactUsPanel.addStyleName("stylehorizontalpanel");
		signUpFieldsPanel.add(contactUsPanel);
		contactUsLabel = new Label("Contact us");
		contactUsLabel.addStyleName("contactuslabel");
		contactUsPanel.add(contactUsLabel);
		
		feedbackTextPanel = new HorizontalPanel();
		feedbackTextPanel.addStyleName("contactusstylehorizontalpanel");
		signUpFieldsPanel.add(feedbackTextPanel);
		feedbackTextlabel = new Label("If you have any feedback,testimonials, ideas or any questions, please feel free to contact us using our contact data or the form below.");
		feedbackTextlabel.addStyleName("feedbacktextlabel");
		feedbackTextPanel.add(feedbackTextlabel);
		
		
		
		
		
       
		//your name
		firstNamePanel = new HorizontalPanel();
		firstNamePanel.addStyleName("contactusstylehorizontalpanel");
		signUpFieldsPanel.add(firstNamePanel);
		firstNameLabel = new Label("Your Name");
		firstNameLabel.addStyleName("contactusfieldlabel");
		HTML firstNameHtml = new HTML(firstNameLabel + "" + html);
		firstNameHtml.setStyleName("mandatoryhtmlpanel");
		firstNamePanel.add(firstNameHtml);
		firstNameTextBox = new TextBox();

		firstNameTextBox.setName("firstNameTextBox");

		firstNameTextBox.addStyleName("contactustextbox");
		
		firstNamePanel.add(firstNameTextBox);
		firstNameErrorLabel = new Label();
		firstNameErrorLabel.setVisible(false);
		signUpFieldsPanel.add(firstNameErrorLabel);
		
		
		

		

		
		emailPanel = new HorizontalPanel();
		emailPanel.addStyleName("stylehorizontalpanel");
		signUpFieldsPanel.add(emailPanel);
		emailLabel = new Label("Email");
		emailLabel.addStyleName("contactusfieldlabel");
		HTML emailHtml = new HTML(emailLabel + "" + html);
		emailHtml.setStyleName("mandatoryhtmlpanel");
		emailPanel.add(emailHtml);
		emailTextBox = new TextBox();
		emailTextBox.setName("emailTextBox");
		emailTextBox.addStyleName("contactustextbox");
		emailTextBox.setMaxLength(50);
		emailPanel.add(emailTextBox);
		emailErrorLabel = new Label();
		emailErrorLabel.setVisible(false);
		signUpFieldsPanel.add(emailErrorLabel);
		
		
		
		//phone number
		phoneNumberPanel = new HorizontalPanel();
		phoneNumberPanel.addStyleName("stylehorizontalpanel");
		signUpFieldsPanel.add(phoneNumberPanel);
		phoneNumberLabel = new Label("Phone Number");
		phoneNumberLabel.addStyleName("contactusfieldlabel");
		HTML phoneNumberHtml = new HTML(phoneNumberLabel + "" + html);
		phoneNumberHtml.setStyleName("mandatoryhtmlpanel");
		phoneNumberPanel.add(phoneNumberHtml);
		phoneNumberTextBox = new TextBox();
		phoneNumberTextBox.addStyleName("contactustextbox");
		phoneNumberTextBox.setName("phoneNumberTextBox");
		phoneNumberTextBox.setMaxLength(10);
		phoneNumberPanel.add(phoneNumberTextBox);
		phoneNumberErrorLabel = new Label();
		phoneNumberErrorLabel.setVisible(false);
		signUpFieldsPanel.add(phoneNumberErrorLabel);
		
		
		
		
		
		
		
		//subject
		
		subjectPanel = new HorizontalPanel();
		subjectPanel.addStyleName("stylehorizontalpanel");
		signUpFieldsPanel.add(subjectPanel);
		subjectLabel = new Label("Subject");
		subjectLabel.addStyleName("contactusfieldlabel");
		HTML subjectHtml1 = new HTML(subjectLabel + "" + html);
		subjectHtml1.setStyleName("mandatoryhtmlpanel");
		subjectPanel.add(subjectHtml1);
		subjectTextBox = new TextBox();
		subjectTextBox.setName("subjectTextBox");
		subjectTextBox.addStyleName("contactustextbox");
		subjectTextBox.setMaxLength(40);
		subjectPanel.add(subjectTextBox);
		lastNameErrorLabel = new Label();
		lastNameErrorLabel.setVisible(false);
		signUpFieldsPanel.add(lastNameErrorLabel);
		
		
		//message
		messagePanel = new HorizontalPanel();
		messagePanel.addStyleName("stylehorizontalpanel");
		signUpFieldsPanel.add(messagePanel);
		messageLabel = new Label("Message");
		messageLabel.addStyleName("contactusfieldlabel");
		HTML messageNameHtml = new HTML(messageLabel + "" + html);
		messageNameHtml.setStyleName("mandatoryhtmlpanel");
		messagePanel.add(messageNameHtml);
		profileSummaryTextArea = new TextArea();
		
		profileSummaryTextArea.getElement().setAttribute("maxlength", "150");
		profileSummaryTextArea.setName("profileSummaryTextArea");
		profileSummaryTextArea.addStyleName("contactusmessagetextarea");
		messagePanel.add(profileSummaryTextArea);
		
		
		
		messageerrorlabel = new Label();
		messageerrorlabel.setVisible(false);
		signUpFieldsPanel.add(messageerrorlabel);
		
		
		
		
		
		

		

		
		//button
		getStartedButtonPanel = new HorizontalPanel();
		getStartedButtonPanel.addStyleName("stylehorizontalpanel");
		getStartedButton = new Button("Submit");

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
	public HasValue<String> getsubjectTextBox() {
		return subjectTextBox;
	}

	/**
	 * @return emailTextBox Getter HasValue for
	 */
	public HasValue<String> getEmailTextBox() {
		return emailTextBox;
	}

	public HasValue<String> getPhoneNumberTextBox() {
		return phoneNumberTextBox;
	}
	
	
	public HasClickHandlers getbtnGetStarted() {
		return getStartedButton;
	}

	

	public void setStatus(String id, boolean isNull, boolean isInValid,
			boolean isPasswordShort, boolean isPasswordLong) {

		if (id.equals("firstNameTextBox")) {

			if (isNull) {
				firstNameTextBox.addStyleName("invalid");
				firstNameErrorLabel.setVisible(true);
				firstNameErrorLabel.setText("You can't leave this empty ");
				firstNameErrorLabel.addStyleName("contactusresponselabelerror");

			} else if (isInValid) {
				firstNameTextBox.addStyleName("invalid");
				firstNameErrorLabel.setVisible(true);
				firstNameErrorLabel
						.setText("Please enter the name in correct format ");
				firstNameErrorLabel.addStyleName("contactusresponselabelerror");
			} else {

				firstNameTextBox.removeStyleName("invalid");
				firstNameErrorLabel.setVisible(false);
			}

		} else if (id.equalsIgnoreCase("subjectTextBox")) {

			if (isNull) {

				subjectTextBox.addStyleName("invalid");
				lastNameErrorLabel.setVisible(true);
				lastNameErrorLabel.setText("You can't leave this empty ");
				lastNameErrorLabel.addStyleName("contactusresponselabelerror");

			} else if (isInValid) {

				subjectTextBox.addStyleName("invalid");
				lastNameErrorLabel.setVisible(true);
				lastNameErrorLabel
						.setText("Please enter a valid subject");
				lastNameErrorLabel.addStyleName("contactusresponselabelerror");

			} else {
				subjectTextBox.removeStyleName("invalid");
				lastNameErrorLabel.setVisible(false);

			}

		}
		
		else if (id.equalsIgnoreCase("profileSummaryTextArea")) {

			if (isNull) {

				profileSummaryTextArea.addStyleName("invalid");
				messageerrorlabel.setVisible(true);
				messageerrorlabel.setText("You can't leave this empty ");
				messageerrorlabel.addStyleName("contactusresponselabelerror");

			}  else {
				profileSummaryTextArea.removeStyleName("invalid");
				messageerrorlabel.setVisible(false);

			}

		}
		
		else if (id.equalsIgnoreCase("phoneNumberTextBox")) {

			if (isNull) {

				phoneNumberTextBox.addStyleName("invalid");
				phoneNumberErrorLabel.setVisible(true);
				phoneNumberErrorLabel.setText("You can't leave this empty ");
				phoneNumberErrorLabel.addStyleName("contactusresponselabelerror");

			} else if (isInValid) {

				phoneNumberTextBox.addStyleName("invalid");
				phoneNumberErrorLabel.setVisible(true);
				phoneNumberErrorLabel
						.setText("Please enter a valid Phone Number");
				phoneNumberErrorLabel.addStyleName("contactusresponselabelerror");

			} else {
				phoneNumberTextBox.removeStyleName("invalid");
				phoneNumberErrorLabel.setVisible(false);

			}

		}
		
		
		 else if (id.equalsIgnoreCase("emailTextBox")) {

			if (isNull) {

				emailTextBox.addStyleName("invalid");
				emailErrorLabel.setVisible(true);
				emailErrorLabel.setText("You can't leave this empty ");
				emailErrorLabel.addStyleName("contactusresponselabelerror");
			} else if (isInValid) {
				emailTextBox.addStyleName("invalid");
				emailErrorLabel.setVisible(true);
				emailErrorLabel
						.setText("Please enter a valid e-mail address ");
				emailErrorLabel.addStyleName("contactusresponselabelerror");

			} else {

				emailTextBox.removeStyleName("invalid");
				emailErrorLabel.setVisible(false);
			}
		}
	}

	public HasValue<String> getProfileSummaryTextArea() {
		
		return profileSummaryTextArea;
	}

	/**
	 * Error validation for not entering duplicate email id
	 * 
	 */
	
	
	
	
}
