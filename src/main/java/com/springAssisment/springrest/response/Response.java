package com.springAssisment.springrest.response;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class Response implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus resposeStatus;
	private String message;
	
	public Response() {
	}

	public Response(HttpStatus status, String message) {
		super();
		this.resposeStatus = status;
		this.message = message;
	}

	public HttpStatus getResposeStatus() {
		return resposeStatus;
	}

	public void setResposeStatus(HttpStatus status) {
		this.resposeStatus = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
