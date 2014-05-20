package com.jkt.donateme.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jkt.donateme.client.model.BeneficiaryDetailsFields;
import com.jkt.donateme.client.model.ProfileDetailsFields;

/**
 * The async counterpart of <code>GreetingService</code>.
 */

public interface PatientDetailServiceAsync {

	void profileDetailsServer(BeneficiaryDetailsFields beneficiaryDetailsFields,
			AsyncCallback<BeneficiaryDetailsFields> callback)
			throws IllegalArgumentException;
	
	/*void  getUserAlreadyFromSession(AsyncCallback<BeneficiaryDetailsFields> callback)
			throws IllegalArgumentException;*/
	/*void doLogin(BeneficiaryDetailsFields beneficiaryDetailsFields,
			AsyncCallback<BeneficiaryDetailsFields> callback)
			throws IllegalArgumentException;*/
	/*void doLogin(BeneficiaryDetailsFields loginModel ,AsyncCallback<ProfileDetailsFields> callback)
			throws IllegalArgumentException;*/

}
