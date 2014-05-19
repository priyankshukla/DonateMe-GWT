package com.jkt.donateme.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.jkt.donateme.client.model.BeneficiaryDetailsFields;
import com.jkt.donateme.client.model.ProfileDetailsFields;

@RemoteServiceRelativePath("profile")
public interface PatientDetailService extends RemoteService {
	BeneficiaryDetailsFields profileDetailsServer(BeneficiaryDetailsFields beneficiaryDetailsFields)
			throws IllegalArgumentException;
	
	
	

	
//	public ProfileDetailsFields doLogin(BeneficiaryDetailsFields loginModel) throws IllegalArgumentException;
	/*BeneficiaryDetailsFields getUserAlreadyFromSession() throws IllegalArgumentException;
	
	public static class Util
    {
        private static PatientDetailServiceAsync instance;
 
        public static PatientDetailServiceAsync getInstance()
        {
            if (instance == null)
            {
                instance = GWT.create(PatientDetailService.class);
            }
            return instance;
        }
    }*/
 
	//BeneficiaryDetailsFields loginServer(String name, String password);
 
	//BeneficiaryDetailsFields loginFromSessionServer();
     
  //  boolean changePassword(String name, String newPassword);
 
   // void logout();
}
