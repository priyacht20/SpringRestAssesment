package com.springAssisment.springrest.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperty {

	@Value("${user.base.url}")
	private String userUrl;

	public String getUserUrl() {
		return userUrl + "/posts";
	}


	
	
}
