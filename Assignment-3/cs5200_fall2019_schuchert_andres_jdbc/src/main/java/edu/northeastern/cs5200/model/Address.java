package edu.northeastern.cs5200.model;

public class Address {
	private int personId;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zip;
	private Boolean primary;

	public Address(String street1, String street2,
				   String city, String state, String zip, Boolean primary) {
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.primary = primary;
	}

	public Address(int personId, String street1, String street2,
				   String city, String state, String zip, Boolean primary) {
		this.personId = personId;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.primary = primary;
	}

	public int getPersonId(){
		return personId;
	}
	public void setPersonId(int personId){
		this.personId = personId;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public Boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	
	
}
