package com.ssafy.exceptiontest;

public class PasswordNotMatchException extends Exception {

	public PasswordNotMatchException(String message) {
		super(message);
	}
	
}
