package com.jkt.donateme.client.view;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.jkt.donateme.client.presenter.HomePagePresenter.Display;

public class HomePageView extends Composite implements Display {
	
	
	private HorizontalPanel headerpanel ;
	private HorizontalPanel pagelinkpanel ;
	private VerticalPanel headerRightPanel ;
	private Label donateMeLabel ;
	private Button homeButton;
	private Button contactUsButton;
	private Button howItWorksButton;
	private Button aboutUsButton;
	private Hyperlink signInHyperLink ;
	
	public HomePageView(){
		
		getHomepageView();
	}
	
	
	public void getHomepageView(){
		headerpanel = new HorizontalPanel();
		initWidget(headerpanel);
		
		
	
		donateMeLabel = new Label("DonateMe");
		donateMeLabel.addStyleName("donateMeStyle");
		headerpanel.add(donateMeLabel);
	
		
		
		pagelinkpanel = new HorizontalPanel();
		pagelinkpanel.addStyleName("styletopbuttonspanel");
		homeButton = new Button("Home");
		homeButton.addStyleName("styletopbuttons");
		contactUsButton = new Button("Contact us");
		contactUsButton.addStyleName("styletopbuttons");

		howItWorksButton = new Button("How it Works");
		howItWorksButton.addStyleName("styletopbuttons");

		aboutUsButton = new Button("About us");
		aboutUsButton.addStyleName("styletopbuttons");

		pagelinkpanel.add(homeButton);
		pagelinkpanel.add(contactUsButton);
		pagelinkpanel.add(howItWorksButton);
		pagelinkpanel.add(aboutUsButton);

		pagelinkpanel.addStyleName("pageLinksStyle");
		headerpanel.add(pagelinkpanel);
		
		
		headerRightPanel = new VerticalPanel();
		HorizontalPanel signInPanel = new HorizontalPanel();
		signInHyperLink = new Hyperlink("Sign Up", "SignUp");
		signInHyperLink.addStyleName("signInStyle");
		Label barLabel = new Label("|");
		Hyperlink logInHyperLink = new Hyperlink("Log In","LogIn");
		logInHyperLink.addStyleName("signInStyle");
		signInPanel.add(signInHyperLink);
		signInPanel.add(barLabel);
		signInPanel.add(logInHyperLink);
		headerRightPanel.add(signInPanel);
		headerRightPanel.addStyleName("headerrightpanelstyle");
		/* MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
		    String[] words = constants.cwSuggestBoxWords();
		    for (int i = 0; i < words.length; ++i) {
		      oracle.add(words[i]);
		    }*/
		SuggestBox searchBox = new SuggestBox(); 
		searchBox.ensureDebugId("Shrutiii");
	
		searchBox.addStyleName("searchStyle");
		searchBox.setText("search");
		headerRightPanel.add(searchBox);
		
	Hyperlink advancedSearch = new Hyperlink("Advanced Search","");
	advancedSearch.addStyleName("advancedSearchstyle");
	headerRightPanel.add(advancedSearch);
		
		headerpanel.add(headerRightPanel);
		
		
		
		
	}
	
	public Button getHomeButton(){
		return homeButton;
	}
	

	public Button getContactUsButton(){
		return contactUsButton;
	}
	
	public Button getHowItWorksButton(){
		return howItWorksButton;
	}
	
	public Button getAboutUsButton(){
		return aboutUsButton;
	}
	
	public Hyperlink getSignInHyperLink(){
		
		return signInHyperLink;
	}
}