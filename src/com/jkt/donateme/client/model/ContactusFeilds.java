package com.jkt.donateme.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ContactusFeilds implements IsSerializable {
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String message;
	private String email;
	private String phoneNumber;
	
	
	
	
	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
