package edu.northeastern.cs5200.model;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

public class Person {
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private Date dob;
	private Collection<Phone> phones;
	private Collection<Address> addresses;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void insertPhone(Phone phone) {
		phones.add(phone);
	}
	public void removePhone(Phone phone) {
		phones.remove(phone);
	}
	public void setPhones(List<Phone> phones){
		this.phones = phones;
	}
	public Collection<Phone> getPhones(){
		return phones;
	}
	public void insertAddress(Address address) {
		addresses.add(address);
	}
	public void removeAddress(Address address) {
		addresses.remove(address);
	}
	public void setAddresses(List<Address> addresses){
		this.addresses = addresses;
	}
	public Collection<Address> getAddresses(){
		return addresses;
	}
	
}
