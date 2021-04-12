package com.springAssisment.springrest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.springAssisment.springrest.controler.UserController;
import com.springAssisment.springrest.domain.User;
import com.springAssisment.springrest.response.FindUniqueUserIdResponse;
import com.springAssisment.springrest.response.FindUserListResponse;
import com.springAssisment.springrest.response.PerformUserUpdateResponse;
import com.springAssisment.springrest.services.UserDAO;
import com.springAssisment.springrest.services.UserService;




@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserRestControllerTest {
	
	@InjectMocks
	private UserController userController;
	
	@Mock
	private UserService userService;
	
	@Mock
	private UserDAO userDAO;
	
	@Value("${local.server.port}")
    private Integer port;
	
	public final String BASE_URL = "http://localhost:9049/springrest";

	public String getBaseUrl() {
		return BASE_URL.replace("9049", port.toString());
	}

	@Test
	void testGetUser() {
		FindUserListResponse response = new FindUserListResponse();
		response.setUser(new ArrayList<>());
		response.setResposeStatus(HttpStatus.FOUND);
		response.setMessage("Unique User Ids Found");	
		when(userService.getAllUser()).thenReturn(response);
		assertEquals(HttpStatus.FOUND, userController.getUsers().getResposeStatus());
	}
	
	@Test
	void testGetUserWithException() {
		FindUserListResponse response = new FindUserListResponse();
		response.setUser(new ArrayList<>());
		response.setResposeStatus(HttpStatus.NOT_FOUND);
		response.setMessage("Unique User Ids Found");	
		when(userService.getAllUser()).thenReturn(response);
		assertEquals(HttpStatus.NOT_FOUND, userController.getUsers().getResposeStatus());
	}

	@Test
	void testGetUniqueUserIds() {
		FindUniqueUserIdResponse response = new FindUniqueUserIdResponse();
		response.setIdCount(1l);
		response.setResposeStatus(HttpStatus.OK);
		response.setMessage("Unique User Ids Found");	
		when(userService.getUniqueUser()).thenReturn(response);
		assertEquals(HttpStatus.OK, userController.getUniqueUserIds().getResposeStatus());   
	}
	
	@Test
	public void updateUser() {
		RestTemplate restTemplate = new RestTemplate();
		final String updateUserUrl = getBaseUrl() + "/user/updateUser";
		User user = new User();
		ResponseEntity<PerformUserUpdateResponse> updateResponse = restTemplate.postForEntity(updateUserUrl, user, PerformUserUpdateResponse.class);
		assertEquals(HttpStatus.OK, updateResponse.getBody().getResposeStatus()); 
	}

}
