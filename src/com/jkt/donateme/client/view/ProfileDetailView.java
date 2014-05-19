package com.jkt.donateme.client.view;

import gwtupload.client.IUploadStatus.Status;
import gwtupload.client.IUploader;
import gwtupload.client.IUploader.UploadedInfo;
import gwtupload.client.MultiUploader;
import gwtupload.client.PreloadedImage;
import gwtupload.client.PreloadedImage.OnLoadPreloadedImageHandler;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.jkt.donateme.client.calendar.DatePickerWithYearSelectorNew;
import com.jkt.donateme.client.presenter.ProfileDetailPresenter.Display;

public class ProfileDetailView extends Composite implements Display {

	private FormPanel formPanel;

	private VerticalPanel patientDetailPanel;
	private VerticalPanel upload ;
	private HorizontalPanel titleOfYourPagePanel;
	private HorizontalPanel donationNeededPanel;
	private HorizontalPanel reasonForRaisingFundsPanel;
	private HorizontalPanel profileSummaryPanel;
	private HorizontalPanel endCollectingMoneyOnPanel;
	private HorizontalPanel uploadYourProfilePicturePanel;
	private HorizontalPanel nextButtonPanel;
	private HorizontalPanel captionPanel;
	private HorizontalPanel signCaptionPanel;
	private HorizontalPanel profileDetailCaptionPanel;
	private HorizontalPanel beneficiaryDetailCaptionPanel;

	private Label titleOfYourPageLabel;
	private Label donationNeededLabel;
	private Label reasonForRaisingFundsLabel;
	private Label profileSummaryLabel;
	private Label endCollectingMoneyOnLabel;
	private Label uploadLabel ;
	private Label uploadNoteLabel ;
	private Label signupCaptionLabel;
	private Label profileDetailCaptionLabel;
	private Label beneficiaryDetailCaptionLabel;
	
	private Label titleOfYourPageErrorLabel;
	private Label donationNeededErrorLabel;
	private Label reasonForRaisingFundsErrorLabel;
	private Label profileSummaryErrorLabel;
	private Label endCollectingMoneyOnErrorLabel;
	
	private TextBox titleOfYourPageTextBox;
	private TextBox donationNeededTextBox;
	private TextBox reasonForRaisingFundsTextBox;
	private TextArea profileSummaryTextArea;
	
	private Button nextButton;
	
	private TextArea confirmPasswordTextBox;
	private DateBox dateBox;
	
	private  MultiUploader defaultUploader;
	
	DateTimeFormat dateTimeFormat;
	DefaultFormat defaultFormat;
	ClickHandler doBImageClickhandler;
	DatePickerWithYearSelectorNew datePickerWithYearSelectorNew;
	Date date = new Date();

	/**
	 * Constructor for the SignUp View That gets the FormPanel.
	 */
	public ProfileDetailView() {

		getSignUpView();

	}
	
	// A panel where the thumbnails of uploaded images will be shown
		  private FlowPanel panelImages = new FlowPanel();
	
		// Load the image in the document and in the case of success attach it to the viewer
		  private IUploader.OnFinishUploaderHandler onFinishUploaderHandler = new IUploader.OnFinishUploaderHandler() {
		    @SuppressWarnings("deprecation")
			public void onFinish(IUploader uploader) {
		      if (uploader.getStatus() == Status.SUCCESS) {

		        new PreloadedImage(uploader.fileUrl(), showImage);
		    	  
		        // The server sends useful information to the client by default
		        UploadedInfo info = uploader.getServerInfo();
		        System.out.println("File name " + info.name);
		        System.out.println("File content-type " + info.ctype);
		        System.out.println("File size " + info.size);

		        // You can send any customized message and parse it 
		        System.out.println("Server message" + info.message);
		      }
		    }
		  };
		  
		  
	  // Attach an image to the pictures viewer
	  private OnLoadPreloadedImageHandler showImage = new OnLoadPreloadedImageHandler() {
	   		public void onLoad(PreloadedImage image) {
			image.setWidth("55px");
		      panelImages.add(image);
			
		}
	  };

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

