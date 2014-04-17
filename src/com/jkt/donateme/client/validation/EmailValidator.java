package com.jkt.donateme.client.validation;




public class EmailValidator extends Validator{

	private final static String USERNAME_VALIDATION_REGEX = "([a-zA-Z]+\\s+)*[a-zA-Z]+";
	
	private final static String DonationAmount_VALIDATION_REGEX = "^(0|[1-9][0-9]*)$";
	
	public  boolean validate(String value) {
	    if (value.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
	        errorMessage = "";
	        return true;
	    } else {
	        errorMessage = "Enter valid email Id";
	        return false;
	    }
	}
	
	public String getErrorMessage() {
	    return errorMessage;
	 }
	
	public  boolean usernameValidate(String value) {
		if(value==null){
			return false;
		}
		return value.matches(USERNAME_VALIDATION_REGEX);
	
	}
	
	
	public  boolean donationAmountValidate(String value) {
		if(value==null){
			return false;
		}
		return value.matches(DonationAmount_VALIDATION_REGEX);
	
	}
	
	
	public boolean isConfirmPassword(String confirmPassword){
		
		return false;
		
	}
	
	
	
}
	
	


