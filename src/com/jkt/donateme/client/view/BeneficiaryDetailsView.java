package com.jkt.donateme.client.view;

import gwtupload.client.IUploadStatus.Status;
import gwtupload.client.IUploader;
import gwtupload.client.IUploader.UploadedInfo;
import gwtupload.client.MultiUploader;
import gwtupload.client.PreloadedImage;
import gwtupload.client.PreloadedImage.OnLoadPreloadedImageHandler;

import java.util.Date;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.jkt.donateme.client.presenter.BeneficiaryDetailsPresenter.Display;

public class BeneficiaryDetailsView extends Composite implements Display {

	private FormPanel formPanel;
	private VerticalPanel beneficiaryDetailpanel;
	// beneficiary details part
	private VerticalPanel relationToBeneficiaryPanel;
	private VerticalPanel firstNamePanel;
	private VerticalPanel lastNamePanel;
	private VerticalPanel addressLine1Panel;
	private VerticalPanel addressLine2Panel;
	private VerticalPanel emailPanel;
	private HorizontalPanel addressPanel;
	private HorizontalPanel contactPanel;
	private VerticalPanel cityPanel;
	private VerticalPanel statePanel;
	private VerticalPanel zipPanel;
	private VerticalPanel phoneNumberPanel;
	private HorizontalPanel captionPanel;
	private HorizontalPanel signCaptionPanel;
	private HorizontalPanel profileDetailCaptionPanel;
	private HorizontalPanel beneficiaryDetailCaptionPanel;
	private HorizontalPanel namePanel;
	private HorizontalPanel areaPanel;


	private Label relationToBeneficiaryLabel;
	private Label firstNameLabel;
	private Label lastNameLabel;
	private Label emailLabel;
	private Label cityLabel;
	private Label stateLabel;
	private Label zipLabel;
	private Label phoneNumberLabel;
	private Label addressLine1Label;
	private Label addressLine2Label;
	private Label firstNameErrorLabel;
	private Label lastNameErrorLabel;
	private Label emailErrorLabel;
	private Label addressLine1ErrorLabel;
	private Label addressLine2ErrorLabel;
	private Label cityErrorLabel;
	private Label stateErrorLabel;
	private Label zipErrorLabel;
	private Label phoneNumberErrorLabel;
	private Label realtionToBeneficiaryErrorLabel;
	private Label signupCaptionLabel;
	private Label profileDetailCaptionLabel;
	private Label beneficiaryDetailCaptionLabel;

	private ListBox relationToBeneficiaryListBox;
	private TextBox lastNameTextBox;
	private TextBox emailTextBox;
	private TextBox firstNameTextBox;
	private TextBox cityTextBox;
	private TextBox zipTextBox;
	private TextBox phoneNumberTextBox;
	private ListBox stateTextBox;
	private TextBox addressLine1TextBox;
	private TextBox addressLine2TextBox;

	// payment mode part

	private VerticalPanel paymentModePanel;
	private HorizontalPanel radioButtonPanel;
	private Label paymentModeLabel;
	private Label recepientLabel;
	private Label accountNumberLabel;
	private Label bankNameLabel;
	private Label holderNameLabel;
	private Label ifscLabel;
	private Label cityLabelForPayment;
	private Label stateLabelForPayment;

	private Label chequeErrorLabel;
	private Label accNoErrorLabel;
	private Label bankNameErrorLabel;
	private Label holderNameErrorLabel;
	private Label ifscErrorLabel;
	private Label cityErrorLabelForPayment;
	private Label stateErrorLabelForPayment;
	private Label paymentErrorLabel;

	private RadioButton chequeButton;
	private RadioButton wireTransferButton;
	private VerticalPanel chequePanel;
	private TextBox chequeTextBox;
	private TextBox accNoTextBox;
	private TextBox bankNameTextBox;
	private TextBox holderNameTextBox;
	private TextBox ifscTextBox;
	private TextBox cityTextBoxForPayment;
	private TextBox stateTextBoxForPayment;
	private VerticalPanel wireTarnsferPanel;
	private HorizontalPanel wireFirstRowPanel;
	private HorizontalPanel wireSecondRowPanel;
	private HorizontalPanel wireThirdRowPanel;
	private VerticalPanel acccountNoPanel;
	private VerticalPanel holderNamePanel;
	private VerticalPanel cityPanelForPayment;
	private VerticalPanel bankNamePanel;
	private VerticalPanel ifscPanel;
	private VerticalPanel statePanelForPayment;

	MultiUploader defaultUploader = new MultiUploader();

	private VerticalPanel upload;
	private VerticalPanel doctorHospitalVerticalPanel;
	private VerticalPanel doctorNameVerticalPanel;
	private VerticalPanel diseaseNameVerticalPanel;

	private HorizontalPanel medicalDetailsPanel;
	private HorizontalPanel doctorsPanel;
	private HorizontalPanel diseaseNameHorizontalPanel;
	private HorizontalPanel ckeckboxPanel;

	private HorizontalPanel uploadYourProfilePicturePanel;
	private HorizontalPanel nextButtonPanel;

	private Label MedicalDetailsLabel;
	private Label doctorNameLabel;
	private Label hospitalNameLabel;
	private Label diseaseNameLabel;

	private Label uploadLabel;

	private Label doctorNameErrorLabel;
	private Label diseaseNameErrorLabel;
	private Label hospitalNameErrorLabel;
	private Label checkUploaderrorLabel;

	private TextBox doctorNameTextBox;
	private TextBox hospitalNameTextBox;
	private TextBox diseaseNameTextBox;

	private Button nextButton;
	private Button secondButton;

	public UploadedInfo info;
	// A panel where the thumbnails of uploaded images will be shown
	private FlowPanel panelImages = new FlowPanel();

	Date date = new Date();

	/**
	 * Constructor for the SignUp View That gets the FormPanel.
	 */
	public BeneficiaryDetailsView() {

		getBeneficiaryDetailView();

	}

