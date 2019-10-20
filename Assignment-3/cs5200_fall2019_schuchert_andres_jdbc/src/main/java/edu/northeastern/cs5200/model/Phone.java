package edu.northeastern.cs5200.model;

public class Phone {
	private String phone;
	private Boolean primary;
	private int personId;

	public Phone(String phone, boolean primary){
		this.phone = phone;
		this.primary = primary;
	}
	public Phone(int personId, String phone, boolean primary) {
		this.personId = personId;
		this.phone = phone;
		this.primary = primary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
}
