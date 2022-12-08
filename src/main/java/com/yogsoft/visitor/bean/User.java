package com.yogsoft.visitor.bean;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {

	private int userId;

	@NotEmpty(message = "First Name should not be empty")
	private String firstName;

	private String lastName;

	private String email;

	@Size(min = 5, max = 10, message = "Enter min 5 and Max 10 character in Password")
	private String password;

	@Size(min = 3, max = 10, message = "Enter min 3 and Max 10 character in User name")
	private String userName;

	@Digits(integer = 10, fraction = 0, message = "Enter valid contact details")
	private String contatNumber;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContatNumber() {
		return contatNumber;
	}

	public void setContatNumber(String contatNumber) {
		this.contatNumber = contatNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", userName=" + userName + ", contatNumber=" + contatNumber + "]";
	}

}
