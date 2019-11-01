package edu.northeastern.cs5200.models;

public class MultipleChoice extends Question {

	private String choices;
	private Integer correct;
	
	public MultipleChoice() {}

	public String getChoices() {
		return choices;
	}

	public void setChoices(String choices) {
		this.choices = choices;
	}

	public Integer getCorrect() {
		return correct;
	}

	public void setCorrect(Integer correct) {
		this.correct = correct;
	}
	
	
}
