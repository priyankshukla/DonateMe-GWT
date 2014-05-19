package com.jkt.donateme.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jkt.donateme.client.model.BeneficiaryDetailsFields;
import com.jkt.donateme.client.model.SignUpFields;

/**
 * The async counterpart of <code>GreetingService</code>.
 */

public interface SignUpServiceAsync {

	void signUpServer(SignUpFields signUpFields,
			AsyncCallback<SignUpFields> callback)
			throws IllegalArgumentException;
	
	void profileDetailsServer(BeneficiaryDetailsFields beneficiaryDetailsFields,
			AsyncCallback<BeneficiaryDetailsFields> callback)
			throws IllegalArgumentException;
}
