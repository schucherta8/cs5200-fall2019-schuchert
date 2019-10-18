package edu.northeastern.cs5200.model;

public class User extends Person {
	private boolean userAgreement;
	
	public User(int id, String firstname, String lastname) {
		super.setId(id);
		super.setFirstName(firstname);
		super.setLastName(lastname);
		/*
		 * What do I do with the rest of the attributes for person?
		 * Do I set them to a default or do I let them become null?
		 */
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
