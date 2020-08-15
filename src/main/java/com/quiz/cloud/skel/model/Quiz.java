package com.quiz.cloud.skel.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Quiz")
public class Quiz extends AbstractEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    protected Long mId;
	@OneToOne(fetch = FetchType.EAGER, cascade =  CascadeType.ALL, mappedBy = "quiz")
	private User user;
	private String name;
	private String description;

	//@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Question> questions;
	
	

	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	private Date createdDate;
	public Long getId() {
		return mId;
	}
	public void setId(Long mId) {
		this.mId = mId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedDate() {
		return new Date();
	}
	
	public Quiz( String name, String description,Set<Question> q) {
		super();
	
		this.name = name;
		this.description = description;
		this.createdDate = new Date();
		this.questions=q;
	}
	
	
	public Quiz() {
		super();
	}
	@Override
	public String toString() {
		return "Quiz [mId=" + mId + ", user=" + user + ", name=" + name + ", description=" + description
				+ ", createdDate=" + createdDate + "]";
	}
	
	

	
}
