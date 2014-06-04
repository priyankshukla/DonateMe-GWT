package com.jkt.donateme.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.RootPanel;
import com.jkt.donateme.client.view.AboutUsView;
import com.jkt.donateme.client.view.ContactUsView;
import com.jkt.donateme.client.view.HomePageView;
import com.jkt.donateme.client.view.HowItWorksView;
import com.jkt.donateme.client.view.SignUpView;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

public class HomePagePresenter extends WidgetPresenter<HomePagePresenter.Display> {
	private boolean isClicked = false;

	public interface Display extends WidgetDisplay {
		
		public Button getHomeButton();
			
		
		

		public Button getContactUsButton();
			
		
		
		public Button getHowItWorksButton();
		
		
		
		public Button getAboutUsButton();
			
		
		public Hyperlink getSignInHyperLink();

	}
	
	
	ClickHandler howItWorksButtonHandler = new ClickHandler() {

		public void onClick(ClickEvent arg0) {

			RootPanel.get("top").clear();
			HowItWorksView display = new HowItWorksView();
			HowItWorksPresenter presenter = new HowItWorksPresenter(display, eventBus);
			presenter.bind();
			RootPanel.get("top").add(presenter.getDisplay().asWidget());;

		}
	};

	
	
	ClickHandler aboutusButtonhandler = new ClickHandler() {

		public void onClick(ClickEvent arg0) {

			RootPanel.get("top").clear();
			AboutUsView display = new AboutUsView();
			AboutUsPresenter presenter = new AboutUsPresenter(display, eventBus);
			presenter.bind();
			RootPanel.get("top").add(presenter.getDisplay().asWidget());;

		}
	};
	
	
	ClickHandler contactusButtonhandler = new ClickHandler() {

		public void onClick(ClickEvent arg0) {

			RootPanel.get("top").clear();
			ContactUsView display = new ContactUsView();
			ContactUsPresenter presenter = new ContactUsPresenter(display, eventBus);
			presenter.bind();
			RootPanel.get("top").add(presenter.getDisplay().asWidget());;

		}
	};
	
	
	ClickHandler signUphandler = new ClickHandler() {

		public void onClick(ClickEvent arg0) {

			RootPanel.get("top").clear();
			SignUpView display = new SignUpView();
			SignUpPresenter presenter = new SignUpPresenter(display, eventBus);
			presenter.bind();
			RootPanel.get("top").add(presenter.getDisplay().asWidget());;

		}
	};

	
	ClickHandler homeButtonhandler = new ClickHandler() {

		public void onClick(ClickEvent arg0) {

			/*RootPanel.get("top").clear();
			HomePageView display = new HomePageView();
			HomePagePresenter presenter = new HomePagePresenter(display, eventBus);
			presenter.bind();
			RootPanel.get("top").add(presenter.getDisplay().asWidget());;*/

			RootPanel.get("top").clear();
		}
	};
	
	
		
	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */

	public HomePagePresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
	}

	@Override
	protected void onBind() {
		// TODO Auto-generated method stub
		display.getHowItWorksButton().addClickHandler(howItWorksButtonHandler);
		display.getHomeButton().addClickHandler(homeButtonhandler);
		display.getAboutUsButton().addClickHandler(aboutusButtonhandler);
		display.getContactUsButton().addClickHandler(contactusButtonhandler);
		display.getSignInHyperLink().addClickHandler(signUphandler);
	}

	@Override
	protected void onUnbind() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onRevealDisplay() {
		// TODO Auto-generated method stub
		
	}

	
}