		patientDetailPanel = new VerticalPanel();
		patientDetailPanel.addStyleName("signUpPanel");
		formPanel.add(patientDetailPanel);
		initWidget(formPanel);
		
		
captionPanel = new HorizontalPanel();
		
		signCaptionPanel = new HorizontalPanel();
		signCaptionPanel.addStyleName("innercaptionpanel");
		signupCaptionLabel = new Label("Sign up");
		signupCaptionLabel.addStyleName("captionLabel");
		Image signUpImg = new Image("./images/1-red.png");
		signUpImg.addStyleName("captionimage");
		signCaptionPanel.add(signUpImg);
		signCaptionPanel.add(signupCaptionLabel);
		captionPanel.add(signCaptionPanel);
		
		profileDetailCaptionPanel = new HorizontalPanel();
		profileDetailCaptionPanel.addStyleName("innercaptionpanel");
		profileDetailCaptionLabel = new Label("Profile Detail");
		profileDetailCaptionLabel.addStyleName("captionLabel");
		Image profileCaptionImg = new Image("./images/2red.png");
		profileCaptionImg.addStyleName("captionimage");
		profileDetailCaptionPanel.add(profileCaptionImg);
		profileDetailCaptionPanel.add(profileDetailCaptionLabel);
		captionPanel.add(profileDetailCaptionPanel);
		
		
		beneficiaryDetailCaptionPanel = new HorizontalPanel();
		beneficiaryDetailCaptionPanel.addStyleName("innercaptionpanel");
		beneficiaryDetailCaptionLabel = new Label("Beneficiary Details");
		beneficiaryDetailCaptionLabel.addStyleName("captionLabel");
		Image beneficiaryDetailImg = new Image("./images/3g.png");
		beneficiaryDetailImg.addStyleName("captionimage");
		beneficiaryDetailCaptionPanel.add(beneficiaryDetailImg);
		beneficiaryDetailCaptionPanel.add(beneficiaryDetailCaptionLabel);
		captionPanel.add(beneficiaryDetailCaptionPanel);
		
		patientDetailPanel.add(captionPanel);
		
		
		
		

		titleOfYourPagePanel = new HorizontalPanel();
		titleOfYourPagePanel.addStyleName("stylehorizontalpanel");
		patientDetailPanel.add(titleOfYourPagePanel);
		titleOfYourPageLabel = new Label("Title of your page");
		titleOfYourPageLabel.addStyleName("fieldlabel");
		HTML firstNameHtml = new HTML(titleOfYourPageLabel + "" + html);
		firstNameHtml.setStyleName("mandatoryhtmlpanelinprofiledetailpage");
		titleOfYourPagePanel.add(firstNameHtml);
		titleOfYourPageTextBox = new TextBox();

		titleOfYourPageTextBox.setName("titleOfYourPageTextBox");

		titleOfYourPageTextBox.addStyleName("styletextbox");
		titleOfYourPageTextBox.setMaxLength(30);
		titleOfYourPagePanel.add(titleOfYourPageTextBox);
		titleOfYourPageErrorLabel = new Label();
		titleOfYourPageErrorLabel.setVisible(false);
		patientDetailPanel.add(titleOfYourPageErrorLabel);

