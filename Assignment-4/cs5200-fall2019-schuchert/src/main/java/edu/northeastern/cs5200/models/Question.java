package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String question;
	private Integer points;
	
	@ManyToOne
	private QuizWidget quiz;
	
	@OneToMany(mappedBy="question")
	private List<Answer> answers;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public List<Answer> getContainedAnswers() {
		return answers;
	}
	public void setContainedAnswers(List<Answer> containedAnswers) {
		this.answers = containedAnswers;
	}
	public QuizWidget getQuiz() {
		return quiz;
	}
	public void setQuiz(QuizWidget quiz) {
		this.quiz = quiz;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
}
