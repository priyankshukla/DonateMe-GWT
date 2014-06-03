package com.jkt.donateme.client.validation;

public class EmailValidator extends Validator {

	private final static String string_VALIDATION_REGEX = "([a-zA-Z]+\\s+)*[a-zA-Z]+";

	private final static String integer_VALIDATION_REGEX = "^(0|[1-9][0-9]*)$";

	private final static String ifsc_VALIDATION_REGEX = "^[a-zA-Z]{4}[0]{1}[a-zA-Z0-9]{6}";
	private final static String alphaNumeric_VALIDATION_REGEX = "^[a-zA-Z0-9\\s]*";
	private final static String reason_ON_REGEX = "([a-zA-Z(),.]+\\s+)*[a-zA-Z().,]+";

	public boolean validate(String value) {
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

	public boolean stringValidate(String value) {
		if (value == null) {
			return false;
		}
		return value.matches(string_VALIDATION_REGEX);

	}

	public boolean ifscValidate(String value) {
		if (value == null) {
			return false;
		}

		return value.matches(ifsc_VALIDATION_REGEX);

	}

	public boolean integerValidate(String value) {
		if (value == null) {
			return false;
		}
		return value.matches(integer_VALIDATION_REGEX);

	}

	public boolean alphaNumericCharacters(String value) {
		if (value == null) {
			return false;
		}
		return value.matches(alphaNumeric_VALIDATION_REGEX);
	}

	public boolean isConfirmPassword(String confirmPassword) {

		return false;

	}
	
	public boolean reasonValidate(String value) {
		if (value == null) {
			return false;
		}
		return value.matches(reason_ON_REGEX);

	}
	/*public  boolean doctorNameValidate(String value) {
		if(value==null){
			return false;
		}
		return value.matches(USERNAME_VALIDATION_REGEX);
	
	}
	
	public  boolean hospitalNameValidate(String value) {
		if(value==null){
			return false;
		}
		return value.matches(USERNAME_VALIDATION_REGEX);
	}
	
	public  boolean diseaseNameValidate(String value) {
		if(value==null){
			return false;
		}
		return value.matches(USERNAME_VALIDATION_REGEX);
	}*/

}
