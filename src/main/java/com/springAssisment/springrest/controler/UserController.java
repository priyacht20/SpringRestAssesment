package com.springAssisment.springrest.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springAssisment.springrest.domain.User;
import com.springAssisment.springrest.response.FindUniqueUserIdResponse;
import com.springAssisment.springrest.response.FindUserListResponse;
import com.springAssisment.springrest.response.PerformUserUpdateResponse;
import com.springAssisment.springrest.services.UserService;


@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "/get/fullList")
	public FindUserListResponse getUsers() {
		return userService.getAllUser();
	}
	
	@GetMapping(value = "/get/uniqueUserIds")
	public FindUniqueUserIdResponse getUniqueUserIds() {
		return userService.getUniqueUser();	
	}
	
	@PostMapping(value = "/updateUser")
	public PerformUserUpdateResponse updateUser(@RequestBody User user) {
		User updateUser = new User();
		updateUser.setId(4);
		updateUser.setTitle("1800Flowers");
		updateUser.setBody("1800Flowers");
		return userService.updateUser(updateUser);	
	}

}
