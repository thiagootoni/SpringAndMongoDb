package com.thiago.postsApi.services.exceptions;

public class ElementNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ElementNotFoundException(String msg) {
		super(msg);
	}

}
