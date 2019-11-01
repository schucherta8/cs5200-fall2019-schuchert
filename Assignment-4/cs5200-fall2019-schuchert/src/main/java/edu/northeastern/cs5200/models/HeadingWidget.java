package edu.northeastern.cs5200.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("HEADING")
public class HeadingWidget extends Widget {
	private Integer size;
	
	public HeadingWidget() {}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
}
