package com.quiz.cloud.skel.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Question")
public class Question extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Long mId;
	private String text;
	
	@OneToOne(fetch = FetchType.EAGER)
	private CorrectAnswer correctAnswer;

	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;


	@OneToMany(fetch = FetchType.EAGER)
	private Set<Answer> answers;

	@Column(name = "q_order")
	private Integer order;

	public Long getId() {
		return mId;
	}

	public void setId(Long mId) {
		this.mId = mId;
	}

	public String getText() {
		return text;
	}
    
	
//	public Answer getCorrectAnswer() {
//		return correctAnswer;
//	}
//
//	public void setCorrectAnswer(Answer correctAnswer) {
//		this.correctAnswer = correctAnswer;
//	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public void setText(String text) {
		this.text = text;
	}

//	public Quiz getQuiz() {
//		return quiz;
//	}
//
//	public void setQuiz(Quiz quiz) {
//		this.quiz = quiz;
//	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Question(String text, Quiz quiz, Integer order) {
		super();
		this.text = text;
		this.quiz = quiz;
		this.order = order;
	}

	public Question() {
		super();
	}

	@Override
	public String toString() {
		return "Question [mId=" + mId + ", text=" + text + ", quiz=" + quiz + ", order=" + order + "]";
	}
	
	public int hashCode() {
		return order;
		
	}
	
	public boolean equals(Object ob) {
		Question a=(Question)ob;
		return this.order==a.order;
	}


	
	
	
	

//	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
//	private Calendar createdDate;
//
//	

	
}
