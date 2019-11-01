package edu.northeastern.cs5200.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("YOUTUBE")
public class YouTubeWidget extends Widget {
	
	private String youTubeId;
	
	public YouTubeWidget() {
		super.setType("YOUTUBE");
	}

	public String getYouTubeId() {
		return youTubeId;
	}

	public void setYouTubeId(String youTubeId) {
		this.youTubeId = youTubeId;
	}
	
	
}
