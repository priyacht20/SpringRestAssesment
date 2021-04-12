package com.springAssisment.springrest.response;

import java.util.List;

import com.springAssisment.springrest.domain.User;



public class FindUserListResponse extends Response {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<User> user;

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
       
    
}
