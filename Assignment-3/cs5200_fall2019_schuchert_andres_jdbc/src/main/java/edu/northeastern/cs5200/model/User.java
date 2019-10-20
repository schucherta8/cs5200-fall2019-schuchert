package edu.northeastern.cs5200.model;

import java.sql.Date;

public class User extends Person {
	private boolean userAgreement;
	
	public User(int id, String firstname, String lastname, String username, String password, String email, Date dob) {
		super.setId(id);
		super.setFirstName(firstname);
		super.setLastName(lastname);
		super.setUsername(username);
		super.setPassword(password);
		super.setEmail(email);
		super.setDob(dob);
		userAgreement = false;
	}
	
	public int getId() {
		return super.getId();
	}
	
	public void setID(int id) {
		super.setId(id);
	}

	public boolean isUserAgreement() {
		return userAgreement;
	}

	public void setUserAgreement(boolean userAgreement) {
		this.userAgreement = userAgreement;
	}
}
