package com.tyss.Library.exception;

public class BookNotFoundException extends RuntimeException {
	private String message = "Book Not Found";
	
	public BookNotFoundException()
	{
		
	}
	public BookNotFoundException(String message) {
		super();
		this.message = message ;
	}
	
	public String getMessage() {
		return message;
	}
	
}
