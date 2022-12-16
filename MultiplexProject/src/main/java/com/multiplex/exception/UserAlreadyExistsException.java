package com.multiplex.exception;

public class UserAlreadyExistsException extends RuntimeException{
private String message;

public UserAlreadyExistsException(String message) {
	super(message);
	this.message=message;
	// TODO Auto-generated constructor stub
}
public UserAlreadyExistsException() {
	
}

}
