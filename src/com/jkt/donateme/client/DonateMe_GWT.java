package com.jkt.donateme.client;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.jkt.donateme.client.presenter.BeneficiaryDetailsPresenter;
import com.jkt.donateme.client.presenter.SignUpPresenter;
import com.jkt.donateme.client.view.BeneficiaryDetailsView;
import com.jkt.donateme.client.view.SignUpView;
//import com.jkt.donateme.client.presenter.BeneficiaryDetailsPresenter;
//import com.jkt.donateme.client.presenter.ProfileDetailPresenter;
//import com.jkt.donateme.client.presenter.SignUpPresenter;
//import com.jkt.donateme.client.view.BeneficiaryDetailsView;
//import com.jkt.donateme.client.view.ProfileDetailView;
//import com.jkt.donateme.client.view.SignUpView;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class DonateMe_GWT implements EntryPoint {

	/**
	 * This is the entry point method that builds the event bus and display for
	 * the View for the Presenter to bind it to the Widgets to get it displayed
	 * to the UI.
	 */
	public void onModuleLoad() {

		EventBus eventBus = new DefaultEventBus();
	//	ProfileDetailView display = new ProfileDetailView();
	//	ProfileDetailPresenter presenter = new ProfileDetailPresenter(display, eventBus);

		//SignUpView display = new SignUpView();
		//SignUpPresenter presenter = new SignUpPresenter(display, eventBus);
		BeneficiaryDetailsView display = new BeneficiaryDetailsView();
		BeneficiaryDetailsPresenter presenter = new BeneficiaryDetailsPresenter(display, eventBus);
		presenter.bind();

		RootPanel.get("top").add(presenter.getDisplay().asWidget());

	}
}
