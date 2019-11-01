package edu.northeastern.cs5200.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PARAGRAPH")
public class ParagraphWidget extends Widget {
	private String text;
	
	public ParagraphWidget() {}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
