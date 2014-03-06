package com.jkt.donateme.client.validation;

public  abstract class Validator {
	
	public String errorMessage;

   public abstract boolean validate(String value);
    

    public abstract String getErrorMessage();

}
