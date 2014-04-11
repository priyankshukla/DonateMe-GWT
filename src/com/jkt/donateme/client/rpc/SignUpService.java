package com.jkt.donateme.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.jkt.donateme.client.model.SignUpFields;

@RemoteServiceRelativePath("greet")
public interface SignUpService extends RemoteService {
	SignUpFields signUpServer(SignUpFields signUpFields)
			throws IllegalArgumentException;
}
