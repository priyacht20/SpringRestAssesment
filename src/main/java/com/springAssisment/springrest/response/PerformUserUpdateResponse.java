package com.springAssisment.springrest.response;

import com.springAssisment.springrest.domain.User;

public class PerformUserUpdateResponse extends Response {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UpdateUserResponse [user=" + user + "]";
	}
		
}
