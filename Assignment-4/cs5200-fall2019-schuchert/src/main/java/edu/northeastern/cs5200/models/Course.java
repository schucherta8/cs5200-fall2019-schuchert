package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	
	@ManyToOne
	@JsonIgnore
	private Faculty author;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="course", cascade = CascadeType.ALL,
			orphanRemoval=true)
	private List<Section> sections;
	
	@OneToMany(mappedBy="course")
	private List<Module> modules;
	
	public Course() {}
	
	public Course(String title) {
		this.title = title;
	}
	public Course(String title, Faculty author, List<Section> sections) {
		this.title = title;
		this.author = author;
		this.sections = sections;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Faculty getAuthor() {
		return author;
	}
	public void setAuthor(Faculty author) {
		this.author = author;
	}
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	public void addSection(Section section) {
		sections.add(section);
		section.setCourse(this);
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	
}
