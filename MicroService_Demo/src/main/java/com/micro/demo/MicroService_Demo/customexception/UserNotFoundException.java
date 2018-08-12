package com.micro.demo.MicroService_Demo.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5052332452451393857L;

	public UserNotFoundException(String message) {
		super(message);
		
	}

		
}
