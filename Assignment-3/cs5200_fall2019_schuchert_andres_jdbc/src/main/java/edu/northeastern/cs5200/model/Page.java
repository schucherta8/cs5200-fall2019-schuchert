package edu.northeastern.cs5200.model;

import java.sql.Date;
import java.util.List;

public class Page {
	private int id;
	private int websiteId;
	private String title;
	private String description;
	private Date created;
	private Date updated;
	private Integer views;
	private List<Widget> widgets;
	
	public Page(int id, String title, String description, Date created, Date updated, Integer views) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public void insertWidget(Widget widget) {
		widgets.add(widget);
	}
	public void deleteWidget(Widget widget) {
		widgets.remove(widget);
	}
	
}
