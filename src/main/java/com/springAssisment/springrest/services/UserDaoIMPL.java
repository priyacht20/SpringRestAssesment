package com.springAssisment.springrest.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.springAssisment.springrest.domain.User;
import com.springAssisment.springrest.util.ApplicationProperty;



@Repository
public class UserDaoIMPL implements UserDAO {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ApplicationProperty applicationProperty;
	
	
	@Override
	public List<User> getAllUsers() {
		ResponseEntity<User[]> responseEntity = restTemplate
				.getForEntity(applicationProperty.getUserUrl(), User[].class);
		if (responseEntity != null && responseEntity.getBody() != null) {
			return Arrays.asList(responseEntity.getBody()); 
		}
		return Collections.emptyList();
	}


	@Override
	public User updateUser(User user) {
		User foundUser = getAllUsers().stream().filter(uPost -> user.getId().equals(uPost.getId()))
				.findFirst().get();
		foundUser.setTitle(user.getTitle());
		foundUser.setBody(user.getBody());
		return foundUser;
	}

}
