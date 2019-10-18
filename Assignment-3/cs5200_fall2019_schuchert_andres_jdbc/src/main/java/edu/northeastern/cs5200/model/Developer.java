package edu.northeastern.cs5200.model;

import java.sql.Date;
import java.util.Collection;

public class Developer extends Person {
	private String developerKey;
	private Collection<Website> websites;
	
	@SuppressWarnings("deprecation")
	public Developer(String developerKey,int id, String firstname, String lastname) {
		super.setId(id);
		super.setFirstName(firstname);
		super.setLastName(lastname);
		super.setUsername("Encrypted");
		super.setPassword("Decrypted");
		super.setEmail("throwaway@mail.com");
		super.setDob(new Date(2019,1,1));
		this.developerKey = developerKey;
	}
	public Developer(String developerKey, int id, String firstname,
			String lastname, String username, String password, String email, Date dob) {
		super.setId(id);
		super.setFirstName(firstname);
		super.setLastName(lastname);
		super.setUsername(username);
		super.setPassword(password);
		super.setEmail(email);
		super.setDob(dob);
		this.developerKey = developerKey;
	}
	public int getId() {
		return super.getId();
	}
	public void setId(int id) {
		super.setId(id);
	}
	public String getDeveloperKey() {
		return developerKey;
	}
	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}
	public void insertWebsite(Website website) {
		websites.add(website);
	}
	
	public Collection<Website> getWebsites(){
		return websites;
	}
}
