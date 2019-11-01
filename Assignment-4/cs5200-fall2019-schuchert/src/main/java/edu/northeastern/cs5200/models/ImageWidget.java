package edu.northeastern.cs5200.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("IMAGE")
public class ImageWidget extends Widget {
	private String src;
	
	public ImageWidget() {}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	
	
}