		donationNeededPanel = new HorizontalPanel();
		donationNeededPanel.addStyleName("stylehorizontalpanel");
		patientDetailPanel.add(donationNeededPanel);
		donationNeededLabel = new Label("Donation Needed");
		donationNeededLabel.addStyleName("fieldlabel");
		HTML lastNameHtml = new HTML(donationNeededLabel + "" + html);
		lastNameHtml.setStyleName("mandatoryhtmlpanelinprofiledetailpage");
		donationNeededPanel.add(lastNameHtml);
		donationNeededTextBox = new TextBox();
		donationNeededTextBox.setName("donationNeededTextBox");
		donationNeededTextBox.addStyleName("styletextbox");
		donationNeededTextBox.setMaxLength(20);
		donationNeededPanel.add(donationNeededTextBox);
		donationNeededErrorLabel = new Label();
		donationNeededErrorLabel.setVisible(false);
		patientDetailPanel.add(donationNeededErrorLabel);
			
		
		reasonForRaisingFundsPanel = new HorizontalPanel();
		reasonForRaisingFundsPanel.addStyleName("stylehorizontalpanel");
		patientDetailPanel.add(reasonForRaisingFundsPanel);
		reasonForRaisingFundsLabel = new Label("Reasons for raising funds");
		reasonForRaisingFundsLabel.addStyleName("fieldlabel");
		HTML emailHtml = new HTML(reasonForRaisingFundsLabel + "" + html);
		emailHtml.setStyleName("mandatoryhtmlpanelinprofiledetailpage");
		reasonForRaisingFundsPanel.add(emailHtml);
		reasonForRaisingFundsTextBox = new TextBox();
		reasonForRaisingFundsTextBox.setMaxLength(40);
		reasonForRaisingFundsTextBox.setName("reasonForRaisingFundsTextBox");
		reasonForRaisingFundsTextBox.addStyleName("styletextbox");
		reasonForRaisingFundsPanel.add(reasonForRaisingFundsTextBox);
		reasonForRaisingFundsErrorLabel = new Label();
		reasonForRaisingFundsErrorLabel.setVisible(false);
		patientDetailPanel.add(reasonForRaisingFundsErrorLabel);
		
		
		profileSummaryPanel = new HorizontalPanel();
		profileSummaryPanel.addStyleName("stylehorizontalpanel");
		patientDetailPanel.add(profileSummaryPanel);
		profileSummaryLabel = new Label("Profile summary");
		profileSummaryLabel.addStyleName("fieldlabel");
		HTML passwordHtml = new HTML(profileSummaryLabel + "" + html);
		passwordHtml.setStyleName("mandatoryhtmlpanel");
		profileSummaryPanel.add(passwordHtml);
		profileSummaryTextArea = new TextArea();
		profileSummaryTextArea.getElement().setAttribute("maxlength", "70");
		profileSummaryTextArea.setName("profileSummaryTextArea");
		profileSummaryTextArea.addStyleName("styletextarea");
		profileSummaryPanel.add(profileSummaryTextArea);
		profileSummaryErrorLabel = new Label();
		profileSummaryErrorLabel.setVisible(false);
		patientDetailPanel.add(profileSummaryErrorLabel);
		
		endCollectingMoneyOnPanel = new HorizontalPanel();
		endCollectingMoneyOnPanel.addStyleName("stylehorizontalpanel");
		endCollectingMoneyOnLabel = new Label("End collecting money on");
		endCollectingMoneyOnLabel.addStyleName("fieldlabel");
		HTML dobHtml = new HTML(endCollectingMoneyOnLabel + "" + html);
		dobHtml.setStyleName("mandatoryhtmlpanelinprofiledetailpage");
		endCollectingMoneyOnPanel.add(dobHtml);
		patientDetailPanel.add(endCollectingMoneyOnPanel);
		dateTimeFormat = DateTimeFormat.getFormat("dd - MM - yyyy");
		defaultFormat = new DefaultFormat(dateTimeFormat);
		datePickerWithYearSelectorNew = new DatePickerWithYearSelectorNew();
		dateBox = new DateBox(datePickerWithYearSelectorNew, null,
				defaultFormat);

