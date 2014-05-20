package com.jkt.donateme.client.model;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.shared.GWT;
import com.jkt.donateme.client.rpc.PatientDetailService;
import com.jkt.donateme.client.rpc.PatientDetailServiceAsync;

public class ApplicationData {
	private static final ApplicationData dataPane = new ApplicationData(); 
	private PatientDetailServiceAsync serviceFacade = GWT.create(PatientDetailService.class);
	private Map<String,SessionDataHolder> session = new HashMap<String, SessionDataHolder>();
	
	private ApplicationData() {
	}
	
	//on login Success
	public void injectSessionDataHolder(String userId, SessionDataHolder sessionDataHolder) {
		this.session.put(userId, sessionDataHolder) ;
	}
	
	public static ApplicationData getInstance() {
		return dataPane;
	}

	public SessionDataHolder getSessionDataHolder(String userId) {
		return this.session.get(userId);
	}

	public PatientDetailServiceAsync getServiceFacade() {
		return serviceFacade;
	}
}
