package com.invillia.acme.exceptions;

public class ResourceNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String errorMessage) {
	    super(errorMessage);
	}
	
}