		dateBox.getTextBox().setName("dateBox");
		dateBox.getTextBox().setReadOnly(true);
		dateBox.addStyleName("styleendcollectingmoneybox");
		endCollectingMoneyOnPanel.add(dateBox);
		Image img = new Image("./images/calendar.png");
		img.addClickHandler(doBImageClickhandler);
		img.addStyleName("endcollectingmoneydateimage");
		endCollectingMoneyOnPanel.add(img);
		endCollectingMoneyOnErrorLabel = new Label();
		endCollectingMoneyOnErrorLabel.setVisible(false);
		patientDetailPanel.add(endCollectingMoneyOnErrorLabel);


		uploadYourProfilePicturePanel = new HorizontalPanel();
		// Create a new uploader panel and attach it to the document
	    defaultUploader = new MultiUploader();
	    
	    defaultUploader.addStyleName("uploadwidget");
	   // SingleUploader defaultUploader = new SingleUploader();
	    defaultUploader.avoidRepeatFiles(true);
	    
	    defaultUploader.setMaximumFiles(1);
	    defaultUploader.setMultipleSelection(false);
	    defaultUploader.setValidExtensions("jpeg","jpg","gif","png","bmp");
	    // Add a finish handler which will load the image once the upload finishes
	   defaultUploader.addOnFinishUploadHandler(onFinishUploaderHandler);
	    System.out.println("upload " +defaultUploader.getFileInput());
	    System.out.println("upload2 " +defaultUploader.getElement());
	    System.out.println("upload3 " +defaultUploader.getStatus());
	    //System.out.println("upload4 " +defaultUploader.get);

	    upload = new VerticalPanel();
	    uploadLabel = new Label("Upload your profile picture");
	    uploadLabel.addStyleName("uploadLabel");
	    upload.add(uploadLabel);
	    upload.add(defaultUploader);
	  //  uploadYourProfilePicturePanel.add(panelImages);
	    uploadYourProfilePicturePanel.add(upload);
	    uploadNoteLabel = new Label("Note: (only jpeg,jpg,gif,png,bmp)");
	    uploadNoteLabel.addStyleName("uploadnotelabel");
	    uploadYourProfilePicturePanel.add(uploadNoteLabel);
		patientDetailPanel.add(uploadYourProfilePicturePanel);

		nextButtonPanel = new HorizontalPanel();
		nextButtonPanel.addStyleName("stylehorizontalpanel");
		nextButton = new Button("next");

		nextButton.addStyleName("nextButton");
		nextButtonPanel.add(nextButton);
		patientDetailPanel.add(nextButtonPanel);

