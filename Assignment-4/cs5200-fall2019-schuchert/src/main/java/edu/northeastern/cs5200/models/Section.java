package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Section {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private Integer seats;
	
	@ManyToOne
	@JsonIgnore
	private Faculty teacher;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	@JsonIgnore
	private Course course;
	
	@OneToMany(mappedBy = "section")
	private List<Enrollment> enrollees;
	
	public Section() {}
	
	public Section(String title, Integer seats) {
		this.title = title;
		this.seats = seats;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	public Faculty getTeacher() {
		return teacher;
	}
	public void setTeacher(Faculty teacher) {
		this.teacher = teacher;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Enrollment> getEnrollees() {
		return enrollees;
	}

	public void setEnrollees(List<Enrollment> enrollees) {
		this.enrollees = enrollees;
	}
	
}
