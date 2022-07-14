package com.fashion.server.exceptions;

public class ObjectAlreadyExitsException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjectAlreadyExitsException() {
		super();
	}

	public ObjectAlreadyExitsException(String name) {
		super(String.format("%s already exists !", name));
	}
	
}
