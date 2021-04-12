package com.springAssisment.springrest.services;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springAssisment.springrest.domain.User;
import com.springAssisment.springrest.response.FindUniqueUserIdResponse;
import com.springAssisment.springrest.response.FindUserListResponse;
import com.springAssisment.springrest.response.PerformUserUpdateResponse;


@Service
public class UserServiceIMPL implements UserService {

	
    @Autowired
    private UserDAO userDAO;

	@Override
	public FindUniqueUserIdResponse getUniqueUser() {
		FindUniqueUserIdResponse response = new FindUniqueUserIdResponse();
		try {
			List<User> getAllUserResponse = userDAO.getAllUsers();
			Long uniqueUserIdCount = getAllUserResponse != null ? getAllUserResponse.stream().map(User::getUserId)
					.distinct().count() : null;
			response.setIdCount(uniqueUserIdCount);
			response.setResposeStatus(HttpStatus.OK);
			response.setMessage("Unique User Ids Found");	
		}catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setIdCount(0l);
			response.setResposeStatus(HttpStatus.NOT_FOUND);
		}
		return response;
	}



	@Override
	public FindUserListResponse getAllUser() {
		FindUserListResponse response = new FindUserListResponse();
		List<User> users = userDAO.getAllUsers();
		if (!users.isEmpty()) {
			response.setUser(users.stream().collect(Collectors.toList())); 
			response.setResposeStatus(HttpStatus.FOUND);
			response.setMessage("user list found");
		}else {
			response.setUser(null); 
			response.setResposeStatus(HttpStatus.NOT_FOUND);
			response.setMessage("user list not found");
		}
		return response;
	}



	@Override
	public PerformUserUpdateResponse updateUser(User user) {
		User updatedUser = userDAO.updateUser(user);
		PerformUserUpdateResponse response = new PerformUserUpdateResponse();
		response.setUser(updatedUser);
		if(updatedUser != null) {
			response.setResposeStatus(HttpStatus.OK);
			response.setMessage("User Updated Successfully");
		}else {
			response.setResposeStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage("User Updated Successfully");
		}
		return response;
	}
	
	
	
}
