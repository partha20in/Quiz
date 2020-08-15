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
@Table(name = "User")
public class User extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Long mId;
	private String email;
	private String username;
	private String password;
	private boolean enabled;
	private Date createdDate;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;
	
	
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public Long getId() {
		return mId;
	}
	public void setId(Long mId) {
		this.mId = mId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public User(Quiz quiz,String email, String username, String password, boolean enabled, Date createdDate) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.createdDate = createdDate;
		this.quiz = quiz;
	}
	public User() {
	 super();
	}
	@Override
	public String toString() {
		return "User [mId=" + mId + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", enabled=" + enabled + ", createdDate=" + createdDate + "]";
	}

	
	

	
	
}