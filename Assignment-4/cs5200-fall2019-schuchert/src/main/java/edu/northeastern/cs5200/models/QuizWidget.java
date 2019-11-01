package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("QUIZ")
public class QuizWidget extends Widget {
	public QuizWidget() {
		super.setType("QUIZ");
	}
	
	@OneToMany(mappedBy="quiz")
	private List<Question> questions;

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
