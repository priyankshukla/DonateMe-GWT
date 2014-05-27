package com.jkt.donateme.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.jkt.donateme.client.presenter.HowItWorksPresenter.Display;

public class HowItWorksView extends Composite implements Display{
		
	VerticalPanel mainPanel ; 
	Label pageTagLabel ;
	Label pageHeaderLabel ;
	Label createAPatientAccountLabel ;
	Label createAPatientAccountContentLabel ;
	Label signUpLabel ;
	Label profileDetail ;
	Label signupContent ;
	Label profileDetailContent ;
	Label beneficairyDetailLabel ;
	Label beneficiaryDetailContent;
	Image signupImage ;
	Image profileDetailImage ;
	Image beneficiaryDetailImage;
	public HowItWorksView(){
		
		getPane();
	}
	
	public void getPane(){
		
		mainPanel = new VerticalPanel();
		initWidget(mainPanel);
		
		pageTagLabel = new Label("How It Works");
		pageTagLabel.addStyleName("howitworkpagetaglabel");
		mainPanel.add(pageTagLabel);
		
		
		pageHeaderLabel = new Label("DonateMe is an online platform dedicated to bringing a positive change in the society . " +
				"It's a nonprofit platform to bring together those who want to give and those who are commited to working in the social sector .");
		pageHeaderLabel.addStyleName("contentLabel");
		mainPanel.add(pageHeaderLabel);
		
		 createAPatientAccountLabel = new Label("Creating A Patient Account");
		 createAPatientAccountLabel.addStyleName("stylecreatepatientaccountlabel");
		 mainPanel.add(createAPatientAccountLabel);
	
		 createAPatientAccountContentLabel = new Label("Starting a fundraiser is a big decision that takes courage. " +
		 		"We’re here to make your entire process an easy, joyful and memorable experience." +
		 		" After answering a few questions about the Patient, the person you are raising money for, " +
		 		"and yourself — hit Finish and it will be active .");
		 createAPatientAccountContentLabel.addStyleName("createPatientContent");
		 mainPanel.add(createAPatientAccountContentLabel);
		 
		 signUpLabel = new Label("1.Sign up");
		 signUpLabel.addStyleName("pagelabel");
		 mainPanel.add(signUpLabel);
		 
		 
		 signupImage = new Image("./images/sign-up.png");
		 signupImage.addStyleName("imagestyleforhowitworks");
		 mainPanel.add(signupImage);
		 
		 
		 signupContent = new Label("The patient will fill the basic details and click on the Get Started button." +
		 		"Here the information regarding the patient will be captured.");
		 signupContent.addStyleName("pageContent");
		 mainPanel.add(signupContent);
		 
		 profileDetail = new Label("2.Profile Details"); 
		 profileDetail.addStyleName("pagelabel");
		 mainPanel.add(profileDetail);
		 
		 profileDetailImage = new Image("./images/profile-det.png");
		 profileDetailImage.addStyleName("imagestyleforhowitworks");
		 mainPanel.add(profileDetailImage);
		 
		 profileDetailContent = new Label("Then the patient will complete his profile details by entering the donation amount " +
		 		"and reson for raising the funds .");
		 profileDetailContent.addStyleName("pageContent");
		 mainPanel.add(profileDetailContent);
		 
		 
		 beneficairyDetailLabel = new Label("3.Beneficary Details");
		 beneficairyDetailLabel.addStyleName("pagelabel");
		 mainPanel.add(beneficairyDetailLabel);
		 
		 
		 beneficiaryDetailImage = new Image("./images/ben-detail.png");
		 beneficiaryDetailImage.addStyleName("imagestyleforhowitworks");
		 mainPanel.add(beneficiaryDetailImage);
		 
		 
		 beneficiaryDetailContent = new Label("Then the patient will enter his medical details and upload his medical reports . " +
		 		"He will select the mode of the payment thorugh the money will be donated .");
		 beneficiaryDetailContent.addStyleName("pageContent");
		 mainPanel.add(beneficiaryDetailContent);
		 
	}

}
