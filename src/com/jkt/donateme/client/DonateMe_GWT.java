package com.jkt.donateme.client;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.jkt.donateme.client.presenter.SignUpPresenter;
import com.jkt.donateme.client.view.SignUpView;


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

		SignUpView display = new SignUpView();
		SignUpPresenter presenter = new SignUpPresenter(display, eventBus);
		
		/*ProfileDetailView display = new ProfileDetailView();
		ProfileDetailPresenter presenter = new ProfileDetailPresenter(display, eventBus);*/
		
		/*BeneficiaryDetailsView display = new BeneficiaryDetailsView();
		BeneficiaryDetailsPresenter presenter = new BeneficiaryDetailsPresenter(display, eventBus);*/
		
	//	HowItWorksView display = new HowItWorksView();
	//	HowItWorksPresenter presenter = new HowItWorksPresenter(display, eventBus);
		//AboutUsView display = new AboutUsView();
		//AboutUsPresenter presenter = new AboutUsPresenter(display, eventBus);
		presenter.bind();

		RootPanel.get("top").add(presenter.getDisplay().asWidget());

	}
}