		return formPanel;

	}

	/**
	 * @return firstNameTextBox Getter HasValue for firstName
	 */
	public HasValue<String> getTitleOfYourPageTextBox() {
		return titleOfYourPageTextBox;
	}

	/**
	 * @return emailTextBox Getter HasValue for
	 */
	public HasValue<String> getDonationNeededTextBox() {
		return donationNeededTextBox;
	}

	/**
	 * @return emailTextBox Getter HasValue for
	 */
	public HasValue<String> getReasonForRaisingFundsTextBox() {
		return reasonForRaisingFundsTextBox;
	}

	/**
	 * @return passwordTextBox Getter HasValue for
	 */
	public HasValue<String> getProfileSummaryTextArea() {
		return profileSummaryTextArea;
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
	public HasClickHandlers getnextButton() {
		return nextButton;
	}

	public DateBox getDob() {
		return dateBox;
	}

	public void setStatus(String id, boolean isNull, boolean isInValid) {

		if (id.equals("titleOfYourPageTextBox")) {

			if (isNull) {
				titleOfYourPageTextBox.addStyleName("invalid");
				titleOfYourPageErrorLabel.setVisible(true);
				titleOfYourPageErrorLabel.setText("You can't leave this empty ");
				titleOfYourPageErrorLabel.addStyleName("responselabelerrorforProfiledetailpage");

			} else if (isInValid) {
				titleOfYourPageTextBox.addStyleName("invalid");
				titleOfYourPageErrorLabel.setVisible(true);
				titleOfYourPageErrorLabel
						.setText(" Please enter the Title in a correct format ");
				titleOfYourPageErrorLabel.addStyleName("responselabelerrorforProfiledetailpage");
			} else {

				titleOfYourPageTextBox.removeStyleName("invalid");
				titleOfYourPageErrorLabel.setVisible(false);
			}

		} else if (id.equalsIgnoreCase("donationNeededTextBox")) {

			if (isNull) {

				donationNeededTextBox.addStyleName("invalid");
				donationNeededErrorLabel.setVisible(true);
				donationNeededErrorLabel.setText("You can't leave this empty ");
				donationNeededErrorLabel.addStyleName("responselabelerrorforProfiledetailpage");

			} else if (isInValid) {

				donationNeededTextBox.addStyleName("invalid");
				donationNeededErrorLabel.setVisible(true);
				donationNeededErrorLabel
						.setText(" Please enter the donation amount in a correct format ");
				donationNeededErrorLabel.addStyleName("responselabelerrorforProfiledetailpage");

			} else {
				donationNeededTextBox.removeStyleName("invalid");
				donationNeededErrorLabel.setVisible(false);

			}

		} else if (id.equalsIgnoreCase("reasonForRaisingFundsTextBox")) {

			if (isNull) {

				reasonForRaisingFundsTextBox.addStyleName("invalid");
				reasonForRaisingFundsErrorLabel.setVisible(true);
				reasonForRaisingFundsErrorLabel.setText("You can't leave this empty ");
				reasonForRaisingFundsErrorLabel.addStyleName("responselabelerrorforProfiledetailpage");
			} else if (isInValid) {
				reasonForRaisingFundsTextBox.addStyleName("invalid");
				reasonForRaisingFundsErrorLabel.setVisible(true);
				reasonForRaisingFundsErrorLabel
						.setText(" Please enter the Reason in a correct format ");
				reasonForRaisingFundsErrorLabel.addStyleName("responselabelerrorforProfiledetailpage");

			} else {

				reasonForRaisingFundsTextBox.removeStyleName("invalid");
				reasonForRaisingFundsErrorLabel.setVisible(false);
			}
		} else if (id.equalsIgnoreCase("profileSummaryTextArea")) {

			if (isNull) {

				profileSummaryTextArea.addStyleName("invalid");
				profileSummaryErrorLabel.setVisible(true);
				profileSummaryErrorLabel.setText("You can't leave this empty ");
				profileSummaryErrorLabel.addStyleName("responselabelerrorforProfiledetailpage");
			} /*else if (isInValid) {
				profileSummaryTextArea.addStyleName("invalid");
				profileSummaryErrorLabel.setVisible(true);
				profileSummaryErrorLabel
						.setText(" Please enter a valid e-mail address ");
				profileSummaryErrorLabel.addStyleName("responselabelerrorforProfiledetailpage");

			}*/ else {

				profileSummaryTextArea.removeStyleName("invalid");
				profileSummaryErrorLabel.setVisible(false);
			}
		} else if (id.equalsIgnoreCase("dateBox")) {

			if (isNull) {
				dateBox.addStyleName("invalid");
				endCollectingMoneyOnErrorLabel.setVisible(true);
				endCollectingMoneyOnErrorLabel.setText("Date should be selected");
				endCollectingMoneyOnErrorLabel.addStyleName("responselabelerrorforProfiledetailpage");

			} else if (isInValid) {

				dateBox.addStyleName("invalid");
				endCollectingMoneyOnErrorLabel.setVisible(true);
				endCollectingMoneyOnErrorLabel.setText("Past date cannot be selected");
				endCollectingMoneyOnErrorLabel.addStyleName("responselabelerrorforProfiledetailpage");

			} else {

				dateBox.removeStyleName("invalid");
				endCollectingMoneyOnErrorLabel.setVisible(false);
			}

		} 
	}

	public MultiUploader getuploadOfSecondScreen() {
		return defaultUploader;
		
	//	String defaultUploader;
		// TODO Auto-generated method stub
		
	}

	
}