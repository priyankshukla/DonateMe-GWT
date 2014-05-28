package com.jkt.donateme.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.jkt.donateme.client.presenter.AboutUsPresenter.Display;

public class AboutUsView extends Composite implements Display {

	VerticalPanel mainPanel;
	Label pageTagLabel;
	Label pageHeaderLabel;
	Label createAPatientAccountLabel;
	Label whatIsDonateMeLabel1;
	Label whatIsDonateMeLabel2;
	Label donateMePlansLabel;
	Label facilitateDonations;
	Label increaseCredibilitylabel;
	Label signupContent;
	Label increaseCredibilityContent;
	Label promoteGivingLabel;
	Label promoteGivingContent;
	Label facilitateDonationContent;
	Image signupImage;
	Image profileDetailImage;
	Image beneficiaryDetailImage;

	public AboutUsView() {

		getPane();
	}

	public void getPane() {

		mainPanel = new VerticalPanel();
		initWidget(mainPanel);

		pageTagLabel = new Label("About Us");
		pageTagLabel.addStyleName("howitworkpagetaglabel");
		mainPanel.add(pageTagLabel);

		createAPatientAccountLabel = new Label("What is DonateMe?");
		createAPatientAccountLabel
				.addStyleName("stylecreatepatientaccountlabel");
		mainPanel.add(createAPatientAccountLabel);

		whatIsDonateMeLabel1 = new Label("DonateMe is an online platform dedicated to bringing a positive change in society. It’s a nonprofit platform to bring together those who want to give and those who are committed to working in the social sector.");
		whatIsDonateMeLabel1.addStyleName("createPatientContentForAboutUs");
		mainPanel.add(whatIsDonateMeLabel1);
		
		whatIsDonateMeLabel2 = new Label(
				 "DonateMe enlists NGOs operating in India and provide them with a platform to showcase their work and reach out to donors. The aim of DonateMe is to bring transparency and professional standards in the nonprofit sector. We focus on few NGOs who have excellent track record in implementing social projects and enlist them after rigorous screening of their projects, financials and governance. We at DonateMe make every effort to give you the best possible options for your donations so that each rupee is well spent on improving the lives of disadvantaged sections of the society.");
		whatIsDonateMeLabel2.addStyleName("createPatientContentForAboutUs");
		mainPanel.add(whatIsDonateMeLabel2);

		donateMePlansLabel = new Label("What does DonateMe plans to acheive?");
		donateMePlansLabel.addStyleName("stylecreatepatientaccountlabel");
		mainPanel.add(donateMePlansLabel);

		donateMePlansLabel = new Label(
				"In the above context, DonateMe aims to identify the voluntary organizations that are doing exemplary work in their chosen fields and provide them with a credible platform to raise funds for their causes. Primarily, the focus of DonateMe is three fold,");
		mainPanel.add(donateMePlansLabel);
		facilitateDonations = new Label("1.FACILITATE DONATIONS");
		facilitateDonations.addStyleName("pagelabelForAboutUs");
		mainPanel.add(facilitateDonations);

		facilitateDonationContent = new Label(
				"Provide a simple and efficient donation mechanism where interested donors can make secure donations to the cause of their choice.  DonateMe processes all the donations through  integrated payment gateway and bank accounts so that every donation can be tracked at each stage and maintain complete transparency.  Furthermore,  online payment has the convenience of anytime and anywhere  donations besides having the lowest cost for fundraising.");
		facilitateDonationContent.addStyleName("pageContentForAboutUs");
		mainPanel.add(facilitateDonationContent);

		increaseCredibilitylabel = new Label("2.INCREASE CRECIBILITY");
		increaseCredibilitylabel.addStyleName("pagelabelForAboutUs");
		mainPanel.add(increaseCredibilitylabel);

		increaseCredibilityContent = new Label(
				"One of the primary objectives of DonateMe is to bring credibility in the nonprofit sector. DonateMe, at every step, maintains complete transparency in donations processing.  DonateMe conducts in-depth analysis of the financials, governance model and projects of the NGOs enlisted so as to ensure that maximum amount of donation is utilized for the beneficiary.");

		increaseCredibilityContent.addStyleName("pageContentForAboutUs");
		mainPanel.add(increaseCredibilityContent);

		promoteGivingLabel = new Label("3.PROMOTE GIVING CULTURE");
		promoteGivingLabel.addStyleName("pagelabelForAboutUs");
		mainPanel.add(promoteGivingLabel);

		promoteGivingContent = new Label(
				"More important than anything else, a positive giving culture is the key for an equitable society. DonateMe aims to promote giving culture through a variety of charity related programs, volunteering, donations-in-kind, events, articles, charity news to have an holistic experience of charity.");
		promoteGivingContent.addStyleName("pageContentForAboutUs");
		mainPanel.add(promoteGivingContent);

	}

}
