package com.springAssisment.springrest.services;

import com.springAssisment.springrest.domain.User;
import com.springAssisment.springrest.response.FindUniqueUserIdResponse;
import com.springAssisment.springrest.response.FindUserListResponse;
import com.springAssisment.springrest.response.PerformUserUpdateResponse;

public interface UserService {

	public FindUserListResponse getAllUser();
	public FindUniqueUserIdResponse getUniqueUser();
	public PerformUserUpdateResponse updateUser(User user);
	
}
