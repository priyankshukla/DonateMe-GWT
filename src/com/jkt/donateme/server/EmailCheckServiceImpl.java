package com.jkt.donateme.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.jkt.donateme.client.model.PatientClientImpl;
import com.jkt.donateme.client.rpc.EmailCheckService;

@SuppressWarnings("serial")
public class EmailCheckServiceImpl extends RemoteServiceServlet implements
		EmailCheckService {

	public Boolean validateDuplicateEmail(String email) {
		return PatientClientImpl.getInstance().validateEmail(email);
	}

}
