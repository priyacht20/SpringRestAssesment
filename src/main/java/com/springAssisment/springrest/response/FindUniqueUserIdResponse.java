package com.springAssisment.springrest.response;

import java.io.Serializable;

public class FindUniqueUserIdResponse extends Response implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idCount;
	
	

	public Long getIdCount() {
		return idCount;
	}

	public void setIdCount(Long userIdCount) {
		this.idCount = userIdCount;
	}

	@Override
	public String toString() {
		return "UserIdResponse [userIdCount=" + idCount + "]";
	}
}
