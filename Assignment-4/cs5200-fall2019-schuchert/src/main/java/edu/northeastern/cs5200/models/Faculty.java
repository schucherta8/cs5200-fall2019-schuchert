package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("FACULTY")
public class Faculty extends User {
	private String office;
	private Boolean tenured;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="author")
	private List<Course> courses;
	
	@OneToMany(mappedBy="teacher")
	private List<Section> sections;
	
	public Faculty() {}
	
	public Faculty(String firstName, String lastName, String username, String password,
			String office, Boolean tenured) {
		super(firstName, lastName, username, password);
		this.office = office;
		this.tenured = tenured;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public Boolean getTenured() {
		return tenured;
	}
	public void setTenured(Boolean tenured) {
		this.tenured = tenured;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
}
