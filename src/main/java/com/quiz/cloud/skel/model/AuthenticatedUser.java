package com.quiz.cloud.skel.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticatedUser {

	private static final long serialVersionUID = 1L;

	private User user;

	public AuthenticatedUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}


	public Long getId() {
		return user.getId();
	}

	public String getPassword() {
		return user.getPassword();
	}

	public String getUsername() {
		return user.getUsername();
	}

	
	public boolean isEnabled() {
		return user.isEnabled();
	}

}
