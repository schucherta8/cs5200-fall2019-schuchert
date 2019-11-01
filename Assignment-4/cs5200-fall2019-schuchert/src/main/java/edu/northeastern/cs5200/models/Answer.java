package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private Boolean trueFalseAnswer;
	private Integer multipleChoiceAnswer;
	
	@ManyToOne()
	private Question question;
	
	@ManyToOne()
	private Student student;
	
	public Answer() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Boolean getTrueFalseAnswer() {
		return trueFalseAnswer;
	}

	public void setTrueFalseAnswer(Boolean trueFalseAnswer) {
		this.trueFalseAnswer = trueFalseAnswer;
	}

	public Integer getMultipleChoiceAnswer() {
		return multipleChoiceAnswer;
	}

	public void setMultipleChoiceAnswer(Integer multipleChoiceAnswer) {
		this.multipleChoiceAnswer = multipleChoiceAnswer;
	}
	
}
