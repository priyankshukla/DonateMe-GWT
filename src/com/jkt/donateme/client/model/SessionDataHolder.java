package com.jkt.donateme.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SessionDataHolder implements IsSerializable {
	private ProfileDetailsFields secondScreendetails;
	
	private BeneficiaryDetailsFields beneficiarysessionDetails ;
	
	
	public BeneficiaryDetailsFields getBeneficiarysessionDetails() {
		return beneficiarysessionDetails;
	}
	public void setBeneficiarysessionDetails(
			BeneficiaryDetailsFields beneficiarysessionDetails) {
		
		this.beneficiarysessionDetails = beneficiarysessionDetails;
	//	System.out.println("beneficiarysessionDetails " +beneficiarysessionDetails);
	//	System.out.println(beneficiarysessionDetails.getAddressLine1()+" Address line 1111111");
	}
	public SessionDataHolder() {
		//not required
	}
	public ProfileDetailsFields getSecondScreendetails() {
		return secondScreendetails;
	}

	public void setSecondScreendetails(ProfileDetailsFields secondScreendetails) {
		
		this.secondScreendetails = secondScreendetails;
	}
	
	/*public BeneficiaryDetailsFields getBeneficiaryDetailsFields() {
		System.out.println(getBeneficiaryDetailsFields().getAddressLine1()+"hello");
		return beneficiaryDetailsFields;
	}
	public void setBeneficiaryDetailsFields(
			BeneficiaryDetailsFields beneficiaryDetailsFields) {
		
		this.beneficiaryDetailsFields = beneficiaryDetailsFields;
	}*/

	
}
