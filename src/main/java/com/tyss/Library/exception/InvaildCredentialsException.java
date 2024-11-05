package com.tyss.Library.exception;

public class InvaildCredentialsException extends RuntimeException {
	private String message = "Invalid email and password";

	public InvaildCredentialsException()
	{

	}
	public InvaildCredentialsException(String message) {
		super();
		this.message = message ;
	}

	public String getMessage() {
		return message;
	}

}
