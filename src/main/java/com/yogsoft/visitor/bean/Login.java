package com.yogsoft.visitor.bean;

import javax.validation.constraints.Size;

public class Login {

	@Size(min = 3, max = 10, message = "Enter min 3 and Max 10 character in User name")
	private String userName;

	@Size(min = 5, max = 10, message = "Enter min 5 and Max 10 character in Password")
	private String password;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