	// Load the image in the document and in the case of success attach it to
	// the viewer
	private IUploader.OnFinishUploaderHandler onFinishUploaderHandler = new IUploader.OnFinishUploaderHandler() {
		@SuppressWarnings("deprecation")
		public void onFinish(IUploader uploader) {
			if (uploader.getStatus() == Status.SUCCESS) {
				checkUploaderrorLabel.removeStyleName("invalid");
				checkUploaderrorLabel.setVisible(false);
				new PreloadedImage(uploader.fileUrl(), showImage);

				// The server sends useful information to the client by default
				info = uploader.getServerInfo();
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

	public UploadedInfo getUploadInfo() {
		return info;
	}

	public FormPanel getBeneficiaryDetailView() {

		HTML html = new HTML("*");
		html.setStyleName("htmlstyle");
		formPanel = new FormPanel();
		formPanel.addStyleName("form");

		beneficiaryDetailpanel = new VerticalPanel();
		beneficiaryDetailpanel.addStyleName("signUpPanel");
		formPanel.add(beneficiaryDetailpanel);
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
		Image beneficiaryDetailImg = new Image("./images/3red.png");
		beneficiaryDetailImg.addStyleName("captionimage");
		beneficiaryDetailCaptionPanel.add(beneficiaryDetailImg);
		beneficiaryDetailCaptionPanel.add(beneficiaryDetailCaptionLabel);
		captionPanel.add(beneficiaryDetailCaptionPanel);
		beneficiaryDetailpanel.add(captionPanel);

		// Beneficiary details part
		HTML htmlforrelation = new HTML("*");
		htmlforrelation.setStyleName("relationhtmlstyle");
		relationToBeneficiaryPanel = new VerticalPanel();
		relationToBeneficiaryPanel.addStyleName("stylehorizontalpanel");
		beneficiaryDetailpanel.add(relationToBeneficiaryPanel);
		relationToBeneficiaryLabel = new Label(
				"What is your relation to Beneficiary");
		relationToBeneficiaryLabel.addStyleName("relationfieldlabel");
		HTML relationToBeneficiaryHtml = new HTML(relationToBeneficiaryLabel
				+ "" + htmlforrelation);
		relationToBeneficiaryHtml.setStyleName("mandatoryhtmlpanelForrelation");
		relationToBeneficiaryPanel.add(relationToBeneficiaryHtml);
		relationToBeneficiaryListBox = new ListBox();

		relationToBeneficiaryListBox.setName("relationToBeneficiary");
		relationToBeneficiaryListBox.addStyleName("styletextbox");
		//relationToBeneficiaryListBox.addItem("--Select Relation--");
		relationToBeneficiaryListBox.addItem("Self");

		relationToBeneficiaryListBox.addItem("Friend");
		relationToBeneficiaryListBox.addItem("Co-Worker");
		relationToBeneficiaryListBox.addItem("Family");
		relationToBeneficiaryListBox.addItem("Spouse");
		relationToBeneficiaryListBox.addItem("Caregiver");
		relationToBeneficiaryListBox.addItem("Random do-good");

		relationToBeneficiaryListBox.addStyleName("stylelistbox");
		relationToBeneficiaryPanel.add(relationToBeneficiaryListBox);
		relationToBeneficiaryLabel.setVisible(false);
		/*realtionToBeneficiaryErrorLabel = new Label();
		realtionToBeneficiaryErrorLabel.setVisible(false);
		relationToBeneficiaryPanel.add(realtionToBeneficiaryErrorLabel);*/

		firstNamePanel = new VerticalPanel();
		firstNameLabel = new Label("First Name");
		firstNameLabel.addStyleName("fieldlabel");
		HTML firstNameHtml = new HTML(firstNameLabel + "" + html);
		firstNameHtml.setStyleName("mandatoryhtmlpanel");
		firstNamePanel.add(firstNameHtml);
		firstNameTextBox = new TextBox();
		firstNameTextBox.addStyleName("toppage");
		firstNameTextBox.setName("firstNameTextBox");

		firstNameTextBox.setMaxLength(40);
		firstNamePanel.add(firstNameTextBox);
		firstNameErrorLabel = new Label();
		firstNameErrorLabel.setVisible(false);
		firstNamePanel.add(firstNameErrorLabel);
		
		lastNamePanel = new VerticalPanel();
		lastNameLabel = new Label("Last Name");
		lastNameLabel.addStyleName("fieldlabel");
		HTML lastNameHtml = new HTML(lastNameLabel + "" + html);
		lastNameHtml.setStyleName("mandatoryhtmlpanel");
		lastNamePanel.add(lastNameHtml);
		lastNameTextBox = new TextBox();
		lastNameTextBox.addStyleName("toppage");
		lastNameTextBox.setName("lastNameTextBox");
		lastNameTextBox.setMaxLength(40);
		lastNamePanel.add(lastNameTextBox);
		lastNameErrorLabel = new Label();
		lastNameErrorLabel.setVisible(false);
		lastNamePanel.add(lastNameErrorLabel);

		namePanel = new HorizontalPanel();
		namePanel.addStyleName("stylehorizontalpanel");
		namePanel.add(firstNamePanel);
		namePanel.add(lastNamePanel);
		namePanel.setVisible(false);
		beneficiaryDetailpanel.add(namePanel);

		addressLine1Panel = new VerticalPanel();
		addressLine1Label = new Label("Address Line1");
		addressLine1Label.addStyleName("fieldlabel");
		HTML addressLine1Html = new HTML(addressLine1Label + "" + html);
		addressLine1Html.setStyleName("mandatoryhtmlpanel");
		addressLine1Panel.add(addressLine1Html);
		addressLine1TextBox = new TextBox();
		addressLine1TextBox.addStyleName("toppage");
		addressLine1TextBox.setName("addressLine1");

		addressLine1TextBox.setMaxLength(70);
		addressLine1Panel.add(addressLine1TextBox);
		addressLine1ErrorLabel = new Label();
		addressLine1ErrorLabel.setVisible(false);
		addressLine1Panel.add(addressLine1ErrorLabel);

		addressLine2Panel = new VerticalPanel();
		addressLine2Label = new Label("Address Line2");
		addressLine2Label.addStyleName("fieldlabel");
		HTML addressLine2Html = new HTML(addressLine2Label + "");
		addressLine2Html.setStyleName("mandatoryhtmlpanel");
		addressLine2Panel.add(addressLine2Html);
		addressLine2TextBox = new TextBox();
		addressLine2TextBox.addStyleName("toppage");
		addressLine2TextBox.setName("addressLine2");
		addressLine2TextBox.setMaxLength(70);
		addressLine2Panel.add(addressLine2TextBox);
		addressLine2ErrorLabel = new Label();
		addressLine2ErrorLabel.setVisible(false);
		addressLine2Panel.add(addressLine2ErrorLabel);

		HorizontalPanel addressPanel = new HorizontalPanel();
		addressPanel.addStyleName("stylehorizontalpanel");
		addressPanel.add(addressLine1Panel);
		addressPanel.add(addressLine2Panel);
		beneficiaryDetailpanel.add(addressPanel);

		cityPanel = new VerticalPanel();
		cityLabel = new Label("City");
		cityLabel.addStyleName("fieldlabel");
		HTML cityHtml = new HTML(cityLabel + "" + html);
		cityHtml.setStyleName("mandatoryhtmlpanel");
		cityPanel.add(cityHtml);
		cityTextBox = new TextBox();
		cityTextBox.addStyleName("toppageForArea");
		cityTextBox.setName("city");
		cityTextBox.setMaxLength(40);
		cityPanel.add(cityTextBox);
		cityErrorLabel = new Label();
		cityErrorLabel.setVisible(false);
		cityPanel.add(cityErrorLabel);

		statePanel = new VerticalPanel();
		stateLabel = new Label("State");
		stateLabel.addStyleName("fieldlabel");
		HTML stateHtml = new HTML(stateLabel + "" + html);
		stateHtml.setStyleName("mandatoryhtmlpanel");
		statePanel.add(stateHtml);
		stateTextBox = new ListBox();
		stateTextBox.addStyleName("toppageForArea");
		stateTextBox.setName("state");
		stateTextBox.addItem("--Select State-- ");
		stateTextBox.addItem("Andaman and Nicobar Islands ");
		stateTextBox.addItem("Andhra Pradesh ");
		stateTextBox.addItem("Arunachal Pradesh ");
		stateTextBox.addItem("Assam ");
		stateTextBox.addItem("Bihar ");
		stateTextBox.addItem("Chandigarh  ");
		stateTextBox.addItem("Chhattisgarh ");
		stateTextBox.addItem("Dadra and Nagar Haveli ");
		stateTextBox.addItem("Daman and Diu ");
		stateTextBox.addItem("Delhi ");
		stateTextBox.addItem("Goa ");
		stateTextBox.addItem("Gujarat ");
		stateTextBox.addItem("Haryana ");
		stateTextBox.addItem("Himachal Pradesh ");
		stateTextBox.addItem("Jammu and Kashmir ");
		stateTextBox.addItem("Jharkhand ");
		stateTextBox.addItem("Karnataka ");
		stateTextBox.addItem("Kerala ");
		stateTextBox.addItem("Lakshadweep  ");
		stateTextBox.addItem("Madhya Pradesh ");
		stateTextBox.addItem("Maharashtra");
		stateTextBox.addItem("Manipur ");
		stateTextBox.addItem("Meghalaya ");
		stateTextBox.addItem("Mizoram ");
		stateTextBox.addItem("Nagaland");
		stateTextBox.addItem("Orissa ");
		stateTextBox.addItem("Puducherry  ");
		stateTextBox.addItem("Punjab ");
		stateTextBox.addItem("Rajasthan ");
		stateTextBox.addItem("Sikkim ");
		stateTextBox.addItem("Tamil Nadu ");
		stateTextBox.addItem("Tripura ");
		stateTextBox.addItem("Uttar Pradesh");
		stateTextBox.addItem("Uttarakhand");
		stateTextBox.addItem("West Bengal");
		statePanel.add(stateTextBox);
		stateTextBox.addStyleName("stylelistbox");
		stateErrorLabel = new Label();
		stateErrorLabel.setVisible(false);
		statePanel.add(stateErrorLabel);

		zipPanel = new VerticalPanel();
		zipLabel = new Label("Zip");
		zipLabel.addStyleName("fieldlabel");
		HTML zipHtml = new HTML(zipLabel + "" + html);
		zipHtml.setStyleName("mandatoryhtmlpanel");
		zipPanel.add(zipHtml);
		zipTextBox = new TextBox();
		zipTextBox.addStyleName("toppageForArea");
		zipTextBox.setName("zip");
		zipTextBox.setMaxLength(8);
		zipPanel.add(zipTextBox);
		zipErrorLabel = new Label();
		zipErrorLabel.setVisible(false);
		zipPanel.add(zipErrorLabel);

		areaPanel = new HorizontalPanel();
		areaPanel.addStyleName("stylehorizontalpanel");
		areaPanel.add(cityPanel);
		areaPanel.add(statePanel);
		areaPanel.add(zipPanel);
		beneficiaryDetailpanel.add(areaPanel);

		emailPanel = new VerticalPanel();
		emailLabel = new Label("Email Id");
		emailLabel.addStyleName("fieldlabel");
		HTML emailHtml = new HTML(emailLabel + "" + html);
		emailHtml.setStyleName("mandatoryhtmlpanel");
		emailPanel.add(emailHtml);
		emailTextBox = new TextBox();
		emailTextBox.addStyleName("toppage");
		emailTextBox.setName("emailID");

		emailTextBox.setMaxLength(50);
		emailPanel.add(emailTextBox);
		emailErrorLabel = new Label();
		emailErrorLabel.setVisible(false);
		emailPanel.add(emailErrorLabel);
		emailPanel.setVisible(false);

		phoneNumberPanel = new VerticalPanel();
		phoneNumberLabel = new Label("Phone Number");
		phoneNumberLabel.addStyleName("fieldlabel");
		HTML phoneNumberHtml = new HTML(phoneNumberLabel + "" + html);
		phoneNumberHtml.setStyleName("mandatoryhtmlpanel");
		phoneNumberPanel.add(phoneNumberHtml);
		phoneNumberTextBox = new TextBox();
		phoneNumberTextBox.addStyleName("toppage");
		phoneNumberTextBox.setName("phoneNumber");
		phoneNumberTextBox.setMaxLength(10);
		phoneNumberPanel.add(phoneNumberTextBox);
		phoneNumberErrorLabel = new Label();
		phoneNumberErrorLabel.setVisible(false);

		phoneNumberPanel.add(phoneNumberErrorLabel);
		HorizontalPanel contactPanel = new HorizontalPanel();
		contactPanel.addStyleName("stylehorizontalpanel");
		contactPanel.add(emailPanel);
		contactPanel.add(phoneNumberPanel);
		beneficiaryDetailpanel.add(contactPanel);
		// payment mode
		paymentModePanel = new VerticalPanel();
		paymentModePanel.addStyleName("stylehorizontalpanel");
		paymentModeLabel = new Label(
				"How would you like to receive the donation");
		paymentModeLabel.addStyleName("paymentModeLabel");
		paymentModePanel.add(paymentModeLabel);
		radioButtonPanel = new HorizontalPanel();
		radioButtonPanel.addStyleName("beneficiaryradiopanel");
		chequeButton = new RadioButton("paymentMode", " Cheque");
		chequeButton.setName("paymentMode");
		wireTransferButton = new RadioButton("paymentMode", " Wire Transfer");
		wireTransferButton.setName("paymentMode");
		radioButtonPanel.add(chequeButton);
		radioButtonPanel.add(wireTransferButton);
		paymentModePanel.add(radioButtonPanel);
		paymentErrorLabel = new Label();
		paymentErrorLabel.setVisible(false);
		paymentModePanel.add(paymentErrorLabel);

		beneficiaryDetailpanel.add(paymentModePanel);

		chequePanel = new VerticalPanel();
		chequePanel.addStyleName("stylehorizontalpanel");
		recepientLabel = new Label("Enter the name of recepient");
		recepientLabel.addStyleName("fieldlabel");
		HTML recepientHtml = new HTML(recepientLabel + "" + html);
		chequePanel.add(recepientHtml);

		chequeTextBox = new TextBox();
		chequeTextBox.setName("chequeTextBox");
		chequeTextBox.addStyleName("paymenttextbox");
		chequePanel.add(chequeTextBox);
		chequeErrorLabel = new Label();
		chequeErrorLabel.setVisible(false);
		chequePanel.add(chequeErrorLabel);

		beneficiaryDetailpanel.add(chequePanel);
		chequePanel.setVisible(false);

		wireTarnsferPanel = new VerticalPanel();
		// wireTarnsferPanel.addStyleName("stylehorizontalpanel");
		wireFirstRowPanel = new HorizontalPanel();
		wireFirstRowPanel.addStyleName("stylehorizontalpanel");
		acccountNoPanel = new VerticalPanel();
		// leftPanel1.addStyleName("left1panel");
		accountNumberLabel = new Label("Account Number");
		accountNumberLabel.addStyleName("fieldlabel");
		HTML accountNumberHtml = new HTML(accountNumberLabel + "" + html);
		acccountNoPanel.add(accountNumberHtml);
		accNoTextBox = new TextBox();
		accNoTextBox.addStyleName("paymenttextbox");
		accNoTextBox.setName("accNoTextBox");
		accNoTextBox.setMaxLength(16);
		acccountNoPanel.add(accNoTextBox);
		accNoErrorLabel = new Label();
		accNoErrorLabel.setVisible(false);
		acccountNoPanel.add(accNoErrorLabel);

		bankNamePanel = new VerticalPanel();
		bankNameLabel = new Label("Enter the bank name");
		bankNameLabel.addStyleName("fieldlabel");
		HTML bankNameHtml = new HTML(bankNameLabel + "" + html);
		bankNamePanel.add(bankNameHtml);
		bankNameTextBox = new TextBox();
		bankNameTextBox.addStyleName("paymenttextbox");
		bankNameTextBox.setName("bankNameTextBox");
		bankNamePanel.add(bankNameTextBox);
		bankNameErrorLabel = new Label();
		bankNameErrorLabel.setVisible(false);
		bankNamePanel.add(bankNameErrorLabel);

		wireFirstRowPanel.add(acccountNoPanel);
		wireFirstRowPanel.add(bankNamePanel);
		wireTarnsferPanel.add(wireFirstRowPanel);

		wireSecondRowPanel = new HorizontalPanel();
		wireSecondRowPanel.addStyleName("stylehorizontalpanel");
		holderNamePanel = new VerticalPanel();
		holderNameLabel = new Label("Enter the account holder's name");
		holderNameLabel.addStyleName("fieldlabel");
		HTML accountholderHtml = new HTML(holderNameLabel + "" + html);
		holderNamePanel.add(accountholderHtml);
		holderNameTextBox = new TextBox();
		holderNameTextBox.addStyleName("paymenttextbox");
		holderNameTextBox.setName("holderNameTextBox");
		holderNamePanel.add(holderNameTextBox);
		holderNameErrorLabel = new Label();
		holderNameErrorLabel.setVisible(false);
		holderNamePanel.add(holderNameErrorLabel);

		ifscPanel = new VerticalPanel();
		ifscLabel = new Label("Enter branch or IFSC code");
		ifscLabel.addStyleName("fieldlabel");
		HTML ifscHtml = new HTML(ifscLabel + "" + html);
		ifscPanel.add(ifscHtml);
		ifscTextBox = new TextBox();
		ifscTextBox.setMaxLength(11);
		ifscTextBox.addStyleName("paymenttextbox");
		ifscTextBox.setName("ifscTextBox");
		ifscPanel.add(ifscTextBox);
		ifscErrorLabel = new Label();
		ifscErrorLabel.setVisible(false);
		ifscPanel.add(ifscErrorLabel);

		wireSecondRowPanel.add(holderNamePanel);
		wireSecondRowPanel.add(ifscPanel);
		wireTarnsferPanel.add(wireSecondRowPanel);

		wireThirdRowPanel = new HorizontalPanel();
		wireThirdRowPanel.addStyleName("stylehorizontalpanel");
		cityPanelForPayment = new VerticalPanel();
		cityLabelForPayment = new Label("City");
		cityLabelForPayment.addStyleName("fieldlabel");
		HTML cityHtmlForPayment = new HTML(cityLabelForPayment + "" + html);
		cityPanelForPayment.add(cityHtmlForPayment);
		cityTextBoxForPayment = new TextBox();
		cityTextBoxForPayment.addStyleName("paymenttextbox");
		cityTextBoxForPayment.setName("cityTextBox");
		cityPanelForPayment.add(cityTextBoxForPayment);

		cityErrorLabelForPayment = new Label();
		cityErrorLabelForPayment.setVisible(false);
		cityPanelForPayment.add(cityErrorLabelForPayment);

		statePanelForPayment = new VerticalPanel();
		stateLabelForPayment = new Label("State");
		stateLabelForPayment.addStyleName("fieldlabel");
		HTML stateHtmlForPayment = new HTML(stateLabelForPayment + "" + html);
		statePanelForPayment.add(stateHtmlForPayment);
		stateTextBoxForPayment = new TextBox();
		stateTextBoxForPayment.addStyleName("paymenttextbox");
		stateTextBoxForPayment.setName("stateTextBox");
		statePanelForPayment.add(stateTextBoxForPayment);
		stateErrorLabelForPayment = new Label();
		stateErrorLabelForPayment.setVisible(false);
		statePanelForPayment.add(stateErrorLabelForPayment);

		wireThirdRowPanel.add(cityPanelForPayment);
		wireThirdRowPanel.add(statePanelForPayment);
		wireTarnsferPanel.add(wireThirdRowPanel);

		beneficiaryDetailpanel.add(wireTarnsferPanel);
		wireTarnsferPanel.setVisible(false);

		// medical details

		medicalDetailsPanel = new HorizontalPanel();
		medicalDetailsPanel.addStyleName("stylehorizontalpanel");
		beneficiaryDetailpanel.add(medicalDetailsPanel);
		MedicalDetailsLabel = new Label("Medical Details");
		MedicalDetailsLabel.addStyleName("feildmedicallabel");
		medicalDetailsPanel.add(MedicalDetailsLabel);

		// doctor panel, label,doctors textbox
		doctorsPanel = new HorizontalPanel();
		doctorsPanel.addStyleName("stylehorizontalpanel");
		beneficiaryDetailpanel.add(doctorsPanel);

		doctorNameLabel = new Label("Current Doctor's Name");
		doctorNameLabel.addStyleName("fieldlabel");
		HTML lastName2Html = new HTML(doctorNameLabel + "" + html);
		lastName2Html.setStyleName("mandatoryhtmlpanelinprofiledetailpage");

		doctorNameVerticalPanel = new VerticalPanel();
		doctorNameTextBox = new TextBox();
		doctorNameTextBox.setName("doctorNameTextBox");
		doctorNameTextBox.addStyleName("styledoctorstextbox");
		doctorNameTextBox.setMaxLength(80);
		doctorNameVerticalPanel.add(lastName2Html);
		doctorNameVerticalPanel.add(doctorNameTextBox);
		doctorsPanel.add(doctorNameVerticalPanel);
		doctorNameErrorLabel = new Label();
		doctorNameErrorLabel.setVisible(false);
		beneficiaryDetailpanel.add(doctorNameErrorLabel);

		// Hospital panel,label,hospital textbox
		doctorHospitalVerticalPanel = new VerticalPanel();

		hospitalNameLabel = new Label("Current Hospital Name");
		hospitalNameLabel.addStyleName("fieldlabel");
		HTML hospitalNameHtml = new HTML(hospitalNameLabel + "" + html);
		hospitalNameHtml.setStyleName("mandatoryhtmlpanelinprofiledetailpage");

		hospitalNameTextBox = new TextBox();
		hospitalNameTextBox.setName("hospitalNameTextBox");
		hospitalNameTextBox.addStyleName("styledoctorstextbox");
		hospitalNameTextBox.setMaxLength(80);
		doctorHospitalVerticalPanel.add(hospitalNameHtml);
		doctorHospitalVerticalPanel.add(hospitalNameTextBox);
		doctorsPanel.add(doctorHospitalVerticalPanel);

		hospitalNameErrorLabel = new Label();
		hospitalNameErrorLabel.setVisible(false);
		beneficiaryDetailpanel.add(hospitalNameErrorLabel);

		// disease name
		diseaseNameHorizontalPanel = new HorizontalPanel();
		diseaseNameHorizontalPanel.addStyleName("stylehorizontalpanel");
		beneficiaryDetailpanel.add(diseaseNameHorizontalPanel);

		diseaseNameVerticalPanel = new VerticalPanel();
		diseaseNameLabel = new Label("Disease Name");
		diseaseNameLabel.addStyleName("fieldlabel");
		HTML emai2lHtml = new HTML(diseaseNameLabel + "" + html);
		emai2lHtml.setStyleName("mandatoryhtmlpanelinprofiledetailpage");
		diseaseNameVerticalPanel.add(emai2lHtml);

		diseaseNameTextBox = new TextBox();
		diseaseNameTextBox.setMaxLength(80);
		diseaseNameTextBox.setName("diseaseNameTextBox");
		diseaseNameTextBox.addStyleName("styledoctorstextbox");
		diseaseNameVerticalPanel.add(diseaseNameTextBox);
		diseaseNameHorizontalPanel.add(diseaseNameVerticalPanel);
		diseaseNameErrorLabel = new Label();
		diseaseNameErrorLabel.setVisible(false);
		beneficiaryDetailpanel.add(diseaseNameErrorLabel);

		// file Upload

		uploadYourProfilePicturePanel = new HorizontalPanel();
		// Create a new uploader panel and attach it to the document

		defaultUploader.addStyleName("uploadwidget");
		defaultUploader.setMultipleSelection(false);
		// Add a finish handler which will load the image once the upload
		// finishes
		defaultUploader.addOnFinishUploadHandler(onFinishUploaderHandler);

		// upload vertical panel
		upload = new VerticalPanel();
		uploadLabel = new Label("Upload your medical report");
		uploadLabel.addStyleName("uploadreportLabel");
		upload.add(uploadLabel);
		upload.add(defaultUploader);
		uploadYourProfilePicturePanel.add(upload);
		beneficiaryDetailpanel.add(uploadYourProfilePicturePanel);

		checkUploaderrorLabel = new Label();
		checkUploaderrorLabel.setVisible(false);
		upload.add(checkUploaderrorLabel);

		// checkBox panel
		ckeckboxPanel = new HorizontalPanel();
		ckeckboxPanel.addStyleName("checkboxstylepanel");
		CheckBox checkBox1 = new CheckBox(" I agree to the");
		checkBox1.setValue(false);
		ckeckboxPanel.add(checkBox1);
		// terms and conditions button
		Button button = new Button("terms and conditions");
		button.addStyleName("termsandconditionsButton");
		ckeckboxPanel.add(button);
		beneficiaryDetailpanel.add(ckeckboxPanel);

		nextButtonPanel = new HorizontalPanel();
		nextButton = new Button("Finish");
		nextButton.addStyleName("finishButton");

		secondButton = new Button("Back");
		secondButton.addStyleName("backButton");
		// add button
		nextButtonPanel.add(secondButton);
		beneficiaryDetailpanel.add(nextButtonPanel);
		nextButtonPanel.add(nextButton);
		beneficiaryDetailpanel.add(nextButtonPanel);
		return formPanel;

	}

	public void setMode(boolean cheque, boolean wireTransfer) {

		if (cheque) {
			wireTarnsferPanel.setVisible(false);
			chequePanel.setVisible(true);

		} else if (wireTransfer) {
			chequePanel.setVisible(false);
			wireTarnsferPanel.setVisible(true);

		} else {
			chequePanel.setVisible(false);
			wireTarnsferPanel.setVisible(false);

		}

	}

	public void reInitialisePayment(boolean cheque) {

		if (cheque) {

			chequeTextBox.setText(null);

		} else {
			accNoTextBox.setText(null);
			bankNameTextBox.setText(null);
			holderNameTextBox.setText(null);
			ifscTextBox.setText(null);
			cityTextBoxForPayment.setText(null);
			stateTextBoxForPayment.setText(null);

		}

	}

	/**
	 * @return emailTextBox Getter HasValue for
	 */
	public HasValue<String> getEmailTextBox() {
		return emailTextBox;
	}

	public void setStatus(String id, boolean isNull, boolean isInValid) {
		/*if (id.equals("relationToBeneficiary")) {

			if (relationToBeneficiaryListBox.isItemSelected(0)) {
				

				relationToBeneficiaryListBox.addStyleName("invalid");
				realtionToBeneficiaryErrorLabel.setVisible(true);
				realtionToBeneficiaryErrorLabel.setText("Select a relationship or Self");
				stateErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");

			} else if (isInValid) {
				stateTextBox.addStyleName("invalid");
				stateErrorLabel.setVisible(true);
				stateErrorLabel
						.setText(" Please enter the state in correct format ");
				stateErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");
			} else {

				relationToBeneficiaryListBox.removeStyleName("invalid");
				realtionToBeneficiaryErrorLabel.setVisible(false);
			}

		}
		else*/ if (id.equals("firstNameTextBox")) {

			if (isNull) {
				firstNameTextBox.addStyleName("invalid");
				firstNameErrorLabel.setVisible(true);
				firstNameErrorLabel.setText("You can't leave this empty ");
				firstNameErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");

			} else if (isInValid) {
				firstNameTextBox.addStyleName("invalid");
				firstNameErrorLabel.setVisible(true);
				firstNameErrorLabel
						.setText(" Please enter the first name in correct format ");
				firstNameErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");
			} else {

				firstNameTextBox.removeStyleName("invalid");
				firstNameErrorLabel.setVisible(false);
			}

		} else if (id.equalsIgnoreCase("lastNameTextBox")) {

			if (isNull) {

				lastNameTextBox.addStyleName("invalid");
				lastNameErrorLabel.setVisible(true);
				lastNameErrorLabel.setText("You can't leave this empty ");
				lastNameErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");

			} else if (isInValid) {

				lastNameTextBox.addStyleName("invalid");
				lastNameErrorLabel.setVisible(true);
				lastNameErrorLabel
						.setText(" Please enter the Last name in correct format ");
				lastNameErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");

			} else {
				lastNameTextBox.removeStyleName("invalid");
				lastNameErrorLabel.setVisible(false);

			}

		}
		if (id.equals("addressLine1")) {

			if (isNull) {
				addressLine1TextBox.addStyleName("invalid");
				addressLine1ErrorLabel.setVisible(true);
				addressLine1ErrorLabel.setText("You can't leave this empty ");
				addressLine1ErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");

			} else if (isInValid) {
				addressLine1TextBox.addStyleName("invalid");
				addressLine1ErrorLabel.setVisible(true);
				addressLine1ErrorLabel
						.setText(" Please enter the address Line 1 in correct format ");
				addressLine1ErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");
			} else {

				addressLine1TextBox.removeStyleName("invalid");
				addressLine1ErrorLabel.setVisible(false);
			}

		}

		if (id.equals("addressLine2")) {

			if (isNull) {
				addressLine2TextBox.addStyleName("invalid");
				addressLine2ErrorLabel.setVisible(true);
				addressLine2ErrorLabel.setText("You can't leave this empty ");
				addressLine2ErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");

			} else if (isInValid) {
				addressLine2TextBox.addStyleName("invalid");
				addressLine2ErrorLabel.setVisible(true);
				addressLine2ErrorLabel
						.setText(" Please enter the address line 2in correct format ");
				addressLine2ErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");
			} else {

				addressLine2TextBox.removeStyleName("invalid");
				addressLine2ErrorLabel.setVisible(false);
			}

		}

		if (id.equals("city")) {

			if (isNull) {
				cityTextBox.addStyleName("invalid");
				cityErrorLabel.setVisible(true);
				cityErrorLabel.setText("You can't leave this empty ");
				cityErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");

			} else if (isInValid) {
				cityTextBox.addStyleName("invalid");
				cityErrorLabel.setVisible(true);
				cityErrorLabel
						.setText(" Please enter the city in correct format ");
				cityErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");
			} else {

				cityTextBox.removeStyleName("invalid");
				cityErrorLabel.setVisible(false);
			}

		}

		if (id.equals("state")) {

			if (stateTextBox.isItemSelected(0)) {
				

				stateTextBox.addStyleName("invalid");
				stateErrorLabel.setVisible(true);
				stateErrorLabel.setText("Please select the state");
				stateErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");

			}/* else if (isInValid) {
				stateTextBox.addStyleName("invalid");
				stateErrorLabel.setVisible(true);
				stateErrorLabel
						.setText(" Please enter the state in correct format ");
				stateErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");
			} */else {

				stateTextBox.removeStyleName("invalid");
				stateErrorLabel.setVisible(false);
			}

		}

		if (id.equals("zip")) {

			if (isNull) {
				zipTextBox.addStyleName("invalid");
				zipErrorLabel.setVisible(true);
				zipErrorLabel.setText("You can't leave this empty ");
				zipErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");

			} else if (isInValid) {
				zipTextBox.addStyleName("invalid");
				zipErrorLabel.setVisible(true);
				zipErrorLabel
						.setText(" Please enter the zip in correct format ");
				zipErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");
			} else {

				zipTextBox.removeStyleName("invalid");
				zipErrorLabel.setVisible(false);
			}

		}

		else if (id.equalsIgnoreCase("emailID")) {

			if (isNull) {

				emailTextBox.addStyleName("invalid");
				emailErrorLabel.setVisible(true);
				emailErrorLabel.setText("You can't leave this empty ");
				emailErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");
			} else if (isInValid) {
				emailTextBox.addStyleName("invalid");
				emailErrorLabel.setVisible(true);
				emailErrorLabel
						.setText(" Please enter a valid e-mail address ");
				emailErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");

			} else {

				emailTextBox.removeStyleName("invalid");
				emailErrorLabel.setVisible(false);
			}
		}
		if (id.equals("phoneNumber")) {

			if (isNull) {
				phoneNumberTextBox.addStyleName("invalid");
				phoneNumberErrorLabel.setVisible(true);
				phoneNumberErrorLabel.setText("You can't leave this empty ");
				phoneNumberErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");

			} else if (isInValid) {
				phoneNumberTextBox.addStyleName("invalid");
				phoneNumberErrorLabel.setVisible(true);
				phoneNumberErrorLabel
						.setText(" Please enter the valid  phone Number.");
				phoneNumberErrorLabel
						.addStyleName("responselabelerrorforbeneficiarypage");
			} else {

				phoneNumberTextBox.removeStyleName("invalid");
				phoneNumberErrorLabel.setVisible(false);
			}

		} else if (id.equals("chequeTextBox")) {

			if (isNull) {
				chequeTextBox.addStyleName("invalid");
				chequeErrorLabel.setVisible(true);
				chequeErrorLabel.setText("You can't leave this empty ");
				chequeErrorLabel
						.addStyleName("responselabelerrorforbeneficiary");

			} else if (isInValid) {
				chequeTextBox.addStyleName("invalid");
				chequeErrorLabel.setVisible(true);
				chequeErrorLabel
						.setText(" Please enter the recepient's name in correct format ");
				chequeErrorLabel
						.addStyleName("responselabelerrorforbeneficiary");
			} else {

				chequeTextBox.removeStyleName("invalid");
				chequeErrorLabel.setVisible(false);
			}

		} else if (id.equalsIgnoreCase("accNoTextBox")) {

			if (isNull) {

				accNoTextBox.addStyleName("invalid");
				accNoErrorLabel.setVisible(true);
				accNoErrorLabel.setText("You can't leave this empty ");
				accNoErrorLabel
						.addStyleName("responselabelerrorforbeneficiary");

			} else if (isInValid) {

				accNoTextBox.addStyleName("invalid");
				accNoErrorLabel.setVisible(true);
				accNoErrorLabel
						.setText(" Please enter the account number correctly ");
				accNoErrorLabel
						.addStyleName("responselabelerrorforbeneficiary");

			} else {
				accNoTextBox.removeStyleName("invalid");
				accNoErrorLabel.setVisible(false);

			}

		} else if (id.equalsIgnoreCase("bankNameTextBox")) {

			if (isNull) {

				bankNameTextBox.addStyleName("invalid");
				bankNameErrorLabel.setVisible(true);
				bankNameErrorLabel.setText("You can't leave this empty ");
				bankNameErrorLabel
						.addStyleName("responselabelerrorforbeneficiary");

			} else if (isInValid) {

				bankNameTextBox.addStyleName("invalid");
				bankNameErrorLabel.setVisible(true);
				bankNameErrorLabel
						.setText(" Please enter the bank name in correct format ");
				bankNameErrorLabel
						.addStyleName("responselabelerrorforbeneficiary");

			} else {
				bankNameTextBox.removeStyleName("invalid");
				bankNameErrorLabel.setVisible(false);

			}

		} else if (id.equalsIgnoreCase("holderNameTextBox")) {

			if (isNull) {

				holderNameTextBox.addStyleName("invalid");
				holderNameErrorLabel.setVisible(true);
				holderNameErrorLabel.setText("You can't leave this empty ");
				holderNameErrorLabel
						.addStyleName("responselabelerrorforbeneficiary");

			} else if (isInValid) {

				holderNameTextBox.addStyleName("invalid");
				holderNameErrorLabel.setVisible(true);
				holderNameErrorLabel
						.setText(" Please enter the account holder's name in correct format");
				holderNameErrorLabel
						.addStyleName("responselabelerrorforbeneficiary");

			} else {
				holderNameTextBox.removeStyleName("invalid");
				holderNameErrorLabel.setVisible(false);

			}

		} else if (id.equalsIgnoreCase("ifscTextBox")) {

			if (isNull) {

				ifscTextBox.addStyleName("invalid");
				ifscErrorLabel.setVisible(true);
				ifscErrorLabel.setText("You can't leave this empty ");
				ifscErrorLabel.addStyleName("responselabelerrorforbeneficiary");

			} else if (isInValid) {

				ifscTextBox.addStyleName("invalid");
				ifscErrorLabel.setVisible(true);
				ifscErrorLabel
						.setText(" Please enter the IFSC code correct format ");
				ifscErrorLabel.addStyleName("responselabelerrorforbeneficiary");

			} else {
				ifscTextBox.removeStyleName("invalid");
				ifscErrorLabel.setVisible(false);

			}

		} else if (id.equalsIgnoreCase("cityTextBox")) {

			if (isNull) {

				cityTextBoxForPayment.addStyleName("invalid");
				cityErrorLabelForPayment.setVisible(true);
				cityErrorLabelForPayment.setText("You can't leave this empty ");
				cityErrorLabelForPayment
						.addStyleName("responselabelerrorforbeneficiary");

			} else if (isInValid) {

				cityTextBoxForPayment.addStyleName("invalid");
				cityErrorLabelForPayment.setVisible(true);
				cityErrorLabelForPayment
						.setText(" Please enter the city correctly ");
				cityErrorLabelForPayment
						.addStyleName("responselabelerrorforbeneficiary");

			} else {
				cityTextBoxForPayment.removeStyleName("invalid");
				cityErrorLabelForPayment.setVisible(false);

			}

		} else if (id.equalsIgnoreCase("stateTextBox")) {

			if (isNull) {

				stateTextBoxForPayment.addStyleName("invalid");
				stateErrorLabelForPayment.setVisible(true);
				stateErrorLabelForPayment
						.setText("You can't leave this empty ");
				stateErrorLabelForPayment
						.addStyleName("responselabelerrorforbeneficiary");

			} else if (isInValid) {

				stateTextBoxForPayment.addStyleName("invalid");
				stateErrorLabelForPayment.setVisible(true);
				stateErrorLabelForPayment
						.setText(" Please enter the state correctly ");
				stateErrorLabelForPayment
						.addStyleName("responselabelerrorforbeneficiary");

			} else {
				stateTextBoxForPayment.removeStyleName("invalid");
				stateErrorLabelForPayment.setVisible(false);

			}

		}

		else if (id.equalsIgnoreCase("doctorNameTextBox")) {

			if (isNull) {

				doctorNameTextBox.addStyleName("invalid");
				doctorNameErrorLabel.setVisible(true);
				doctorNameErrorLabel.setText("You can't leave this empty ");
				doctorNameErrorLabel.addStyleName("doctornameerrorlabel");

			} else if (isInValid) {

				doctorNameTextBox.addStyleName("invalid");
				doctorNameErrorLabel.setVisible(true);
				doctorNameErrorLabel
						.setText(" Please enter the doctor name in correct format ");
				doctorNameErrorLabel.addStyleName("doctornameerrorlabel");

			} else {
				doctorNameTextBox.removeStyleName("invalid");
				doctorNameErrorLabel.setVisible(false);

			}

		} else if (id.equalsIgnoreCase("diseaseNameTextBox")) {

			if (isNull) {

				diseaseNameTextBox.addStyleName("invalid");
				diseaseNameErrorLabel.setVisible(true);
				diseaseNameErrorLabel.setText("You can't leave this empty ");
				diseaseNameErrorLabel.addStyleName("doctornameerrorlabel");
			} else if (isInValid) {
				diseaseNameTextBox.addStyleName("invalid");
				diseaseNameErrorLabel.setVisible(true);
				diseaseNameErrorLabel
						.setText("Please enter the disease name in correct format");
				diseaseNameErrorLabel.addStyleName("doctornameerrorlabel");

			} else {

				diseaseNameTextBox.removeStyleName("invalid");
				diseaseNameErrorLabel.setVisible(false);
			}
		} else if (id.equalsIgnoreCase("hospitalNameTextBox")) {

			if (isNull) {

				hospitalNameTextBox.addStyleName("invalid");
				hospitalNameErrorLabel.setVisible(true);
				hospitalNameErrorLabel.setText("You can't leave this empty ");
				hospitalNameErrorLabel.addStyleName("hospitalerrornamelabel");
			} else if (isInValid) {
				hospitalNameTextBox.addStyleName("invalid");
				hospitalNameErrorLabel.setVisible(true);
				hospitalNameErrorLabel
						.setText("Please enter the hospital name in correct format");
				hospitalNameErrorLabel.addStyleName("hospitalerrornamelabel");

			} else {

				hospitalNameTextBox.removeStyleName("invalid");
				hospitalNameErrorLabel.setVisible(false);
			}
		}

		else if (id.equalsIgnoreCase("checkuploadFile")) {

			if (isNull) {
				checkUploaderrorLabel.setVisible(true);
				checkUploaderrorLabel.setText("Please upload your reports");
				checkUploaderrorLabel
						.addStyleName("checkuploadfileerrornamelabel");
			} else if (isInValid) {
				checkUploaderrorLabel.removeStyleName("invalid");
				checkUploaderrorLabel.setVisible(false);
			}

		} else if(id.equalsIgnoreCase("paymentMode")) {

			if (isNull) {

				paymentErrorLabel.setVisible(true);
				paymentErrorLabel.setText("Please select the payment mode");
				paymentErrorLabel
						.addStyleName("responselabelerrorforbeneficiary");

			} else {

				paymentErrorLabel.setVisible(false);
			}
		}

	}

	public void setRelationToBeneficiaryListBox(boolean value) {
		if (value) {
			namePanel.setVisible(false);
			emailPanel.setVisible(false);
			firstNameTextBox.setValue(null);
			lastNameTextBox.setValue(null);
			emailTextBox.setValue(null);
			//addressPanel.setVisible(true);
		//	phoneNumberPanel.setVisible(true);
			
		}
	}

	public void resetItems() {

		namePanel.setVisible(true);
		emailPanel.setVisible(true);

	}

	public HasValue<String> getAddressLine1TextBox() {
		return addressLine1TextBox;
	}

	public HasValue<String> getAddressLine2TextBox() {
		return addressLine2TextBox;
	}

	public HasValue<String> getZipTextBox() {
		return zipTextBox;
	}

	public HasValue<String> getPhoneNumberTextBox() {
		return phoneNumberTextBox;
	}

	public ListBox getRelationToBeneficiaryListBox() {
		return relationToBeneficiaryListBox;
	}

	public VerticalPanel getEmailPanel() {
		return emailPanel;
	}

	public void setEmailPanel(VerticalPanel emailPanel) {
		this.emailPanel = emailPanel;
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

	public HorizontalPanel getNamePanel() {
		return namePanel;
	}

	public void setNamePanel(HorizontalPanel namePanel) {
		this.namePanel = namePanel;
	}

	public HorizontalPanel getAddressPanel() {
		return addressPanel;
	}

	public void setAddressPanel(HorizontalPanel addressPanel) {
		this.addressPanel = addressPanel;
	}

	public HorizontalPanel getContacPanel() {
		return contactPanel;
	}

	public void setContacPanel(HorizontalPanel contacPanel) {
		this.contactPanel = contacPanel;
	}

	// payment mode
	public RadioButton getChequeButton() {
		return chequeButton;
	}

	public RadioButton getwireTransferButton() {
		return wireTransferButton;
	}

	public HasValue<String> getChequeTextBox() {
		return chequeTextBox;
	}

	public HasValue<String> getAccNoTextBox() {
		return accNoTextBox;
	}

	public HasValue<String> getBankNameTextBox() {
		return bankNameTextBox;
	}

	public HasValue<String> getHolderNameTextBox() {
		return holderNameTextBox;
	}

	public HasValue<String> getIfscTextBox() {
		return ifscTextBox;
	}

	public HasValue<String> getCityTextBox() {
		return cityTextBox;
	}

	public ListBox getStateTextBox() {
		return stateTextBox;
	}

	public HasValue<String> getCityTextBoxForPayment() {
		return cityTextBoxForPayment;
	}

	public HasValue<String> getStateTextBoxForPayment() {
		return stateTextBoxForPayment;
	}

	/**
	 * @return emailTextBox Getter HasValue for
	 */
	public HasValue<String> getdoctorNameTextBox() {
		return doctorNameTextBox;
	}

	/**
	 * @return emailTextBox Getter HasValue for
	 */
	public HasValue<String> getdiseaseNameTextBox() {
		return diseaseNameTextBox;
	}

	/**
	 * @return passwordTextBox Getter HasValue for
	 */
	public HasValue<String> gethospitalNameTextBox() {
		return hospitalNameTextBox;
	}

	public MultiUploader getcheckuploadValidate() {

		return defaultUploader;
	}

	public HasClickHandlers getbackButton() {
		return secondButton;
	}

	/**
	 * @return getStartedButton Getter HasValue for
	 */
	public HasClickHandlers getnextButton() {
		return nextButton;
	}

	public void setNextButtonDisable() {
		secondButton.setEnabled(false);
	}

}