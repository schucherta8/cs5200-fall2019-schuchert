package edu.northeastern.cs5200.model;

import java.sql.Date;
import java.util.List;

public class Website {
	private int id;
	private int developerId;
	private String name;
	private String description;
	private Date created;
	private Date updated;
	private Integer visits;
	List<Page> pages;
	
	public Website(int id, String name, String description, Date created, Date updated, Integer visits) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Integer getVisits() {
		return visits;
	}
	public void setVisits(Integer visits) {
		this.visits = visits;
	}
	public void insertPage(Page page) {
		pages.add(page);
	}
	public void deletePage(Page page) {
		pages.remove(page);
	}
	
}
