package com.marini.gabriel.services.exceptions;

public class CreateObjectException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CreateObjectException(String msg) {
		super(msg);
	}
	
	public CreateObjectException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
