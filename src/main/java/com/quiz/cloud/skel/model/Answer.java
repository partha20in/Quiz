package com.quiz.cloud.skel.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Answer")
public class Answer extends AbstractEntity implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Long mId;
	@Size(min = 1, max = 50, message = "The answer should be less than 50 characters")
	@NotNull(message = "No answer text provided.")
	private String text;

	@ManyToOne(fetch = FetchType.EAGER)
	private Question question;

	@Column(name = "a_order")
	private Integer order;

	
	private Date createdDate;


	public Long getId() {
		return mId;
	}


	public void setId(Long mId) {
		this.mId = mId;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


//	public Question getQuestion() {
//		return question;
//	}
//
//
//	public void setQuestion(Question question) {
//		this.question = question;
//	}


	public Integer getOrder() {
		return order;
	}


	public void setOrder(Integer order) {
		this.order = order;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = new Date();
	}


	public Answer() {
		super();
	}


	public Answer(
			@Size(min = 1, max = 50, message = "The answer should be less than 50 characters") @NotNull(message = "No answer text provided.") String text,
			Integer order) {
		super();
		this.text = text;
		this.order = order;
	}

	public int hashCode() {
		return order;
		
	}
	
	public boolean equals(Object ob) {
		Answer a=(Answer)ob;
		return this.order==a.order;
	}

	@Override
	public String toString() {
		return "Answer [mId=" + mId + ", text=" + text + ", question=" + question + ", order=" + order
				+ ", createdDate=" + createdDate + "]";
	}
	
	

	

}
