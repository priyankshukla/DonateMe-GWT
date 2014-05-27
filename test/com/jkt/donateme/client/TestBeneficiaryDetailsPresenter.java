/*package com.jkt.donateme.client;

import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.junit.client.GWTTestCase;
import com.jkt.donateme.client.presenter.BeneficiaryDetailsPresenter;
import com.jkt.donateme.client.view.BeneficiaryDetailsView;

public  class TestBeneficiaryDetailsPresenter extends GWTTestCase{
	private EventBus eventBus;
	BeneficiaryDetailsView display;
	BeneficiaryDetailsPresenter presenter;
	
	
	String[] id = { "relationToBeneficiary", "firstNameTextBox",
			"lastNameTextBox", "addressLine1", "addressLine2", "city",
			"state", "zip", "emailId", "phoneNumber","chequeTextBox","accNoTextBox","bankNameTextBox","holderNameTextBox","ifscTextBox","cityTextBox","stateTextBox","paymentMode","doctorNameTextBox","hospitalNameTextBox" ,"diseaseNameTextBox","checkuploadFile"};
	
	
	
	@Override
	public String getModuleName() {
		return "com.jkt.donateme.DonateMe_GWT";
	}
	
	@Override
	protected void gwtSetUp() throws Exception {
		super.gwtSetUp();
		display = new  BeneficiaryDetailsView();
		presenter = new BeneficiaryDetailsPresenter(display, eventBus);
	}
      public void testTextBoxesValuesNotEmpty() {
		
        presenter.getDisplay().getRelationToBeneficiaryListBox().setSelectedIndex(2);
        presenter.getDisplay().getfirstNameTextBox().setValue("ankita");
        presenter.getDisplay().getAccNoTextBox().setValue("12345");
        presenter.getDisplay().getAddressLine1TextBox().setValue("noida");
        presenter.getDisplay().getAddressLine2TextBox().setValue("sector");
        presenter.getDisplay().getBankNameTextBox().setValue("hdfc");
        presenter.getDisplay().getChequeTextBox().setValue("hdfc");
        presenter.getDisplay().getCityTextBox().setValue("delhi");
        presenter.getDisplay().getCityTextBoxForPayment().setValue("noida");
        presenter.getDisplay().getdiseaseNameTextBox().setValue("cancer");
        presenter.getDisplay().getdoctorNameTextBox().setValue("Ankita");
        presenter.getDisplay().getEmailTextBox().setValue("abc.xyz@gmail.com");
        presenter.getDisplay().getHolderNameTextBox().setValue("abcHolderName");
        presenter.getDisplay().gethospitalNameTextBox().setValue("RML Hospital");
        presenter.getDisplay().getIfscTextBox().setValue("aaaa0123456");
        presenter.getDisplay().getlastNameTextBox().setValue("nischal");
        presenter.getDisplay().getPhoneNumberTextBox().setValue("1234567");
        presenter.getDisplay().getStateTextBoxForPayment().setValue("credit");
        presenter.getDisplay().getChequeButton().setValue(true);
        presenter.getDisplay().getZipTextBox().setValue("110027");
		presenter.doValidation(id);
		
		
	
		
		assertEquals("Presenter returning Firstname is same as expected ",
				presenter.getDisplay().getfirstNameTextBox().getValue(),
				presenter.getBenefiaryDetails().getFirstName());
		assertEquals("Presenter returning Account No is same as expected ",
				presenter.getDisplay().getAccNoTextBox().getValue(),
				presenter.getBenefiaryDetails().getAccNumber());
		assertEquals("Presenter returning Address1 is same as expected ",
				presenter.getDisplay().getAddressLine1TextBox().getValue(),
				presenter.getBenefiaryDetails().getAddressLine1());
		assertEquals("Presenter returning Address2 is same as expected ",
				presenter.getDisplay().getAddressLine2TextBox().getValue(),
				presenter.getBenefiaryDetails().getAddressLine2());
		assertEquals("Presenter returning Bank Name is same as expected ",
				presenter.getDisplay().getBankNameTextBox().getValue(),
				presenter.getBenefiaryDetails().getBankName());
		assertEquals("Presenter returning Check info is same as expected ",
				presenter.getDisplay().getChequeTextBox().getValue(),
				presenter.getBenefiaryDetails().getCheque());
		assertEquals("Presenter returning city1 is same as expected ",
				presenter.getDisplay().getCityTextBox().getValue(),
				presenter.getBenefiaryDetails().getCity());
		assertEquals("Presenter returning city 2 for payment is same as expected ",
				presenter.getDisplay().getCityTextBoxForPayment().getValue(),
				presenter.getBenefiaryDetails().getCityName());
		assertEquals("Presenter returning disease name is same as expected ",
				presenter.getDisplay().getdiseaseNameTextBox().getValue(),
				presenter.getBenefiaryDetails().getDiseaseName());
		assertEquals("Presenter returning doctor name is same as expected ",
				presenter.getDisplay().getdoctorNameTextBox().getValue(),
				presenter.getBenefiaryDetails().getDoctorName());
		assertEquals("Presenter returning email id  is same as expected ",
				presenter.getDisplay().getEmailTextBox().getValue(),
				presenter.getBenefiaryDetails().getEmail());
		assertEquals("Presenter returning Holder Name is same as expected ",
				presenter.getDisplay().getHolderNameTextBox().getValue(),
				presenter.getBenefiaryDetails().getHolderName());
		assertEquals("Presenter returning Hospital name is same as expected ",
				presenter.getDisplay().gethospitalNameTextBox().getValue(),
				presenter.getBenefiaryDetails().getHospitalName());
		assertEquals("Presenter returning IFSC code is same as expected ",
				presenter.getDisplay().getIfscTextBox().getValue(),
				presenter.getBenefiaryDetails().getIfscCode());
		assertEquals("Presenter returning Last name is same as expected ",
				presenter.getDisplay().getlastNameTextBox().getValue(),
				presenter.getBenefiaryDetails().getLastName());
		assertEquals("Presenter returning phone number is same as expected ",
				presenter.getDisplay().getPhoneNumberTextBox().getValue(),
				presenter.getBenefiaryDetails().getPhoneNumber());
		assertEquals("Presenter returning State is same as expected ",
				presenter.getDisplay().getStateTextBoxForPayment().getValue(),
				presenter.getBenefiaryDetails().getStateName());
		assertEquals("Presenter returningZIp number same as expected ",
				presenter.getDisplay().getZipTextBox().getValue(),
				presenter.getBenefiaryDetails().getZip());
	}
      
     public void testBenefiaryDetailsViewBinding() {
  		presenter.bind();
  		presenter.doValidation(id);
  		presenter.getBenefiaryDetails();
  		
  		assertNotNull("Benifiary fields never returns null",
  				presenter.getBenefiaryDetails());
  	}
     
     public void testWhenUserDoNotEnterValues() {
    	 presenter.getDisplay().getRelationToBeneficiaryListBox().setSelectedIndex(0);
         presenter.getDisplay().getfirstNameTextBox().setValue(null);
         presenter.getDisplay().getAccNoTextBox().setValue(null);
         presenter.getDisplay().getAddressLine1TextBox().setValue(null);
         presenter.getDisplay().getAddressLine2TextBox().setValue(null);
         presenter.getDisplay().getBankNameTextBox().setValue(null);
         presenter.getDisplay().getChequeTextBox().setValue(null);
         presenter.getDisplay().getCityTextBox().setValue(null);
         presenter.getDisplay().getCityTextBoxForPayment().setValue(null);
         presenter.getDisplay().getdiseaseNameTextBox().setValue(null);
         presenter.getDisplay().getdoctorNameTextBox().setValue(null);
         presenter.getDisplay().getEmailTextBox().setValue(null);
         presenter.getDisplay().getHolderNameTextBox().setValue(null);
         presenter.getDisplay().gethospitalNameTextBox().setValue(null);
         presenter.getDisplay().getIfscTextBox().setValue(null);
         presenter.getDisplay().getlastNameTextBox().setValue(null);
         presenter.getDisplay().getPhoneNumberTextBox().setValue(null);
         presenter.getDisplay().getStateTextBoxForPayment().setValue(null);
         presenter.getDisplay().getChequeButton().setValue(null);
         presenter.getDisplay().getZipTextBox().setValue(null);
         presenter.doValidation(id);
         assertNull(presenter.getBenefiaryDetails().getFirstName());
         assertNull(presenter.getBenefiaryDetails().getAccNumber());
         assertNull(presenter.getBenefiaryDetails().getAddressLine1());
         assertNull(presenter.getBenefiaryDetails().getAddressLine2());
         assertNull(presenter.getBenefiaryDetails().getBankName());

         assertNull(presenter.getBenefiaryDetails().getCheque());

         assertNull(presenter.getBenefiaryDetails().getCity());
         assertNull(presenter.getBenefiaryDetails().getCityName());
         assertNull(presenter.getBenefiaryDetails().getDiseaseName());
         assertNull(presenter.getBenefiaryDetails().getDoctorName());
         assertNull(presenter.getBenefiaryDetails().getEmail());
         assertNull(presenter.getBenefiaryDetails().getHolderName());
         assertNull(presenter.getBenefiaryDetails().getHospitalName());
         assertNull(presenter.getBenefiaryDetails().getIfscCode());
         assertNull(presenter.getBenefiaryDetails().getLastName());
         assertNull(presenter.getBenefiaryDetails().getPhoneNumber());
         assertNull(presenter.getBenefiaryDetails().getStateName());
         assertNull(presenter.getBenefiaryDetails().getZip());

     }
     
     public void testTextBoxesValuesAreInvalid() {
 		
         presenter.getDisplay().getRelationToBeneficiaryListBox().setSelectedIndex(0);
         presenter.getDisplay().getfirstNameTextBox().setValue("4555");
         presenter.getDisplay().getAccNoTextBox().setValue("fff");
         presenter.getDisplay().getAddressLine1TextBox().setValue("5555");
         presenter.getDisplay().getAddressLine2TextBox().setValue("5555");
         presenter.getDisplay().getBankNameTextBox().setValue("5555");
         presenter.getDisplay().getChequeTextBox().setValue("5555");
         presenter.getDisplay().getCityTextBox().setValue("5555");
         presenter.getDisplay().getCityTextBoxForPayment().setValue("5555");
         presenter.getDisplay().getdiseaseNameTextBox().setValue("5555");
         presenter.getDisplay().getdoctorNameTextBox().setValue("5555");
         presenter.getDisplay().getEmailTextBox().setValue("abc.@@..xyz@gmail.com");
         presenter.getDisplay().getHolderNameTextBox().setValue("7777");
         presenter.getDisplay().gethospitalNameTextBox().setValue("5555");
         presenter.getDisplay().getIfscTextBox().setValue("555555");
         presenter.getDisplay().getlastNameTextBox().setValue("5555");
         presenter.getDisplay().getPhoneNumberTextBox().setValue("bhmj");
         presenter.getDisplay().getStateTextBoxForPayment().setValue("6666");
         presenter.getDisplay().getChequeButton().setValue(true);
         presenter.getDisplay().getZipTextBox().setValue("jjjj");
 		presenter.doValidation(id);
 		
 		
 	
 		
 		assertNotSame("Presenter returning Firstname is same as expected ",
 				presenter.getDisplay().getfirstNameTextBox().getValue(),
 				presenter.getBenefiaryDetails().getFirstName());
 		assertNotSame("Presenter returning Account No is same as expected ",
 				presenter.getDisplay().getAccNoTextBox().getValue(),
 				presenter.getBenefiaryDetails().getAccNumber());
 		assertNotSame("Presenter returning Address1 is same as expected ",
 				presenter.getDisplay().getAddressLine1TextBox().getValue(),
 				presenter.getBenefiaryDetails().getAddressLine1());
 		assertNotSame("Presenter returning Address2 is same as expected ",
 				presenter.getDisplay().getAddressLine2TextBox().getValue(),
 				presenter.getBenefiaryDetails().getAddressLine2());
 		assertNotSame("Presenter returning Bank Name is same as expected ",
 				presenter.getDisplay().getBankNameTextBox().getValue(),
 				presenter.getBenefiaryDetails().getBankName());
 		assertNotSame("Presenter returning Check info is same as expected ",
 				presenter.getDisplay().getChequeTextBox().getValue(),
 				presenter.getBenefiaryDetails().getCheque());
 		assertNotSame("Presenter returning city1 is same as expected ",
 				presenter.getDisplay().getCityTextBox().getValue(),
 				presenter.getBenefiaryDetails().getCity());
 		assertNotSame("Presenter returning city 2 for payment is same as expected ",
 				presenter.getDisplay().getCityTextBoxForPayment().getValue(),
 				presenter.getBenefiaryDetails().getCityName());
 		assertNotSame("Presenter returning disease name is same as expected ",
 				presenter.getDisplay().getdiseaseNameTextBox().getValue(),
 				presenter.getBenefiaryDetails().getDiseaseName());
 		assertNotSame("Presenter returning doctor name is same as expected ",
 				presenter.getDisplay().getdoctorNameTextBox().getValue(),
 				presenter.getBenefiaryDetails().getDoctorName());
 		assertNotSame("Presenter returning email id  is same as expected ",
 				presenter.getDisplay().getEmailTextBox().getValue(),
 				presenter.getBenefiaryDetails().getEmail());
 		assertNotSame("Presenter returning Holder Name is same as expected ",
 				presenter.getDisplay().getHolderNameTextBox().getValue(),
 				presenter.getBenefiaryDetails().getHolderName());
 		assertNotSame("Presenter returning Hospital name is same as expected ",
 				presenter.getDisplay().gethospitalNameTextBox().getValue(),
 				presenter.getBenefiaryDetails().getHospitalName());
 		assertNotSame("Presenter returning IFSC code is same as expected ",
 				presenter.getDisplay().getIfscTextBox().getValue(),
 				presenter.getBenefiaryDetails().getIfscCode());
 		assertNotSame("Presenter returning Last name is same as expected ",
 				presenter.getDisplay().getlastNameTextBox().getValue(),
 				presenter.getBenefiaryDetails().getLastName());
 		assertNotSame("Presenter returning phone number is same as expected ",
 				presenter.getDisplay().getPhoneNumberTextBox().getValue(),
 				presenter.getBenefiaryDetails().getPhoneNumber());
 		assertNotSame("Presenter returning State is same as expected ",
 				presenter.getDisplay().getStateTextBoxForPayment().getValue(),
 				presenter.getBenefiaryDetails().getStateName());
 		assertNotSame("Presenter returningZIp number same as expected ",
 				presenter.getDisplay().getZipTextBox().getValue(),
 				presenter.getBenefiaryDetails().getZip());
 	}
	
	
	
	
	

}
*/