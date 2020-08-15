package com.quiz.cloud.skel.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CorrectAnswer")
public class CorrectAnswer extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Long mId;
	private String username;
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id", nullable = false)
	private Question question;
	private Date createdDate;
	private String correct;
	
	
	
	
	
	
	
	public String getCorrect() {
		return correct;
	}



	public void setCorrect(String correct) {
		this.correct = correct;
	}



	public Long getId() {
		return mId;
	}



	public void setId(Long mId) {
		this.mId = mId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public Question getQuestion() {
		return question;
	}



	public void setQuestion(Question question) {
		this.question = question;
	}



	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = new Date();
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	public CorrectAnswer() {
	 super();
	}



	public CorrectAnswer(String correct,String username, Question question, Date createdDate) {
		super();
		this.correct=correct;
		this.username = username;
		this.question = question;
		this.createdDate = new Date();
	}



	@Override
	public String toString() {
		return "CorrectAnswer [mId=" + mId + ", username=" + username + ", question=" + question + ", createdDate="
				+ createdDate + "]";
	}
	
	
	

	
	

	
	
}