package com.jkt.donateme.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.jkt.donateme.client.model.PatientClientImpl;
import com.jkt.donateme.client.model.SignUpFields;
import com.jkt.donateme.client.rpc.SignUpService;

@SuppressWarnings("serial")
public class PatientDetailServiceImpl extends RemoteServiceServlet implements
		SignUpService {

	/**
	 * @return SignUpFields
	 * 
	 */
	public SignUpFields signUpServer(SignUpFields signUpFields)
			throws IllegalArgumentException {
		PatientClientImpl.getInstance().registerPatient(signUpFields);

		return signUpFields;
	}

}
