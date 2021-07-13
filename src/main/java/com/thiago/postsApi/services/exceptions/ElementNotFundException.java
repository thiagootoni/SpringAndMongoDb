package com.thiago.postsApi.services.exceptions;

public class ElementNotFundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ElementNotFundException(String msg) {
		super(msg);
	}

}
