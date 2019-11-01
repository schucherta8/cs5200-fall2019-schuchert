package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends User {
	private Integer gradYear;
	private Long scholarship;
	
	public Student() {}
	
	public Student(String firstName, String lastName, String username, String password,
			Integer gradYear, Long scholarship) {
		super(firstName,lastName,username,password);
		this.gradYear = gradYear;
		this.scholarship = scholarship;
	}
	@OneToMany(mappedBy="student")
	private List<Answer> answers;
	
	@OneToMany(mappedBy="student")//Working on this
	private List<Enrollment> enrollees;
	
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public Integer getGradYear() {
		return gradYear;
	}
	public void setGradYear(Integer gradYear) {
		this.gradYear = gradYear;
	}
	public Long getScholarship() {
		return scholarship;
	}
	public void setScholarship(Long scholarship) {
		this.scholarship = scholarship;
	}

	public List<Enrollment> getEnrollees() {
		return enrollees;
	}

	public void setEnrollees(List<Enrollment> enrollees) {
		this.enrollees = enrollees;
	}
	
}
